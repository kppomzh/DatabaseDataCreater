package com.zhzm.datacreater.factory;

import com.zhzm.datacreater.typecreater.Advanced.AdvanceTypeCreater;
import com.zhzm.datacreater.typecreater.Advanced.DefaultCreater;
import com.zhzm.datacreater.typecreater.Advanced.InlineTypeCreater;
import com.zhzm.datacreater.typecreater.Advanced.PrimaryKey;
import com.zhzm.datacreater.typecreater.*;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.exceptions.BaseException;
import com.zhzm.exceptions.regular.RegularBaseException;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.RegularPlanMaker;

public class TypeCreaterFactory {
    public static baseTypeCreaterImpl getTypeCreater(ListStructure list) throws BaseException {
        if (list.isPrimary()) {
            return new PrimaryKey(list.getRange()[0]);
        } else if (list.isDefault()) {
            return new DefaultCreater(makeCreater(list), list, Double.parseDouble(BaseEnvironment.getEnvironment("defaultProportion")));
        } else if (list.isUnmake()) {
            return null;
        } else if (list.isInline()) {
            return new InlineTypeCreater(list);
        } else {
            return makeCreater(list);
        }

    }

    private static baseTypeCreaterImpl makeCreater(ListStructure list) throws BaseException {
        boolean isUnique = list.isSingal();
        baseTypeCreaterImpl res;

        switch (list.getListType()) {
            case "int":
            case "decimal":
                res = new numberTypeCreater(list.getRange()[0], list.getRange()[1], list.getNumberarea(),
                        Boolean.parseBoolean(BaseEnvironment.getEnvironment("canbeNegative")));
                break;
            case "date":
                res = new dateTypeCreater();
                break;
            case "bool":
                res = new boolTypeCreater();
                break;
            case "string":
                if (list.isRegular()) {
                    try {
                        res = RegularPlanMaker.makeRegular(list.getRegularWord());
                        break;
                    } catch (BaseException e) {
//                        throw new RegularinPlanException(list.getRegularWord(), "正则表达式有未结束的子表达式。");
                    } catch (RegularBaseException e) {

                    }
                } else if (list.isAdvancedType()) {
                    res = new AdvanceTypeCreater(list.getAdvancedType(), list.getRange()[0], list);
                    break;
                }
            default:
                res = new stringTypeCreater(list.getRange()[0]);
        }
        if (list.isRely())
            res.isRely();
        return res;
    }
}
