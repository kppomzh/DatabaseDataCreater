package dataStruture;

import java.util.ArrayList;
import java.util.List;

public class TableStructure implements Cloneable{
    private String tbname;
    private List<ListStructure> listStructureList;
    private int readnum=-1;
    public TableStructure()
    {
        listStructureList=new ArrayList<>();
    }

    public void addlist(String listname,String ListType,String defaultDataType,boolean isSingal,boolean isDefault,String defaultStr,int... Range)
    {
        listStructureList.add(new ListStructure(listname,ListType,defaultDataType,isSingal,isDefault,defaultStr,Range));
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
    public List<ListStructure> getStruc()
    {
        return listStructureList;
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
