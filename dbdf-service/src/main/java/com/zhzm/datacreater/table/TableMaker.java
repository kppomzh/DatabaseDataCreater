package com.zhzm.datacreater.table;

import com.zhzm.datacreater.table.index.BaseIndex;
import com.zhzm.datacreater.typecreater.Advanced.RelyTypeCreater;
import com.zhzm.datacreater.typecreater.baseTypeCreaterImpl;
import com.zhzm.utils.privateRandom;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableMaker implements Cloneable{
    private Map<String, baseTypeCreaterImpl> listCreaterMap;
    private String tablename,listnamessb;
    private List<BaseIndex> indexes;
    private Double linenumber;
    private baseTypeCreaterImpl primaryCreater;

    public TableMaker(String tablename,boolean hasUnmake){
        this.tablename=tablename;
        listCreaterMap=new LinkedHashMap<>();
        listnamessb=hasUnmake?null:"";
        primaryCreater=null;
    }

    public void addPrimaryList(String listname, baseTypeCreaterImpl typeCreater, boolean rely) {
        addList(listname, typeCreater, rely);
        primaryCreater=listCreaterMap.get(listname);
    }

    public void addList(String listname, baseTypeCreaterImpl creater,boolean isRely){
        if(isRely)
        {
            creater=new RelyTypeCreater(creater);
        }
        listCreaterMap.put(listname,creater);
    }

    public int size(){
        return listCreaterMap.size();
    }

    public String getListnamessb(){
        if(listnamessb==null){
            StringBuilder sb=new StringBuilder("(");
            for (String listname:listCreaterMap.keySet()) {
                sb.append(listname);
                sb.append(',');
            }
            sb.deleteCharAt(listnamessb.length()-1).append(')');
        }
        return listnamessb;
    }

    public Map<String,String> getLineContent(){
        Map<String,String> content=new LinkedHashMap<>();

        for (Map.Entry<String, baseTypeCreaterImpl> entry:listCreaterMap.entrySet()) {
            content.put(entry.getKey(),entry.getValue().getString());
        }

        for (int i = 0; i < indexes.size(); i++) {
            BaseIndex index=indexes.get(i);
            String[] involved=index.getInvolvedLists();
            String[] invContent=new String[involved.length];
            for (int j = 0; j < involved.length; j++) {
                invContent[j]= content.get(involved[i]);
            }
            int canAdd=index.addLine(invContent);
            while (canAdd!=-1){
                int updateIndex;
                if(canAdd==-2){
                    updateIndex= privateRandom.RandomInteger(0,involved.length);
                }
                else
                    updateIndex=canAdd;

                invContent[updateIndex]=listCreaterMap.get(involved[updateIndex]).getString();
                canAdd=index.addLine(invContent);
            }
        }//warning，此处检查不够严格，无法绝对保证所有的数据满足所有的约束；然而对于正常的约束来说这样处理之后还不满足的概率已经比较小了

        return content;
    }

    public String getTablename() {
        return tablename;
    }

    public void setIndexes(List<BaseIndex> indexes) {
        this.indexes = indexes;
    }

    public baseTypeCreaterImpl getFieldTypeCreater(String listname){
        return this.listCreaterMap.get(listname);
    }

    public void setLinenumber(Double linenumber) {
        this.linenumber = linenumber;
    }

    public Double getLinenumber() {
        return linenumber;
    }

    public Object clone(){
        TableMaker newMaker=new TableMaker(this.tablename,!"".equals(this.listnamessb));

        newMaker.listCreaterMap=this.listCreaterMap;
        newMaker.setIndexes(this.indexes);

        return newMaker;
    }

}

