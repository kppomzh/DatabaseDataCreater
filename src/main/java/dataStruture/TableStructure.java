package dataStruture;

//import com.sun.istack.internal.NotNull;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TableStructure implements Cloneable {
    private int MaxListRange = 0;
    private String tbname;
    private StringBuilder listnamessb;
    private List<ListStructure> listStructureList;
    private int readnum = -1;
    private boolean unmake = false;

    public TableStructure() {
        listnamessb = new StringBuilder();
        listStructureList = new ArrayList<>();
    }

    public void addlist(@NotNull String listname,
                        String ListType, String defaultDataType,
                        boolean isSingal, boolean isDefault,
                        String defaultStr,
                        int[] Range, double[] Numberarea,
                        List<String> inlineObject, boolean unmake) {
        if (Range[0] > MaxListRange)
            MaxListRange = Range[0];
        ListStructure ls = new ListStructure(listname, ListType, isSingal, isDefault, defaultStr);
        ls.setDefaultType(defaultDataType);
        ls.setRange(Range);
        ls.setNumberarea(Numberarea);
        if (inlineObject.size() != 0)
            ls.setInlineObject(inlineObject.toArray(new String[0]));
        ls.setUnmake(unmake);
        if (!unmake) {
            if (listnamessb.length() != 0)
                listnamessb.append(',');

            listnamessb.append(listname);
        } else
            this.unmake = true;
        listStructureList.add(ls);
    }

    public boolean hasNext() {
        if (readnum >= listStructureList.size() - 1) {
            readnum = -1;
            return false;
        }
        return true;
    }

    public ListStructure getNextStruc() {
        readnum++;
        if (readnum == listStructureList.size())
            readnum = -1;
        return listStructureList.get(readnum);
    }

    public List<ListStructure> getStruc() {
        return listStructureList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TableStructure newT = new TableStructure();
        for (int loop = 0; loop < this.listStructureList.size(); loop++)
            newT.listStructureList.add((ListStructure) this.listStructureList.get(loop).clone());
        newT.tbname = this.tbname;
        newT.MaxListRange = this.MaxListRange;
        newT.listnamessb = this.listnamessb;
        newT.unmake = this.unmake;
        return newT;
    }

    public String getTbname() {
        return tbname;
    }

    public void setTbname(String tbname) {
        this.tbname = tbname;
    }

    public int getMaxListRange() {
        return MaxListRange;
    }

    public boolean isUnmake() {
        return unmake;
    }

    public String getListnames() {
        return listnamessb.toString();
    }
}
