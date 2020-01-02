package newfeature;

import org.junit.Test;

import java.nio.charset.Charset;

public class charsettransaction {
    @Test
    public void testFormalCharset(){
        String[] sets={"GBK","UTF-8","ISO_8859_1","LATIN_1","GB2312","Unicode","US_ASCII","MS936"};

        for(String set:sets){
            Charset charset = null;
            try {
                charset = Charset.forName(set);
            } catch (Exception e) {
            }
            if(charset!=null){
                System.out.println(set);
            }
        }
    }
}
