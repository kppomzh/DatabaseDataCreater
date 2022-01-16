package com.zhzm.parser;

import com.zhzm.antlr.createParser;
import com.zhzm.antlr.createParser.Column_optionsContext;
import com.zhzm.datastructure.table.ListStructure;

import java.util.List;

public class ListProcesser {
    public static void setDataType(ListStructure structure, createParser.DatatypeContext ctx) {
        if (ctx.inttype() != null) {
            setIntDataType(structure, ctx.inttype());
        } else if (ctx.doubletype() != null) {
            setDoubleDataType(structure, ctx.doubletype());
        } else if (ctx.stringtype() != null) {
            setStringDataType(structure, ctx.stringtype());
        } else if (ctx.datetime() != null) {
            setTimestampDataType(structure, ctx.datetime());
        } else {
            structure.setListType("string");
        }
    }

    private static void setIntDataType(ListStructure structure, createParser.InttypeContext ctx) {
        structure.setListType("integer");
        structure.setRange(Integer.parseInt(ctx.int_range().DIGINT().getText()));
    }

    private static void setDoubleDataType(ListStructure structure, createParser.DoubletypeContext ctx) {
        structure.setListType("double");
        int[] db = new int[ctx.double_range().DIGINT().size()];
        for (int i = 0; i < db.length; i++) {
            db[i] = Integer.parseInt(ctx.double_range().DIGINT(i).getText());
        }
        structure.setRange(db);
    }

    private static void setStringDataType(ListStructure structure, createParser.StringtypeContext ctx) {
        structure.setListType("string");
        int range = Integer.parseInt(ctx.string_range().DIGINT().getText());
        if (ctx.string_range().BYTE() != null) {
            range = range / 4;
        }
        structure.setRange(range);
    }

    private static void setTimestampDataType(ListStructure structure, createParser.DatetimeContext ctx) {
        structure.setListType("string");
        int range = Integer.parseInt(ctx.date_range().DIGINT().getText());
        structure.setRange(range);
    }
}
