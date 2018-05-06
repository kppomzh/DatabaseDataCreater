import java.io.*;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;

public class mergeFiles {
    public static void main(String ar[])
    {
        long time=System.currentTimeMillis();
        List<File> fs=new LinkedList<>();
        fs.add(new File("F:\\insert_sql1.sql"));
        fs.add(new File("F:\\insert_sql2.sql"));
        fs.add(new File("F:\\insert_sql3.sql"));
        fs.add(new File("F:\\insert_sql4.sql"));

        File result=new File("F:\\insert_sql.sql");

        try {
            FileChannel resultFileChannel = new FileOutputStream(result, false).getChannel();
            for(File f:fs)
            {
                FileChannel blk = new FileInputStream(f).getChannel();
                resultFileChannel.transferFrom(
                        blk,resultFileChannel.size(),blk.size());
                blk.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print((System.currentTimeMillis()-time)/1000.0);
    }


}
