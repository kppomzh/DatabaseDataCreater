package Utils.DataCreater;

import Utils.env_properties;
import Utils.privateRandom;

public abstract class RandomBasicDataCreater {
    private static char[] c={
    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',//25
    'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',//51
    '0','1','2','3','4','5','6','7','8','9',//52-61
    '_',//62
    '(',')','<','>','?','~','!','^','%','#','+','-','=','@','$'//63-77
    };
    public static String getDate(boolean outuse)
    {
        int year=privateRandom.RandomNumber(1950,2050).intValue();
        int month=privateRandom.RandomNumber(1,12).intValue();
        int date;
        int hour=privateRandom.RandomNumber(0,23).intValue();
        int minute=privateRandom.RandomNumber(0,59).intValue();
        int second=privateRandom.RandomNumber(0,59).intValue();
        switch (month)
        {
            case 2:
                date=privateRandom.RandomNumber(1,28).intValue();
                break;
            case 4: case 6: case 9: case 11:
                date=privateRandom.RandomNumber(1,30).intValue();
                break;
            default:
                date=privateRandom.RandomNumber(1,31).intValue();
        }

        StringBuffer sb=new StringBuffer();
        sb.append(year);
        sb.append(less10give0(month));
        sb.append(month);
        sb.append(less10give0(date));
        sb.append(date);

        sb.append(' ');
        sb.append(less10give0(hour));
        sb.append(hour);
        sb.append(':');
        sb.append(less10give0(minute));
        sb.append(minute);
        sb.append(':');
        sb.append(less10give0(second));
        sb.append(second);
        if(outuse)
            switch (env_properties.getEnvironment("toDB")) {
                case "sql":
                case "jdbc":
                    sb.insert(0, "to_date(\'");
                    sb.append("\',\'yyyymmdd\' hh:mi:ss)");
                    break;
                case "csv":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    break;
                case "json":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    sb.insert(0,'"');
                    sb.append('"');
                    break;
                default:
                    break;
            }

        return sb.toString();
    }
    public static String getNumber(int intRange, int decRange, double[] Numberarea)
    {
        boolean canbeNegative=(false&env_properties.getEnvironment("canbeNegative").equals("true")
                &privateRandom.RandomBool())
                |Numberarea[1]<0;
        if(intRange<0)
            intRange=privateRandom.RandomNumber(1,10).intValue();
        Double intS,intMin=0d,intMax=Math.pow(10,intRange)-1,decMax=Math.pow(10,decRange)-1;
        StringBuffer sb=new StringBuffer();

        if((Numberarea[0]<0&privateRandom.RandomBool())||canbeNegative) {
            intMax = (-Numberarea[0] < intMax & (Numberarea[0] != 0 | Numberarea[1] != 0) ? -Numberarea[0] : intMax);
            sb.append('-');
        }
        else
            intMax=(Numberarea[1]<intMax&(Numberarea[0]!=0|Numberarea[1]!=0) ? Numberarea[1]:intMax);

        if(Numberarea[1]<0)
            intMin=-Numberarea[1];
        if(Numberarea[0]>0)
            intMin=Numberarea[0];

        if(decRange>1)
            Numberarea[1]=Numberarea[1]-1;
        intS=privateRandom.RandomNumber(intMin,intMax);

        sb.append(Double2String(intS));
        if(decRange>0)
        {
            sb.append('.');
            Double decS=privateRandom.RandomNumber(0,decMax);
            sb.append(Double2String(decS));
        }

        return sb.toString();
    }
    public static String getBool()
    {
        if(privateRandom.RandomBool())
            return "true";
        else
            return "false";
    }
    public static String getStr(int range)
    {
        char[] str;
        range=strRangeOptimal(range);

        if(env_properties.getEnvironment("toDB").equals("sql")||
                env_properties.getEnvironment("toDB").equals("jdbc")) {
            range = range + 2;
            str= basicCharArrayFill(range,1,range-1,0,c.length-1);
            str[0]='\'';
            str[range-1]='\'';
        }
        else if(env_properties.getEnvironment("toDB").equals("json")){
            range = range + 2;
            str= basicCharArrayFill(range,1,range-1,0,c.length-1);
            str[0]='\"';
            str[range-1]='\"';
        }
        else
            str= basicCharArrayFill(range,0,range,0,c.length-1);

        return new String(str);
    }

    //定长数值函数
    public static char[] getFixNumber(int intRange, int decRange, boolean canbeNegative)
    {
        char Result[];
        int length=intRange,start=0;

        if(canbeNegative && privateRandom.RandomBool()){
            length++;
            start=1;
        }
        if(decRange>0) {
            length = length + decRange + 1;
        }

        Result=new char[length];

        Result=basicCharArrayFill(length,start,intRange+start,52,61);
        if(decRange>0)
            Result[intRange+start+1]='.';
        if(start==1)
            Result[0]='-';
        return Result;
    }
    //获取不带引号、可以用作对象名称的字符串
    public static char[] getNameStr(int range)
    {
        return basicCharArrayFill(range,0,range,0,62);
    }

    public static char[] getArbitraryCharacter(int strRange,char type)
    {
        char[] str=new char[strRange];
        int min=0,max=c.length-1;

        switch (type){
            case 'c':
                min=0;max=51;break;
            case 'b':
                min=0;max=25;break;
            case 's':
                min=26;max=51;break;
            case 'm':
                min=62;max=c.length-1;break;
            case 'n':
                min=52;max=61;break;
            case 'z':
                return CNCharArrayFill(strRange);
        }

        return basicCharArrayFill(strRange,0,strRange,min,max);
    }

    private static char[] basicCharArrayFill(int range, int start, int end, int min, int max)
    {
        char[] str=new char[range];

        for(int loop=start;loop<end;loop++)
        {
            str[loop]=c[privateRandom.RandomNumber(min,max).intValue()];
        }
        return str;
    }
    private static char[] CNCharArrayFill(int range)
    {
        char[] str=new char[range];

        for(int loop=0;loop<range;loop++)
        {
            str[loop]= (char) privateRandom.RandomNumber(0x4e00,0x9FFF).intValue();
        }
        return str;
    }
    private static int strRangeOptimal(int range)
    {
        if(range<1) {
            range=privateRandom.RandomNumber(1,10).intValue();
        } else if(env_properties.getEnvironment("Optimal").equals("true")) {
            if (range < 32&&range>8)
                range=range-privateRandom.RandomNumber(1,8).intValue();
            else if(range>=32)
                range=privateRandom.RandomNumber(1,range>>3).intValue();
        }
        return range;
    }
    private static char[] less10give0(int i)
    {
        if(i<10)
            return new char[]{'0'};
        else
            return new char[]{};
    }
    private static String Double2String(Double d)
    {
        String s[]=d.toString().split("\\.");
        if(s[1].toString().indexOf("E")==-1)
            return s[0];
        String s1[]=s[1].split("E");
        int length=Integer.valueOf(s1[1]);
        if(s1[0].length()<length) {
            StringBuilder sb=new StringBuilder();
            for(int loop=0;loop<length - s1[0].length();loop++){
                sb.append('0');
            }
            s1[0] = s1[0] + sb.toString();
        }
        return s[0] + s1[0].substring(0, Math.abs(Integer.valueOf(s1[1])));
    }
}
