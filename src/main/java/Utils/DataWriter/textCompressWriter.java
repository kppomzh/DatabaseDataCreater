package Utils.DataWriter;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class textCompressWriter extends tF {
    private FileOutputStream fos;
    private BufferedOutputStream bos;
    private ZipOutputStream compress;
    private ZipEntry file;

    public textCompressWriter(String Filename) throws IOException {
        super(Filename);
        fos=new FileOutputStream(textfile.getPath()+".zip");
        compress = new ZipOutputStream(fos);
        compress.setMethod(ZipOutputStream.DEFLATED);
        compress.setLevel(6);
        bos =new BufferedOutputStream(compress);

        file=new ZipEntry(textfile.getName());
        compress.putNextEntry(file);
    }

    @Override
    public boolean WriteLine(String insert) {
        byte[] toCompress=insert.getBytes();
        try {
            compress.write(toCompress);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public void close() throws IOException {
        compress.closeEntry();
        this.compress.close();
        this.bos.close();
    }
}
