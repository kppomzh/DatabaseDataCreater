package CreateSQLParser.TableStructure;

import CreateSQLParser.Lex.Word;
import CreateSQLParser.Lex.Word_Segment;
import CreateSQLParser.Parser.Fugue;
import CreateSQLParser.Plan.InsertPlanMaker;
import dataStructure.RuntimeEnvironment;
import dataStructure.TableStructure;

import java.util.List;

public class CreateTableStructure {
    /**
     * 解析SQL格式过程
     * @param createSQL 单个create table的SQL
     * @return
     * @throws Exception
     */
    public static TableStructure makeStructure(String createSQL, RuntimeEnvironment env) throws Exception {
        Word_Segment ws = new Word_Segment();
        Fugue fugue = new Fugue();
        InsertPlanMaker maker = new InsertPlanMaker(env);

        Word[] words = ws.Segment(createSQL);
        try {
            words = fugue.fugue(words);
        }
        catch (Throwable t){
            throw new Exception(t.getMessage()+"\n"+createSQL);
        }
        return maker.makeStrusture(words);
    }
}
