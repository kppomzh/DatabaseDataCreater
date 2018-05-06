package dataStruture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TableStructure implements Cloneable{
    private String tbname;
    private List<ListStructure> listStructureList;
    private int readnum=-1;
    public TableStructure()
    {
        listStructureList=new ArrayList<>();
    }

    public void addlist(String ListType,boolean canbeNull,boolean isSingal,int... Range)
    {
        listStructureList.add(new ListStructure(ListType,canbeNull,isSingal,Range));
    }

    public boolean hasNext()
    {
        if(readnum>=listStructureList.size()-1) {
            readnum = -1;
            return false;
        }
        return true;
    }
    public ListStructure getNextStruc()
    {
        readnum++;
        if(readnum==listStructureList.size())
            readnum = -1;
        return listStructureList.get(readnum);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableStructure newT= new TableStructure();
        for(int loop=0;loop<this.listStructureList.size();loop++)
            newT.listStructureList.add((ListStructure) this.listStructureList.get(loop).clone());
        return newT;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname;
    }
}
