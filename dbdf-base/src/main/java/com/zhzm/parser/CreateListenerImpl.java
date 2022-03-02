package com.zhzm.parser;

import com.zhzm.ENUM.BoolLinkOption;
import com.zhzm.ENUM.IndexType;
import com.zhzm.antlr.createBaseListener;
import com.zhzm.antlr.createParser;
import com.zhzm.antlr.createParser.ListnameContext;
import com.zhzm.datastructure.base.LinkMap;
import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.datastructure.table.index.CheckOption;
import com.zhzm.datastructure.table.index.IndexStructure;
import com.zhzm.utils.StringSpecificationOutput;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public class CreateListenerImpl extends createBaseListener {
    protected LinkedList<IndexStructure> indexprop;
    protected Map<ParserRuleContext, Integer[]> rangeprop;
    protected LinkMap<String, ListStructure> listprop;
    private LinkedList<TableStructure> tss;

    public void enterStart(createParser.StartContext ctx) {
        int tablenumber = ctx.create().size();
        tss = new LinkedList<>();
    }

    public void enterCreate(createParser.CreateContext ctx) {
        indexprop = new LinkedList<>();
        listprop = new LinkMap<>();
    }

    public void exitFull_tablename(createParser.Full_tablenameContext ctx) {
        String tableName=ctx.tablename().objectName().NAMED().getText(),tablespaceName="public";

        if (ctx.tablespacename() != null) {
            tablespaceName=ctx.tablespacename().objectName().NAMED().getText();
        }
        tss.addLast(new TableStructure(tablespaceName,tableName));
    }

    public void enterColumn(createParser.ColumnContext ctx) {
        ListStructure structure = new ListStructure();
        structure.setListname(ctx.listname().objectName().NAMED().getText());
        listprop.put(structure.getListname(), structure);
    }

    public void enterDatatype(createParser.DatatypeContext ctx){
        ListStructure strc=listprop.getLast();
        strc.setListType(ctx.getText().toLowerCase());
    }

    public void enterInttype(createParser.InttypeContext ctx){
        ListStructure strc=listprop.getLast();
        strc.setListType("integer");
        strc.setRange(Integer.parseInt(ctx.int_range().DIGINT().getText()));
    }

    public void enterStringtype(createParser.StringtypeContext ctx){
        ListStructure strc=listprop.getLast();
        strc.setListType("string");
        strc.setRange(Integer.parseInt(ctx.string_range().DIGINT().getText()));
    }

    public void enterDoubletype(createParser.DoubletypeContext ctx){
        ListStructure strc=listprop.getLast();
        strc.setListType("number");
        strc.setRange(Integer.parseInt(ctx.double_range().DIGINT(0).getText()),
                Integer.parseInt(ctx.double_range().DIGINT(1).getText()));
    }

    public void enterDatetime(createParser.DatetimeContext ctx){
        ListStructure strc=listprop.getLast();
        strc.setListType("datetime");
        strc.setRange(Integer.parseInt(ctx.date_range().DIGINT().getText()));
    }

    public void exitHasDefault(createParser.HasDefaultContext ctx) {
        ListStructure structure = listprop.getLast();
        structure.setDefaultStr(ctx.advance_data().getText());
//        if(ctx.advance_data().data()!=null){
//            structure.setDefaultStr(ctx.advance_data().data().getText());
//        }else {
//            structure.setDefaultStr(ctx.advance_data().mysql_function().getText());
//        }
    }

    public void exitColumn(createParser.ColumnContext ctx) {
        ListStructure structure = listprop.getLast();
        ListProcesser.setDataType(structure, ctx.datatype());
    }

    public void enterConstrain(createParser.ConstrainContext ctx) {
        IndexStructure strc = new IndexStructure();
        indexprop.addLast(strc);
        strc.setIndexname(ctx.indexname().objectName().NAMED().getText());
    }

    public void enterIndexType(createParser.IndexTypeContext ctx) {
        IndexStructure strc = indexprop.getLast();
        if (ctx.foreign_key() != null) {
            strc.setIndextype(IndexType.foreign);
        } else if (ctx.primary_key() != null) {
            strc.setIndextype(IndexType.primary);
        } else if (ctx.check_key() != null) {
            strc.setIndextype(IndexType.check);
        } else if (ctx.unique_key() != null) {
            strc.setIndextype(IndexType.unique);
        } else if (ctx.general_key() != null) {
            strc.setIndextype(IndexType.general);
        }
    }

    public void exitCheck_key(createParser.Check_keyContext ctx) {
        IndexStructure strc = indexprop.getLast();
        List<createParser.Check_key_optionsContext> list = ctx.check_key_options();
        List<createParser.BoolLinkOptionContext> blist = ctx.boolLinkOption();
        String involved[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            involved[i] = list.get(i).listname().objectName().NAMED().getText();
        }
        for (int i = 0; i < blist.size(); i++) {
            strc.getCheckOptionList().get(i + 1).setLink(BoolLinkOption.getOption(blist.get(i)));
        }
        strc.setInvolvedList(involved);
    }

    public void exitCheck_key_options(createParser.Check_key_optionsContext ctx) {
        IndexStructure strc = indexprop.getLast();

        CheckOption option = new CheckOption();
        Object[] dataObjects;

        String thisOptionForList = ctx.listname().objectName().NAMED().getText();
        option.setInvListname(thisOptionForList);
        option.setType(getCheckType(ctx));

        List<createParser.DataContext> datas = ctx.data();
        dataObjects = new Object[datas.size()];
        String dataType = listprop.get(thisOptionForList).getListType();
        for (int i = 0; i < dataObjects.length; i++) {
            dataObjects[i] = datas.get(i).getText();
        }

        option.setOptions(StringSpecificationOutput.changeDataType(dataType, dataObjects));
        strc.addCheckOptionList(option);
    }

    public void exitForeign_key(createParser.Foreign_keyContext ctx) {
        IndexStructure strc = indexprop.getLast();
        strc.setInvolvedList(ctx.listname(0).objectName().NAMED().getText());
        strc.setForeignTableSpace(ctx.full_tablename().tablespacename().objectName().NAMED().getText());
        strc.setForeignTable(ctx.full_tablename().tablename().objectName().NAMED().getText());
        strc.setForeignList(ctx.listname(1).objectName().NAMED().getText());
    }

    public void exitGeneral_key_options(createParser.General_key_optionsContext ctx) {
        IndexStructure strc = indexprop.getLast();
        List<ListnameContext> list = ctx.listname();
        String involved[] = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            involved[i] = list.get(i).objectName().NAMED().getText();
        }
        strc.setInvolvedList(involved);
    }

    public void exitCreate(createParser.CreateContext ctx) {
        TableStructure ts = tss.getLast();
        for (Iterator<ListStructure> it = listprop.listIterator(); it.hasNext(); ) {
            ListStructure structure = it.next();
            ts.addList(structure);
        }

        ts.addIndexes(indexprop);
        listprop = null;
        indexprop = null;
    }

    public Collection<TableStructure> getTableStructures() {
        return this.tss;
    }

    private static String getCheckType(createParser.Check_key_optionsContext ctx){
        if (ctx.IN() != null) {
            return "in";
        } else if (ctx.BETWEEN() != null) {
            return "between";
        } else if (ctx.IS() != null) {
            return "is";
        } else {
            return ctx.binary_comparison_operator().getText();
        }
    }

    public void exitNumberset(createParser.NumbersetContext ctx){
        tss.getLast().setLinenum(Double.parseDouble(ctx.DIGINT().getText()));
    }
}
