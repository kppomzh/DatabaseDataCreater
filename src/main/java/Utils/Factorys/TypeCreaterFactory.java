package Utils.Factorys;

import CreateSQLParser.Plan.RegularPlanMaker;
import DataCreater.TypeCreater.*;
import DataCreater.TypeCreater.Advanced.AdvanceTypeCreater;
import DataCreater.TypeCreater.Advanced.DefaultCreater;
import DataCreater.TypeCreater.Advanced.InlineTypeCreater;
import DataCreater.TypeCreater.Advanced.PrimaryKey;
import Exception.BaseException;
import Exception.TypeException.RegularinPlanException;
import Utils.env_properties;
import dataStructure.ListStructure;

public class TypeCreaterFactory {
    public static baseTypeCreater getTypeCreater(ListStructure list) throws BaseException {
        if (list.isPrimary()) {
            return new PrimaryKey(list);
        } else if (list.isDefault()) {
            return new DefaultCreater(makeCreater(list), list, Double.valueOf(env_properties.getEnvironment("defaultProportion")));
        } else if (list.isUnmake()) {
            return null;
        } else if (list.isInline()) {
            return new InlineTypeCreater(list);
        } else {
            return makeCreater(list);
        }

    }

    public static baseTypeCreater makeCreater(ListStructure list) throws BaseException {
        switch (list.getListType()) {
            case "int":
            case "decimal":
                return new numberTypeCreater(list.getRange()[0], list.getRange()[1], list.getNumberarea(),
                        Boolean.valueOf(env_properties.getEnvironment("canbeNegative")));
            case "date":
                return new dateTypeCreater();
            case "bool":
                return new boolTypeCreater();
            case "string": {
                if (list.isRegular()) {
                    try {
                        return RegularPlanMaker.makeRegular(list.getRegularWord());
                    } catch (BaseException e) {
                        throw new RegularinPlanException(list.getRegularWord(), "正则表达式有未结束的子表达式。");
                    }
                } else if (list.isAdvancedType()) {
                    return new AdvanceTypeCreater(list.getAdvancedType(), list.getRange()[0]);
                }
            }
            default:
                return new stringTypeCreater(list.getRange()[0]);
        }
    }
}
