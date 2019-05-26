package test;

import CreateSQLParser.Lex.Word;
import CreateSQLParser.Plan.RegularPlanMaker;
import dataStructure.RegularClasses.Regular;
import org.junit.Test;

public class RegularTest {
    @Test
    public void makeRegularPlanTest(){
        String toTestRegular="{1,}";
        Word regular=new Word("isRegular",toTestRegular,false,1,0);

        try {
            Regular r=RegularPlanMaker.makeRegular(regular);
            System.out.println(r.getGeneratedString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
