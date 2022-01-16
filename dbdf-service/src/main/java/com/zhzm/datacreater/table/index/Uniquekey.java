package com.zhzm.datacreater.table.index;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Uniquekey extends BaseIndex {
    private Set<UniqueNode> uniqueSet;
    private Class setType;
    public Uniquekey(String indexname, String... listnames){
        super(listnames);
        uniqueSet=Collections.synchronizedSet(new HashSet<UniqueNode>());
        if(listnames.length>1){
            setType=MultiUniqueNode.class;
        }
        else{
            setType=SingalUniqueNode.class;
        }
    }

    @Override
    public int addLine(String... content) {
        UniqueNode node;
        try {
            node = (UniqueNode) setType.getDeclaredConstructor(Integer.class).newInstance(super.size);
        } catch (Exception e) {
            System.out.println(this.getClass().getSimpleName() + " addLine error.");
            return -2;
        }

        node.addContents(content);
        return uniqueSet.add(node)?-1:-2;
    }

    protected class SingalUniqueNode extends UniqueNode{
        private String content;

        public SingalUniqueNode(Integer size){}

        public void addContents(String... content){
            this.content=content[0];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SingalUniqueNode that = (SingalUniqueNode) o;
            if(that.content!=null){
                return that.content.equals(content);
            }
            else{
                return content==null;
            }
        }
    }

    protected class MultiUniqueNode extends UniqueNode{
        private String[] content;

        public MultiUniqueNode(Integer size){
            content=new String[size];
        }

        public void addContents(String... content){
            this.content=content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MultiUniqueNode that = (MultiUniqueNode) o;
            return Arrays.equals(content,that.content);
        }
    }

    protected abstract class UniqueNode{
        public abstract void addContents(String... content);
    }
}
