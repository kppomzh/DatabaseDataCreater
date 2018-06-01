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
        if(month<10)
            sb.append('0');
        sb.append(month);
        if(date<10)
            sb.append('0');
        sb.append(date);
        if(outuse)
            switch (env_properties.getEnvironment("toDB")) {
                case "file":
                case "jdbc":
                    sb.insert(0, "to_date(\'");
                    sb.append("\',\'yyyymmdd\')");
                    break;
                case "load":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    break;
                default:
                    break;
            }

        return sb.toString();
    }
    public static String getNumber(int intRange, int decRange, boolean canbeNegative)
    {
        Double intS,intMax=Math.pow(10,intRange)-1,decMax=Math.pow(10,decRange)-1;
        StringBuffer sb=new StringBuffer();
        if(intRange<0)
            intRange=privateRandom.RandomNumber(1,10).intValue();

        intS=privateRandom.RandomNumber(0,intMax);

        if(canbeNegative)
            if(privateRandom.RandomBool())
                intS=-intS;
        sb.append(intS.toString().substring(0,intS.toString().indexOf(".")));
        if(decRange>0)
        {
            sb.append('.');
            Double decS=privateRandom.RandomNumber(0,decMax);
            sb.append(decS.toString().substring(0,decS.toString().indexOf(".")));
        }

        return sb.toString();
    }
    public static char[] getStr(int range)
    {
        char[] str;
        range=strRangeOptimal(range);

        if(env_properties.getEnvironment("toDB").equals("file")||
                env_properties.getEnvironment("toDB").equals("jdbc")) {
            range = range + 2;
            str= basicCharArrayFill(range,1,range-1,0,c.length-1);
            str[0]='\'';
            str[range+1]='\'';
        }
        else
            str= basicCharArrayFill(range,0,range,0,c.length-1);

        return str;
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
                min=0x4e00;max=0x9FFF;break;
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
}
