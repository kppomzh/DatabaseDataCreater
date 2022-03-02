package com.zhzm.utils;

import com.facebook.presto.jdbc.internal.jackson.core.JsonProcessingException;
import com.facebook.presto.jdbc.internal.jackson.databind.ObjectMapper;
import com.zhzm.datacreater.factory.IndexCreaterFactory;
import com.zhzm.datacreater.factory.TypeCreaterFactory;
import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.datacreater.typecreater.Advanced.ForeignKey;
import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.exceptions.TableLoopRelyException;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InsertPlanMaker {
    private Map<String, TableStructure> sortMapper;
    private boolean close;
    private Lock lock = new ReentrantLock();
    private Map<String, List<TableMaker>> makerMap;

    public InsertPlanMaker() {
        close = false;
        makerMap = new LinkedHashMap<>();
    }

    public TableStructure getObject(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TableStructure structure = mapper.readValue(json, TableStructure.class);
        return structure;
    }

    public Collection<List<TableMaker>> transCenter(Collection<TableStructure> tableStructures) throws TableLoopRelyException {
        close = true;
        lock.unlock();
        Map<String, TableStructure> mapper = new HashMap<>();
        for (TableStructure table : tableStructures) {
            mapper.put(table.getFullTableName(), table);
        }
        RelyCalculation rely = new RelyCalculation(mapper);
        sortMapper = rely.makeNodeMap();

        for (Map.Entry<String, TableStructure> entry : sortMapper.entrySet()) {
            makerMap.put(entry.getKey(), transMsg(entry.getValue()));
        }

        return makerMap.values();
    }

    public List<TableMaker> transMsg(TableStructure structure) {
        //threadNum：该表需要用多少线程完成
        //checkNum：每个线程至少要生成多少数据
        int threadNum = Integer.parseInt(BaseEnvironment.getEnvironment("threads")),
                checkNum=Integer.parseInt(BaseEnvironment.getEnvironment("defaultCreateNum","100"));
        if(BaseEnvironment.getEnvironment("longerInsert").equals("true")){
            //将checkNum改为longerInsertNumber
            checkNum=Integer.parseInt(BaseEnvironment.getEnvironment("longerInsertNumber"));
        }
        //如果生成数除以线程数小于至少生成的数据的话，则减少线程数
        if(structure.getLinenum()/checkNum<threadNum){
            threadNum= (int) (structure.getLinenum()/checkNum);
            if(threadNum<1){
                threadNum=1;
            }
        }
        TableMaker[] makers = new TableMaker[threadNum];
        TableMaker maker = new TableMaker(structure.getTableName(),structure.isUnmake());
        //推算每一个maker的生成数，向上取整
        double sublinenumber=Math.ceil(structure.getLinenum()/checkNum),linenumber=structure.getLinenum();

        while (structure.hasNext()) {
            ListStructure listStructure = structure.getNextStruc();
            if (listStructure.isForeign()) {
                baseTypeCreaterImpl foreign = makerMap.get(listStructure.getForeignTable()).get(0)
                        .getFieldTypeCreater(listStructure.getForeignList());
                maker.addList(listStructure.getListname(), new ForeignKey(foreign), listStructure.isRely());
            } else if(listStructure.isPrimary()){
                maker.addPrimaryList(listStructure.getListname(), TypeCreaterFactory.getTypeCreater(listStructure), listStructure.isRely());
            }else
                maker.addList(listStructure.getListname(), TypeCreaterFactory.getTypeCreater(listStructure), listStructure.isRely());
        }

        maker.setIndexes(IndexCreaterFactory.getIndexesCreater(structure.getIndexes()));

        for (int i = 0; i < threadNum; i++) {
            makers[i]= (TableMaker) maker.clone();
            makers[i].setLinenumber(Math.min(linenumber, sublinenumber));
            linenumber-=sublinenumber;
        }

        return Arrays.asList(makers);
    }

    public boolean isClose() {
        if (lock.tryLock())
            return close;
        else
            return true;
    }
}
