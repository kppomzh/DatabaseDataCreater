package com.zhzm.datacreater.factory;

import com.zhzm.datacreater.table.index.BaseIndex;
import com.zhzm.datacreater.table.index.CheckKey;
import com.zhzm.datacreater.table.index.ForeignKey;
import com.zhzm.datacreater.table.index.Uniquekey;
import com.zhzm.datastructure.table.index.CheckOption;
import com.zhzm.datastructure.table.index.IndexStructure;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IndexCreaterFactory {
    /**
     * @param strc
     * @return
     * <p></p>
     */
    public static BaseIndex getIndexCreater(IndexStructure strc){
        BaseIndex index;
        switch(strc.getIndextype()){
            case foreign:
                ForeignKey fkey=new ForeignKey(strc.getIndexname());
                fkey.setForeignerTable(strc.getForeignTable());
                fkey.setForeignerList(strc.getForeignList());
                index=fkey;
                break;
            case check:
                CheckKey ckey=new CheckKey();
                List<CheckOption> options=strc.getCheckOptionList();
                for (CheckOption option:options){
                    ckey.addFunctionLinkOptions(option.getLink());
                    ckey.addCheckOptions(option.getInvListname(), option.getType(), option.getOptions());
                }
                index=ckey;
                break;
            case primary:
            case unique:
                index=new Uniquekey(strc.getIndexname(),strc.getInvolvedList());
                break;
            case general:
            default:
                index=null;
                break;
        }
        return index;
    }

    public static List<BaseIndex> getIndexesCreater(Collection<IndexStructure> strc){
        List<BaseIndex> indices=new LinkedList<>();
        for(IndexStructure index:strc){
            indices.add(getIndexCreater(index));
        }
        return indices;
    }
}
