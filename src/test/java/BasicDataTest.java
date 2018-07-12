import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import org.junit.Test;

import java.util.Random;

public class BasicDataTest {
//    @Test
    public void datatest()
    {
        env_properties.setEnvironment("toDB","csv");
        System.out.println(RandomBasicDataCreater.getDate(true));
        env_properties.setEnvironment("toDB","sql");
        System.out.println(RandomBasicDataCreater.getDate(true));
        env_properties.setEnvironment("toDB","jdbc");
        System.out.println(RandomBasicDataCreater.getDate(true));
    }
//    @Test
    public void emailtest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater().email(15));
    }

//    @Test
    public void idcardtest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater().ch_idcard(18));
    }
//    @Test
    public void teltest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater().telephone(11));
    }
//    @Test
    public void chinesetest() throws Exception {

        System.out.println(new RandomAdvanceDataCreater().ch_word(11).length());
    }
    @Test
    public void numbertest()
    {
        Double[] d=new Double[1];


        System.out.println(d[0]);
    }
}
