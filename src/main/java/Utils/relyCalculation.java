package Utils;

import DataCreater.TypeCreater.Advanced.ForeignKey;
import Exception.DataException.ForeignTableRelyException;
import dataStructure.ListStructure;
import dataStructure.NodeMap;
import dataStructure.TableStructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于计算不同表之间的外键依赖关系，并且会排好执行顺序
 */
public class relyCalculation {
    private Map<String, TableStructure> tss;
    private NodeMap<TableStructure> map;

    public relyCalculation(Map<String, TableStructure> tss) {
        this.tss = tss;
        map = new NodeMap<>();
    }

    public Map<String, TableStructure> makeNodeMap() throws ForeignTableRelyException {
        Map<String, TableStructure> makeOrderMap = new LinkedHashMap<>();

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

    private void calculationTreeNode(TableStructure ts) throws ForeignTableRelyException {
        if (ts.hasForeign()) {
            List<String> foreignRelyTable = ts.getForeignRelyTable();
            for (String table : foreignRelyTable) {
                map.relatedNode(table, ts.getTbname());
            }
        }
    }

    private void setForeignRely(Map<String, TableStructure> map) {
        for (TableStructure ts : map.values()) {
            if(ts.hasForeign()) {
                if (ts.hasNext()) {
                    ListStructure ls=ts.getNextStruc();
                    if(ls.isForeign()){
                        String foreignTable=ls.getForeignTable(),
                                foreignList=ls.getForeignList();
                        ListStructure rely=map.get(foreignTable)
                                .getStructureList(foreignList);
                        rely.setRely();
                        ls.setCreater(new ForeignKey(rely));
                    }
                }
            }
        }
    }
}
