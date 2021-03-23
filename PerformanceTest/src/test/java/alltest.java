import client.startTest;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class alltest {
    @Test
    public void main(){
        startTest.main("-f","sql.sql","-n","10000");
        File to[]=new File("").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".png.txt");
            }
        });
        for (int i = 0; i < to.length; i++) {
            to[i].renameTo(new File(to[i].getPath().replace(".png.txt",".png")));
        }
    }
}
