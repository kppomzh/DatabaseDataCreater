package Utils;

import javafx.beans.DefaultProperty;

public abstract class RandomBasicDataCreater {
    public static String getDate()
    {
        int year=privateRandom.RandomNumber(1950,2050).intValue();
        int month=privateRandom.RandomNumber(1,12).intValue();
        int date;
        switch (month)
        {
            case 2:
                date=privateRandom.RandomNumber(1,28).intValue();
            case 4: case 6: case 9: case 11:
                date=privateRandom.RandomNumber(1,30).intValue();
            default:
                date=privateRandom.RandomNumber(1,31).intValue();
        }

        StringBuffer sb=new StringBuffer();
        if(env_properties.getEnvironment("toDB").equals("file")) {
            sb.append("to_date(");
            sb.append('\'');
            sb.append(year);
            if(month<10)
                sb.append('0');
            sb.append(month);
            sb.append(date);
            sb.append("\',\'yyyymmdd\')");
        }
        else{
            sb.append(year);
            sb.append('-');
            if(month<10)
                sb.append('0');
            sb.append(month);
            sb.append('-');
            sb.append(date);
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
    public static String getStr(int strRange)
    {
        int start=0;
        char[] str;
        if(strRange<1)
            strRange=privateRandom.RandomNumber(1,10).intValue();
        else if(env_properties.getEnvironment("Optimal").equals("true")) {
            if (strRange < 32&&strRange>8)
                strRange=strRange-privateRandom.RandomNumber(1,8).intValue();
            else if(strRange>=32)
                strRange=privateRandom.RandomNumber(1,strRange>>3).intValue();
        }

        if(env_properties.getEnvironment("toDB").equals("file")) {
            str = new char[strRange + 2];
            str[0]='\'';
            str[strRange+1]='\'';
            start=1;
        }
        else
            str=new char[strRange];
        for(int loop=start;loop<strRange+start;loop++)
        {
            switch(privateRandom.RandomNumber(1,9).intValue())
            {
                case 1: case 9:
                    str[loop]=RandomCharNumber();
                    break;
                case 2:case 5:case 8:
                    str[loop]=RandomCharLowcase();
                    break;
                case 3:case 7:case 6:
                    str[loop]=RandomCharUppercase();
                    break;
                case 4:
                default:
                    str[loop]=RandomCharMark();
            }
        }
        return new String(str);
    }


    private static char RandomCharNumber()
    {
        return (char)privateRandom.RandomNumber(48,57).intValue();
    }
    private static char RandomCharLowcase()
    {
        return (char)privateRandom.RandomNumber(97,122).intValue();
    }
    private static char RandomCharUppercase()
    {
        return (char)privateRandom.RandomNumber(65,90).intValue();
    }
    private static char RandomCharMark()
    {
        return '_';
    }
}
