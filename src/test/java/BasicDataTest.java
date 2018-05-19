import Utils.DataCreater.RandomAdvanceDataCreater;
import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import org.junit.Test;

public class BasicDataTest {
    @Test
    public void datatest()
    {
        env_properties.setEnvironment("toDB","load");
        System.out.println(RandomBasicDataCreater.getDate(true));
        env_properties.setEnvironment("toDB","file");
        System.out.println(RandomBasicDataCreater.getDate(true));
        env_properties.setEnvironment("toDB","jdbc");
        System.out.println(RandomBasicDataCreater.getDate(true));
    }
    @Test
    public void emailtest()
    {
        System.out.println(RandomAdvanceDataCreater.emailAddress(15));
    }

    @Test
    public void idcardtest(){
        System.out.println(RandomAdvanceDataCreater.chineseIDNumber());
    }
    @Test
    public void teltest(){
        System.out.println(RandomAdvanceDataCreater.telephoneNumber());
    }
}
