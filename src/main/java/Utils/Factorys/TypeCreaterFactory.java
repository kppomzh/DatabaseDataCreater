package Utils.Factorys;

import CreateSQLParser.Plan.RegularPlanMaker;
import DataCreater.TypeCreater.*;
import DataCreater.TypeCreater.Advanced.AdvanceTypeCreater;
import DataCreater.TypeCreater.Advanced.DefaultCreater;
import DataCreater.TypeCreater.Advanced.InlineTypeCreater;
import DataCreater.TypeCreater.Advanced.PrimaryKey;
import Exception.BaseException;
import Exception.TypeException.RegularinPlanException;
import Utils.BaseProperties;
import dataStructure.ListStructure;
import dataStructure.RuntimeEnvironment;

public class TypeCreaterFactory {
    public static baseTypeCreater getTypeCreater(ListStructure list, RuntimeEnvironment env) throws BaseException {
        if (list.isPrimary()) {
            return new PrimaryKey(list);
        } else if (list.isDefault()) {
            return new DefaultCreater(makeCreater(list,env), list, Double.valueOf(BaseProperties.getEnvironment("defaultProportion")),env);
        } else if (list.isUnmake()) {
            return null;
        } else if (list.isInline()) {
            return new InlineTypeCreater(list,env);
        } else {
            return makeCreater(list,env);
        }

    }

    public static baseTypeCreater makeCreater(ListStructure list, RuntimeEnvironment env) throws BaseException {
        switch (list.getListType()) {
            case "int":
            case "decimal":
                return new numberTypeCreater(list.getRange()[0], list.getRange()[1], list.getNumberarea(),
                        Boolean.valueOf(env.isCanbeNegative()));
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
