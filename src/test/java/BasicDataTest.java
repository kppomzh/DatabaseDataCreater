import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import org.junit.Test;

import java.util.Random;

public class BasicDataTest {
    RandomBasicDataCreater rbdc=new RandomBasicDataCreater(18);
    @Test
    public void datatest()
    {
        env_properties.setEnvironment("toDB","csv");
        System.out.println(rbdc.getDate(true));
        env_properties.setEnvironment("toDB","sql");
        System.out.println(rbdc.getDate(true));
        env_properties.setEnvironment("toDB","jdbc");
        System.out.println(rbdc.getDate(true));
    }
//    @Test
    public void emailtest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater(rbdc).email(15));
    }

//    @Test
    public void idcardtest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater(rbdc).ch_idcard(18));
    }
//    @Test
    public void teltest() throws Exception {
        System.out.println(new RandomAdvanceDataCreater(rbdc).telephone(11));
    }
//    @Test
    public void chinesetest() throws Exception {

        System.out.println(new RandomAdvanceDataCreater(rbdc).ch_word(11).length());
    }
    @Test
    public void numbertest()
    {
        Double[] d=new Double[1];


        System.out.println(d[0]);
    }
}
