package Utils.DataCreater;

import Utils.DataCreater.templet.chineseIDNumber;
import Utils.DataCreater.templet.email;
import Utils.DataCreater.templet.telephone;
import Utils.env_properties;
import Utils.privateRandom;

public class RandomAdvanceDataCreater {
    public static String chineseIDNumber(int range) throws Exception {
        if(range<18)
            throw new Exception("身份证号所在字段长度不能小于18");
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

    public static String emailAddress(int range) throws Exception {
        StringBuffer sb=new StringBuffer();
        String suffix= email.getRandomEmailSuffix();
        int r_mus_suffix=range-suffix.length();

        if(r_mus_suffix<0)
            throw new Exception("所在字段长度太小");

        sb.append(RandomBasicDataCreater.getNameStr(r_mus_suffix));
        sb.append(suffix);
        if(!env_properties.getEnvironment("toDB").equals("load")){
            sb.insert(0,'\'');
            sb.append('\'');
        }
        return sb.toString();
    }

    public static String telephoneNumber(int range) throws Exception {
        if(range<11)
            throw new Exception("手机号码所在字段长度不能小于11");
        StringBuffer sb=new StringBuffer(telephone.getRandomPrefix());
        sb.append(RandomBasicDataCreater.getFixNumber(4,0,false));
        sb.append(RandomBasicDataCreater.getFixNumber(4,0,false));

        if(!env_properties.getEnvironment("toDB").equals("load")){
            sb.insert(0,'\'');
            sb.append('\'');
        }
        return sb.toString();
    }

    public static String freeStringType(int range,String type) throws Exception {
        char c[]=type.toCharArray();

        char now,toGet='c';
        int input_length=0,now_length=0;

        StringBuffer Return=new StringBuffer();

        for(int loop=0;loop<c.length;loop++)
        {
            now=c[loop];
            if(now>47&&now<58) {
                if(c[loop+1]>47&&c[loop+1]<58) {
                    now_length=now_length*10+now-48;
                }
                else {
                    now_length =now_length*10+now-48;
                    input_length = input_length + now_length;

                    if(range<input_length)
                        throw new Exception("所在字段长度太小");

                    Return.append(RandomBasicDataCreater.getArbitraryCharacter(now_length,toGet));

                    now_length=0;
                    toGet='c';
                }
            }
            else if(now=='n'||now=='b'||now=='s'||now=='c'||now=='m')
                toGet=now;
            else if (now=='\'') {
                loop=loop+Stringinquotation(loop,c,Return);
            }
        }

        return Return.toString();
    }

    private static Integer Stringinquotation(int loopo,char[] chars,StringBuffer str) throws Exception {
        char stop='\'';int loop=1;
        while(chars[loopo+loop]!=stop)
        {
            str.append(chars[loopo+loop]);
            loop++;
        }
        return loop;
    }
}
