package com.zhzm.datastructure.base;

import com.zhzm.exceptions.ForeignTableRelyException;
import com.zhzm.exceptions.TableLoopRelyException;

import java.util.*;
import java.util.Map.Entry;

public class NodeMap<T> {
    private Map<String,Node<T>> all;
    private ArrayList<Map<String,Node<T>>> levelTree;

    public NodeMap(){
        levelTree = new ArrayList<>();
        all = new HashMap<>();
        Map<String,Node<T>> level0=new HashMap<>(all);
        levelTree.add(level0);
    }

    public void addNode(String name, T root){
        Node<T> node=new Node<>(root);
        node.setLevel(0);
        levelTree.get(0).put(name,node);
        all.put(name,node);
    }

    public void relatedNode(String parent, String son) throws ForeignTableRelyException, TableLoopRelyException {
        Node<T> sonNode=all.get(son),parentNode=all.get(parent);
        if(parentNode==null){
            throw new ForeignTableRelyException(son,parent);
        }
        else {
            parentNode.addSon(son,sonNode);
            sonNode.addParent(parentNode);
            if(parentNode.getLevel()>=sonNode.getLevel()){
                levelTree.get(sonNode.getLevel()).remove(son);
                sonNode.setLevel(parentNode.getLevel()+1);
                refreshNodeLevel(son,sonNode,parent);
            }
        }
    }

    /**
     * 根据深度遍历，计算所有节点到源点的最大距离，构造层级树
     * @return
     */
    public ArrayList<Map<String,Node<T>>> sortLevelTree(){
        levelTree.add(new HashMap<>());
        for(Entry<String,Node<T>> node:all.entrySet()){
            if(node.getValue().getParents().isEmpty()){
                levelTree.get(0).put(node.getKey(),node.getValue());
            }
        }

        for(int i=0;;i++){
            boolean levelstop=true;
            Map<String,Node<T>> level=levelTree.get(i),newLevel=new HashMap<>();
            levelTree.add(newLevel);
            for(Node<T> node:level.values()){
                Map<String,Node<T>> sons=node.getSons();
                if(!sons.isEmpty()){
                    levelstop=false;
                    for(Entry<String,Node<T>> entry:sons.entrySet()){
                        Node<T> nodei= entry.getValue();
                        if(node.getLevel()>=nodei.getLevel()){
                            levelTree.get(nodei.getLevel()).remove(entry.getKey());
                            newLevel.put(entry.getKey(),nodei);
                            nodei.setLevel(node.getLevel()+1);
                        }
                    }
                }
                else{
                    levelstop=levelstop|true;
                }
            }

            if(levelstop)
                break;
        }

        return levelTree;
    }

    public Map<String, T> getSortListMap(){
        Map<String,T> map=new LinkedHashMap<>();
        for(Map<String,Node<T>> level:levelTree){
            for(Entry<String,Node<T>> entry:level.entrySet()){
                map.put(entry.getKey(), entry.getValue().getObj());
            }
        }
        return map;
    }

    private void refreshNodeLevel(String nodename,Node<T>node,String stopNodename) throws TableLoopRelyException {
        if(nodename.equals(stopNodename)){
            throw new TableLoopRelyException();
        }

        while(levelTree.size()<=node.getLevel()){
            levelTree.add(new HashMap<>());
        }
        levelTree.get(node.getLevel()).put(nodename, node);

        for(Entry<String,Node<T>> son:node.getSons().entrySet()){
            if(node.getLevel()>=son.getValue().getLevel()){
                levelTree.get(son.getValue().getLevel()).remove(son.getKey());
                son.getValue().setLevel(node.getLevel()+1);
                refreshNodeLevel(son.getKey(),son.getValue(),stopNodename);
            }
        }
    }

    public class Node<T>{
        private List<Node<T>> parents;
        private Map<String, Node<T>> sons;
        private boolean isMake;
        private T obj;
        private int level;

        public Node(T obj){
            isMake=false;
            parents=new LinkedList<>();
            sons=new HashMap<>();
            this.obj=obj;
        }

        public boolean isMake() {
            return isMake;
        }

        public void setMake() {
            isMake = true;
        }

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public List<Node<T>> getParents() {
            return parents;
        }

        public void addParent(Node<T> parent) {
            this.parents.add(parent);
        }

        public Map<String, Node<T>> getSons() {
            return sons;
        }

        public void addSon(String name, Node<T> son) {
            sons.put(name,son);
        }

        void setLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}

