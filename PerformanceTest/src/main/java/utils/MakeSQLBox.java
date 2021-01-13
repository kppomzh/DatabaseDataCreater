package utils;

import dataStructure.SelectUpdateBox;
import dataStructure.TableStructure;

public class MakeSQLBox {
    public static SelectUpdateBox getSQLBox(TableStructure ts){
        return new SelectUpdateBox(ts.getTbname(),
                ts.getPrimaryList().getListname(),
                ts.getStringStructureList());
    }
}
