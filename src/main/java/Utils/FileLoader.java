package Utils;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileLoader {
    public static String loadFile(File file) throws IOException {
        byte[] data = FileUtils.readFileToByteArray(file);
        CharsetDetector detector = new CharsetDetector();
        detector.setText(data);
        CharsetMatch match = detector.detect();
        return detector.getString(data, match.getName());
    }
}
