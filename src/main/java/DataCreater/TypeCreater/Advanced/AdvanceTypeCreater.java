package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreaterImpl;
import DataCreater.TypeCreater.dateTypeCreater;
import DataCreater.templet.Email;
import DataCreater.templet.Telephone;
import DataCreater.templet.chineseIDNumber;
import Utils.privateRandom;

import java.lang.reflect.InvocationTargetException;

public class AdvanceTypeCreater extends baseTypeCreaterImpl {
    private dateTypeCreater dtc;
    private String method;
    private int range;

    public AdvanceTypeCreater(String method,int range){
        dtc=new dateTypeCreater();
        this.method=method;
        this.range=range;
    }

    public StringBuilder ch_idcard(int range) throws Exception {
        if (range < 18) throw new Exception("身份证号所在字段长度不能小于18");
        StringBuilder middle = new StringBuilder(18);
        middle.append(chineseIDNumber.getInstance().getRandomLocalPrefix());
        middle.append(dtc.getString(false));
        middle.append(getArbitraryCharacter(3,'d'));
        int checkNum = 0;
        char[] charArray = middle.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            checkNum = checkNum + (charArray[i] - 48) * chineseIDNumber.cNUM[i];
        }

        middle.append(chineseIDNumber.cID[checkNum % 11]);

        return middle;
    }

    public StringBuilder email(int range) throws Exception {
        StringBuilder sb = new StringBuilder();
        String suffix = Email.getRandomEmailSuffix();
        int r_mus_suffix = range - suffix.length();

        if (r_mus_suffix < 0) throw new Exception("所在字段长度太小");

        sb.append(getArbitraryCharacter(r_mus_suffix,'w'));
        sb.append(suffix);

        return sb;
    }

    public StringBuilder telephone(int range) throws Exception {
        if (range < 11) throw new Exception("手机号码所在字段长度不能小于11");
        StringBuilder sb = new StringBuilder(11);
        sb.append(Telephone.getRandomPrefix());
        sb.append(getArbitraryCharacter(4,'d'));
        sb.append(getArbitraryCharacter(4,'d'));

        return sb;
    }

    public StringBuilder ch_word(int strRange) {
        return new StringBuilder(strRange).append(getArbitraryCharacter(strRange, 'z'));
    }

    public StringBuilder a_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(1, 125));
        return ip_end(sb);
    }

    public StringBuilder b_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(128, 191));
        return ip_end(sb);
    }

    public StringBuilder c_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(192, 223));
        return ip_end(sb);
    }

    public StringBuilder d_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(224, 239));
        return ip_end(sb);
    }

    public StringBuilder e_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(240, 255));
        return ip_end(sb);
    }

    private StringBuilder ip_end(StringBuilder sb) {
        sb.append('.');
        sb.append(privateRandom.RandomInteger(0, 255));
        sb.append('.');
        sb.append(privateRandom.RandomInteger(0, 255));
        sb.append('.');
        sb.append(privateRandom.RandomInteger(0, 255));
        return sb;
    }


    public StringBuilder warp_latitude(int range) {
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomInteger(0, 89));
        sb.append('°');
        sb.append(privateRandom.RandomInteger(0, 60));
        sb.append('′');
        sb.append(privateRandom.RandomInteger(0, 60));
        sb.append('″');
        if (privateRandom.RandomBool()) sb.append('N');
        else sb.append('S');

        sb.append(',');

        sb.append(privateRandom.RandomInteger(0, 179));
        sb.append('°');
        sb.append(privateRandom.RandomInteger(0, 60));
        sb.append('′');
        sb.append(privateRandom.RandomInteger(0, 60));
        sb.append('″');
        if (privateRandom.RandomBool()) sb.append('E');
        else sb.append('W');
        return sb;
    }

    @Override
    public String getString(Object... option) {
        StringBuilder advancedString;

        try {
            advancedString = (StringBuilder) this.getClass().getMethod(method, int.class).invoke(this, range);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return "";
        }

        advancedString.insert(0,'\'');
        advancedString.append('\'');
        return advancedString.toString();
    }
}
