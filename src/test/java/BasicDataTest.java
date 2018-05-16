import Utils.DataCreater.RandomBasicDataCreater;
import Utils.env_properties;
import org.junit.Test;

public class BasicDataTest {
    @Test
    public void datatest()
    {
        env_properties.setEnvironment("toDB","load");
        System.out.println(RandomBasicDataCreater.getDate());
        env_properties.setEnvironment("toDB","file");
        System.out.println(RandomBasicDataCreater.getDate());
        env_properties.setEnvironment("toDB","jdbc");
        System.out.println(RandomBasicDataCreater.getDate());
    }
}
