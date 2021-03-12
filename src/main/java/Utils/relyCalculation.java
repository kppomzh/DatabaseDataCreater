package Utils;

import Exception.DataException.ForeignTableRelyException;
import dataStructure.NodeMap;
import dataStructure.NodeMap.Node;
import dataStructure.TableStructure;

import java.util.ArrayList;
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

    public Map<String,TableStructure> makeNodeMap() throws ForeignTableRelyException {
        Map<String,TableStructure> makeOrderMap=new LinkedHashMap<>();

        for (Map.Entry<String, TableStructure> ts : tss.entrySet()) {
            map.addNode(ts.getKey(), ts.getValue());

        }

        for (Map.Entry<String, TableStructure> ts : tss.entrySet()) {
            calculationTreeNode(ts.getValue());
        }

        setForeignRely(map.sortLevelTree());

        return map.getSortListMap();
    }

    private void calculationTreeNode(TableStructure ts) throws ForeignTableRelyException {
        if (ts.hasForeign()) {
            List<String> foreignRelyTable=ts.getForeignRelyTable();
            for(String table:foreignRelyTable){
                map.relatedNode(table,ts.getTbname());
            }
        }
    }

    private void setForeignRely(ArrayList<Map<String, NodeMap<TableStructure>.Node<TableStructure>>> levelTree){
        for (int i = levelTree.size()-1; i>0; i--) {
            for(NodeMap<TableStructure>.Node<TableStructure> node:levelTree.get(i).values()){

            }
        }
    }
}
