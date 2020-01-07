package newfeature;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateformat {
    @Test
    public void DateFormatTest(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        Date date = new Date(System.currentTimeMillis()-30000);
        System.out.printf(sdf.format(date));
    }
}
