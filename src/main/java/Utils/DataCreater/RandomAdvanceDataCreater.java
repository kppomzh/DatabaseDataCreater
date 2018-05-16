package Utils.DataCreater;

import Utils.DataCreater.templet.chineseIDNumber;
import Utils.env_properties;
import Utils.privateRandom;

public class RandomAdvanceDataCreater {
    public static String chineseIDNumber()
    {
        StringBuffer middle=new StringBuffer(RandomBasicDataCreater.getFixNumber(6,0,false));
        String oldenv=env_properties.getEnvironment("toDB");
        env_properties.setEnvironment("toDB","id");
        middle.append(RandomBasicDataCreater.getDate());
        middle.append(RandomBasicDataCreater.getFixNumber(3,0,false));
        int checkNum=0;
        char[] charArray = middle.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            checkNum=checkNum+(charArray[i]-48)* chineseIDNumber.cNUM[i];
        }

        env_properties.setEnvironment("toDB",oldenv);
        return middle.toString()+chineseIDNumber.cID[checkNum%11];
    }
}
