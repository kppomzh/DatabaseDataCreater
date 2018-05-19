package Utils.DataCreater;

import Utils.DataCreater.templet.chineseIDNumber;
import Utils.DataCreater.templet.email;
import Utils.DataCreater.templet.telephone;
import Utils.env_properties;
import Utils.privateRandom;

public class RandomAdvanceDataCreater {
    public static String chineseIDNumber()
    {
        StringBuffer middle=new StringBuffer(chineseIDNumber.getRandomLocalPrefix());
        middle.append(RandomBasicDataCreater.getDate(false));
        middle.append(RandomBasicDataCreater.getFixNumber(3,0,false));
        int checkNum=0;
        char[] charArray = middle.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            checkNum=checkNum+(charArray[i]-48)* chineseIDNumber.cNUM[i];
        }

        middle.append(chineseIDNumber.cID[checkNum%11]);
        if(!env_properties.getEnvironment("toDB").equals("load")){
            middle.insert(0,'\'');
            middle.append('\'');
        }

        return middle.toString();
    }

    public static String emailAddress(int range)
    {
        StringBuffer sb=new StringBuffer();
        String suffix= email.getRandomEmailSuffix();
        int r_mus_suffix=range-suffix.length();
        sb.append(RandomBasicDataCreater.getNameStr(r_mus_suffix));
        sb.append(suffix);
        if(!env_properties.getEnvironment("toDB").equals("load")){
            sb.insert(0,'\'');
            sb.append('\'');
        }
        return sb.toString();
    }

    public static String telephoneNumber()
    {
        StringBuffer sb=new StringBuffer(telephone.getRandomPrefix());
        sb.append(RandomBasicDataCreater.getFixNumber(4,0,false));
        sb.append(RandomBasicDataCreater.getFixNumber(4,0,false));

        if(!env_properties.getEnvironment("toDB").equals("load")){
            sb.insert(0,'\'');
            sb.append('\'');
        }
        return sb.toString();
    }
}
