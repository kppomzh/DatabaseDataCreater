package Utils.TableStructure;

import CreateSQLParser.Lex.Word;
import CreateSQLParser.Lex.Word_Segment;
import CreateSQLParser.Parser.Fugue;
import CreateSQLParser.Plan.InsertPlanMaker;
import dataStructure.TableStructure;

import java.util.List;

public class CreateTableStructure {
    /**
     * 解析SQL格式过程
     * @param createSQL 单个create table的SQL
     * @return
     * @throws Exception
     */
    public static TableStructure makeStructure(String createSQL) throws Exception {
        Word_Segment ws = new Word_Segment();
        Fugue fugue = new Fugue();
        InsertPlanMaker maker = new InsertPlanMaker();

        List<Word> words = ws.Segment(createSQL);
        words = fugue.fugue(words);
        return maker.makeStrusture(words);
    }
}
