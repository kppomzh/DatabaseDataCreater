package Utils.DataCreater;

import Utils.DataCreater.templet.Email;
import Utils.DataCreater.templet.Telephone;
import Utils.DataCreater.templet.chineseIDNumber;
import Utils.privateRandom;

public class RandomAdvanceDataCreater {
    private RandomBasicDataCreater rbdc;

    public RandomAdvanceDataCreater(RandomBasicDataCreater r) {
        rbdc = r;
    }

    public String returnAdvancedString(String methodString, int range) throws Exception {
        StringBuilder advancedString = null;

        try {
            advancedString = (StringBuilder) this.getClass().getMethod(methodString, int.class).invoke(this, range);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return "";
        }

        return advancedString.toString();
    }

    public StringBuilder ch_idcard(int range) throws Exception {
        if (range < 18) throw new Exception("身份证号所在字段长度不能小于18");
        StringBuilder middle = new StringBuilder(18);
        middle.append(chineseIDNumber.getInstance().getRandomLocalPrefix());
        middle.append(rbdc.getDate(false));
        middle.append(rbdc.getFixNumber(3, 0, false));
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

        sb.append(rbdc.getNameStr(r_mus_suffix));
        sb.append(suffix);

        return sb;
    }

    public StringBuilder telephone(int range) throws Exception {
        if (range < 11) throw new Exception("手机号码所在字段长度不能小于11");
        StringBuilder sb = new StringBuilder(11);
        sb.append(Telephone.getRandomPrefix());
        sb.append(rbdc.getFixNumber(4, 0, false));
        sb.append(rbdc.getFixNumber(4, 0, false));

        return sb;
    }

    public StringBuilder ch_word(int strRange) {
        return new StringBuilder(strRange).append(rbdc.getArbitraryCharacter(strRange, 'z'));
    }

    public StringBuilder a_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(1, 125).intValue());
        return ip_end(sb);
    }

    public StringBuilder b_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(128, 191).intValue());
        return ip_end(sb);
    }

    public StringBuilder c_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(192, 223).intValue());
        return ip_end(sb);
    }

    public StringBuilder d_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(224, 239).intValue());
        return ip_end(sb);
    }

    public StringBuilder e_ip(int range) throws Exception {
        if (range < 15) throw new Exception("IP地址所在字段长度不能小于15");
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(240, 255).intValue());
        return ip_end(sb);
    }

    private StringBuilder ip_end(StringBuilder sb) {
        sb.append('.');
        sb.append(privateRandom.RandomNumber(0, 255).intValue());
        sb.append('.');
        sb.append(privateRandom.RandomNumber(0, 255).intValue());
        sb.append('.');
        sb.append(privateRandom.RandomNumber(0, 255).intValue());
        return sb;
    }


    public StringBuilder warp_latitude(int range) {
        StringBuilder sb = new StringBuilder();
        sb.append(privateRandom.RandomNumber(0, 89).intValue());
        sb.append('°');
        sb.append(privateRandom.RandomNumber(0, 60).intValue());
        sb.append('′');
        sb.append(privateRandom.RandomNumber(0, 60).intValue());
        sb.append('″');
        if (privateRandom.RandomBool()) sb.append('N');
        else sb.append('S');

        sb.append(',');

        sb.append(privateRandom.RandomNumber(0, 179).intValue());
        sb.append('°');
        sb.append(privateRandom.RandomNumber(0, 60).intValue());
        sb.append('′');
        sb.append(privateRandom.RandomNumber(0, 60).intValue());
        sb.append('″');
        if (privateRandom.RandomBool()) sb.append('E');
        else sb.append('W');
        return sb;
    }
}
