package test;

import CreateSQLParser.Lex.Word;
import CreateSQLParser.Plan.RegularPlanMaker;
import dataStructure.RegularClasses.Regular;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RegularTest {
    /**
     * 这个数组中的所有字符串都要在try块最后加入Assert.fail();
     * 如果通过测试反而说明有问题。
     */
    String[] toRegularError = {"{1,}", "[]"};
    /**
     * 这个数组中的所有字符串都要在catch块加入Assert.fail();
     */
    String[] toRegularTrue = {""};

//    @Ignore
    @Test
    public void LengthDefineErrorTest() {
        Word regular = new Word("isRegular", toRegularError[0], false, 1, 0);

        try {
            Regular r = RegularPlanMaker.makeRegular(regular);
            System.out.println(r.getGeneratedString());
            Assert.fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
