package Utils.datastruc;

import java.io.*;
import java.nio.channels.FileChannel;

public class Fileloader {
    public static String loadingFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        )
                )
        );
        StringBuilder sb = new StringBuilder();
        String temp;

        while ((temp = reader.readLine()) != null) {
            sb.append(temp);
        }
        return sb.toString();
    }
}
