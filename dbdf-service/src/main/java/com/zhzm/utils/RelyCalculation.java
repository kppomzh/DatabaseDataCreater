package com.zhzm.utils;

import com.zhzm.datacreater.typecreater.Advanced.ForeignKey;
import com.zhzm.datastructure.base.NodeMap;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.exceptions.ForeignTableRelyException;
import com.zhzm.exceptions.TableLoopRelyException;

import java.util.List;
import java.util.Map;

/**
 * 用于计算不同表之间的外键依赖关系，并且会排好执行顺序
 */
public class RelyCalculation {
    private Map<String, TableStructure> tss;
    private NodeMap<TableStructure> map;

    public RelyCalculation(Map<String, TableStructure> tss) {
        this.tss = tss;
        map = new NodeMap<>();
    }

    public Map<String, TableStructure> makeNodeMap() throws ForeignTableRelyException, TableLoopRelyException {
        for (Map.Entry<String, TableStructure> ts : tss.entrySet()) {
            map.addNode(ts.getKey(), ts.getValue());

        }

        for (Map.Entry<String, TableStructure> ts : tss.entrySet()) {
            calculationTreeNode(ts.getValue());
        }

        Map<String, TableStructure> listmap=map.getSortListMap();
        setForeignRely(listmap);
        return listmap;
    }

    private void calculationTreeNode(TableStructure ts) throws ForeignTableRelyException, TableLoopRelyException {
        if (ts.hasForeign()) {
            List<String> foreignRelyTable = ts.getForeignRelyTable();
            for (String table : foreignRelyTable) {
                map.relatedNode(table, ts.getTableName());
            }
        }
    }

    private void setForeignRely(Map<String, TableStructure> map) {
        for (TableStructure ts : map.values()) {
            if(ts.hasForeign()) {
                while (ts.hasNext()) {
                    ListStructure ls=ts.getNextStruc();
                    if(ls.isForeign()){
                        String foreignTable=ls.getForeignTable(),
                                foreignList=ls.getForeignList();
                        ListStructure rely=map.get(foreignTable)
                                .getStructureList(foreignList);
                        rely.setRely();
//                        ls.setCreater(new ForeignKey(rely));
                        //error
                    }
                }
            }
        }
    }
}
