package test;

import com.zhzm.datacreater.typecreater.RegularCreater.Regular;
import com.zhzm.utils.RegularPlanMaker;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

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
    for(String s:toRegularError)
        try {
            Regular r = RegularPlanMaker.makeRegular(s);
            System.out.println(r.getString());
            Assert.fail();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
