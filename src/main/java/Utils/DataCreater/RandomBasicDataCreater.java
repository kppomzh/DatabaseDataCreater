package Utils.DataCreater;

import Utils.env_properties;
import Utils.privateRandom;

public class RandomBasicDataCreater {
    private static char[] c = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',//25
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',//51
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',//52-61
            '_',//62
            '(', ')', '<', '>', '?', '~', '!', '^', '%', '#', '+', '-', '=', '@', '$'//63-77
    };
    private String quickStr,
            quickAllStr,
            quickNumStr, //数字字符串
            quickUppStr, //大写字符串
            quickLowStr, //小写字符串
            quickMarkStr; //符号字符串

    private int rangeLength,
            strusages = 0,
            numusages = 0,
            uppusages = 0,
            lowusages = 0,
            markusages = 0;

    public RandomBasicDataCreater(int maxStringLength) {
        rangeLength = Double.valueOf(Math.sqrt(maxStringLength)).intValue() * 2;
    }

    String reinitStr(int sl, int min, int max) {
        return new String(basicCharArrayFill(sl * rangeLength, 0, sl * rangeLength, min, max));
    }

    private void reinitAllStr() {
        strusages = 8191;
        quickAllStr = reinitStr(64, 0, 77);
    }

    private void reinitNumStr() {
        numusages = 511;
        quickNumStr = reinitStr(16, 52, 61);
    }

    private void reinitUppStr() {
        uppusages = 511;
        quickUppStr = reinitStr(16, 0, 25);
    }

    private void reinitLowStr() {
        lowusages = 511;
        quickLowStr = reinitStr(16, 26, 51);
    }

    private void reinitMarkStr() {
        markusages = 511;
        quickMarkStr = reinitStr(16, 62, 77);
    }

    public String getDate(boolean outuse) {
        int year = privateRandom.RandomNumber(1970, 2050).intValue();
        int month = privateRandom.RandomNumber(1, 12).intValue();
        int date;
        int hour = privateRandom.RandomNumber(0, 23).intValue();
        int minute = privateRandom.RandomNumber(0, 59).intValue();
        int second = privateRandom.RandomNumber(0, 59).intValue();
        switch (month) {
            case 2:
                date = privateRandom.RandomNumber(1, 28).intValue();
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                date = privateRandom.RandomNumber(1, 30).intValue();
                break;
            default:
                date = privateRandom.RandomNumber(1, 31).intValue();
        }

        StringBuilder sb = new StringBuilder();
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
        if (outuse)
            switch (env_properties.getEnvironment("toDB")) {
                case "sql":
                case "jdbc":
                    sb.insert(0, "to_date(\'");
                    sb.append("\',\'yyyymmdd hh:mi:ss\')");
                    break;
                case "csv":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    break;
                case "json":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    sb.insert(0, '"');
                    sb.append('"');
                    break;
                default:
                    break;
            }

        return sb.toString();
    }

    public String getNumber(int intRange, int decRange, double[] Numberarea) {
        boolean canbeNegative = (false & env_properties.getEnvironment("canbeNegative").equals("true")
                & privateRandom.RandomBool())
                | Numberarea[1] < 0;
        if (intRange < 0)
            intRange = privateRandom.RandomNumber(1, 10).intValue();
        Double intS, intMin = 0d, intMax = Math.pow(10, intRange) - 1, decMax = Math.pow(10, decRange) - 1;
        StringBuilder sb = new StringBuilder();

        if ((Numberarea[0] < 0 & privateRandom.RandomBool()) || canbeNegative) {
            intMax = (-Numberarea[0] < intMax & (Numberarea[0] != 0 | Numberarea[1] != 0) ? -Numberarea[0] : intMax);
            sb.append('-');
        } else
            intMax = (Numberarea[1] < intMax & (Numberarea[0] != 0 | Numberarea[1] != 0) ? Numberarea[1] : intMax);

        if (Numberarea[1] < 0)
            intMin = -Numberarea[1];
        if (Numberarea[0] > 0)
            intMin = Numberarea[0];

        if (decRange > 1)
            Numberarea[1] = Numberarea[1] - 1;
        intS = privateRandom.RandomNumber(intMin, intMax);

        sb.append(Double2String(intS));
        if (decRange > 0) {
            sb.append('.');
            Double decS = privateRandom.RandomNumber(0, decMax);
            sb.append(Double2String(decS));
        }

        return sb.toString();
    }

    public String getBool() {
        if (privateRandom.RandomBool())
            return "true";
        else
            return "false";
    }

    public String getStr(int range) {
        if (strusages == 0)
            reinitAllStr();
        quickStr = quickAllStr;
        strusages--;
        return basegetStr(range);
    }

    //定长数值函数
    public String getFixNumber(int intRange, int decRange, boolean canbeNegative) {
        if (numusages == 0)
            reinitNumStr();
        quickStr = quickNumStr;
        numusages--;
        StringBuilder sb = new StringBuilder();

        if (canbeNegative && privateRandom.RandomBool()) {
            sb.append('-');
        }

        sb.append(basegetStr(intRange));

        if (decRange > 0) {
            sb.append('.');
            sb.append(basegetStr(decRange));
        }

        return sb.toString();
    }

    private String basegetStr(int range) {
        int piecewise;
        StringBuilder sb = new StringBuilder();
        range = strRangeOptimal(range);

        piecewise = Double.valueOf(Math.sqrt(range)).intValue();

        for (int loop = 0; loop < piecewise; loop++) {
            int sublength = privateRandom.RandomNumber(1, rangeLength).intValue();
            int substrart = privateRandom.RandomNumber(0, rangeLength - sublength - 1).intValue();
            sb.append(quickStr, substrart, substrart + sublength);
        }

        if (sb.length() < range) {
            int substrart = privateRandom.RandomNumber(0, rangeLength - range + sb.length() - 1).intValue();
            sb.append(quickStr, substrart, substrart + range - sb.length());
        }

        return sb.toString();
    }


    //获取不带引号、可以用作对象名称的字符串，并且强制启用SQL优化
    public String getNameStr(int range) {
        return basicCharArrayFill(strRangeOptimal(range), 0, range, 0, 62);
    }

    public String getArbitraryCharacter(int strRange, char type) {
        char[] str = new char[strRange];
        int min = 0, max = c.length - 1;

        switch (type) {
            case 'c':
                min = 0;
                max = 51;
                break;
            case 'b':
                if (uppusages == 0)
                    reinitUppStr();
                quickStr = quickUppStr;
                uppusages--;
                return basegetStr(strRange);
            case 's':
                if (lowusages == 0)
                    reinitLowStr();
                quickStr = quickLowStr;
                lowusages--;
                return basegetStr(strRange);
            case 'm':
                if (markusages == 0)
                    reinitMarkStr();
                quickStr = quickMarkStr;
                markusages--;
                return basegetStr(strRange);
            case 'n':
                return getFixNumber(strRange, 0, false);
            case 'z':
                return CNCharArrayFill(strRange);
        }

        return basicCharArrayFill(strRange, 0, strRange, min, max);
    }

    private static String basicCharArrayFill(int range, int start, int end, int min, int max) {
        char[] str = new char[range];

        for (int loop = start; loop < end; loop++) {
            str[loop] = c[privateRandom.RandomNumber(min, max).intValue()];
        }
        return new String(str);
    }

    private static String CNCharArrayFill(int range) {
        char[] str = new char[range];

        for (int loop = 0; loop < range; loop++) {
            str[loop] = (char) privateRandom.RandomNumber(0x4e00, 0x9fa5).intValue();
        }
        return new String(str);
    }

    private static int strRangeOptimal(int range) {
        if (range < 1) {
            range = privateRandom.RandomNumber(1, 10).intValue();
        } else if (env_properties.getEnvironment("Optimal").equals("true")) {
            if (range < 32 && range > 8)
                range = range - privateRandom.RandomNumber(1, 8).intValue();
            else if (range >= 32)
                range = privateRandom.RandomNumber(1, range >> 3).intValue();
        }
        return range;
    }

    private static char[] less10give0(int i) {
        if (i < 10)
            return new char[]{'0'};
        else
            return new char[]{};
    }

    private static String Double2String(Double d) {
        String s[] = d.toString().split("\\.");
        if (s[1].toString().indexOf("E") == -1)
            return s[0];
        String s1[] = s[1].split("E");
        int length = Integer.valueOf(s1[1]);
        if (s1[0].length() < length) {
            StringBuilder sb = new StringBuilder();
            for (int loop = 0; loop < length - s1[0].length(); loop++) {
                sb.append('0');
            }
            s1[0] = s1[0] + sb.toString();
        }
        return s[0] + s1[0].substring(0, Math.abs(Integer.valueOf(s1[1])));
    }
}
