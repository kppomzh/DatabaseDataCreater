package Utils.DataCreater;

import Utils.env_properties;
import Utils.privateRandom;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RandomBasicDataCreater {
    private static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',//25
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',//51
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',//52-61
            '_',//62
            '(', ')', '<', '>', '?', '~', '!', '^', '%', '#', '+', '-', '=', '@', '$'//63-77
    };
    private String quickStr, quickAllStr, quickNumStr, //数字字符串
            quickUppStr, //大写字符串
            quickLowStr, //小写字符串
            quickMarkStr; //符号字符串

    private int rangeLength, strusages = 0, numusages = 0, uppusages = 0, lowusages = 0, markusages = 0;
    private BigInteger startPrimary;

    public RandomBasicDataCreater(int maxStringLength, BigInteger start){
        rangeLength = Double.valueOf(Math.sqrt(maxStringLength)).intValue() * 2;
        if (rangeLength < 100) rangeLength = 100;
        startPrimary=start.subtract(BigInteger.ONE);
    }

    private String reinitStr(int sl, int min, int max) {
        return basicCharArrayFill(sl * rangeLength, 0, sl * rangeLength, min, max);
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
        quickMarkStr = reinitStr(16, 63, 77);
    }

    public String getDate(boolean outuse) {
        int year = privateRandom.RandomInteger(1970, 2050);
        int month = privateRandom.RandomInteger(1, 12);
        int date;
        int hour = privateRandom.RandomInteger(0, 23);
        int minute = privateRandom.RandomInteger(0, 59);
        int second = privateRandom.RandomInteger(0, 59);
        switch (month) {
            case 2:
                date = privateRandom.RandomInteger(1, 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                date = privateRandom.RandomInteger(1, 30);
                break;
            default:
                date = privateRandom.RandomInteger(1, 31);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(year);
        sb.append(less10give0(month));
        sb.append(month);
        sb.append(less10give0(date));
        sb.append(date);

        if (outuse) {
            switch (env_properties.getEnvironment("toDB")) {
                case "sql":
                case "jdbc":
                    break;
                case "csv":
                case "json":
                    sb.insert(4, '-');
                    sb.insert(7, '-');
                    break;
                default:
                    break;
            }
            sb.append(' ');
            sb.append(less10give0(hour));
            sb.append(hour);
            sb.append(':');
            sb.append(less10give0(minute));
            sb.append(minute);
            sb.append(':');
            sb.append(less10give0(second));
            sb.append(second);
        }

        return sb.toString();
    }

    public String getNumber(int intRange, int decRange, String[] Numberarea) {
        String[] numberarea0 = Numberarea[0]==null?new String[0]:Numberarea[0].split("\\."), numberarea1 = Numberarea[1]==null?new String[0]: Numberarea[1].split("\\.");

        BigInteger area1 = Numberarea[0] == null ? BigInteger.ZERO : new BigInteger(numberarea0[0]), area2 = Numberarea[1] == null ? BigInteger.ZERO : new BigInteger(numberarea1[0]);

        boolean canbeNegative = (false & env_properties.getEnvironment("canbeNegative").equals("true") & privateRandom.RandomBool()) | area2.compareTo(BigInteger.ZERO) == -1;
        if (intRange <= 0) intRange = privateRandom.RandomInteger(1, 10);
        BigInteger intS, intMin = BigInteger.ZERO,
                intMax = BigDecimal.valueOf(Math.pow(10, intRange)).toBigInteger().subtract(BigInteger.ONE),
                decMax = decRange == 0 ? BigInteger.ZERO : BigDecimal.valueOf(Math.pow(10, decRange)).toBigInteger().subtract(BigInteger.ONE);
        StringBuilder sb = new StringBuilder();

        if ((area1.compareTo(BigInteger.ZERO) == -1 & privateRandom.RandomBool()) || canbeNegative) {
            intMax = (area1.negate().compareTo(intMax) == -1 & (area1.compareTo(BigInteger.ZERO) != 0 | area2.compareTo(BigInteger.ZERO) != 0) ? area1 : intMax);
            sb.append('-');
        } else
            intMax = (area2.compareTo(intMax) == -1 & (area1.compareTo(BigInteger.ZERO) != 0 | area2.compareTo(BigInteger.ZERO) != 0) ? area2 : intMax);

        if (area2.compareTo(BigInteger.ZERO) == -1) intMin = area2.negate();
        if (area1.compareTo(BigInteger.ZERO) == 1) intMin = area1;

        intS = privateRandom.RandomBInteger(intMin, intMax);

        if (decRange > 0) {
            BigInteger decS;
            boolean inlengthEquals=false;

            decS = privateRandom.RandomBInteger(BigInteger.ZERO, decMax);
            String decString=decS.toString();
            if (intS.compareTo(intMin) == 0) {
                //在intMin的时候，只有decString更长的情况下才更可能落在区间范围里
                if(numberarea0.length > 1){
//                    inlengthEquals=numberarea0[1].length()>decString.length();
                    for (int i = 0; i < Math.min(decString.length(), numberarea0[1].length()); i++) {
                        if(decString.charAt(i)<numberarea0[1].charAt(i)){
                            inlengthEquals=true;
                            break;
                        }
                        else if(decString.charAt(i)>numberarea0[1].charAt(i)){
                            break;
                        }
                    }
                }

                if(inlengthEquals){
                    intS.add(BigInteger.ONE);
                }
            } else if (intS.compareTo(intMax) == 0) {
                //在intMax的时候，只有decString更短的情况下才更可能落在区间范围里
                if(numberarea1.length > 1){
//                    inlengthEquals=numberarea1[1].length()<decString.length();
                    for (int i = 0; i < Math.min(decString.length(), numberarea1[1].length()); i++) {
                        if(decString.charAt(i)>numberarea1[1].charAt(i)){
                            inlengthEquals=true;
                            break;
                        }
                        else if(decString.charAt(i)<numberarea1[1].charAt(i)){
                            break;
                        }
                    }
                }

                if(inlengthEquals){
                    intS.subtract(BigInteger.ONE);
                }
            }
            sb.append(intS);
            sb.append('.');
            sb.append(decS);
        } else {
            sb.append(intS);
        }

        return sb.toString();
    }

    public String getBool() {
        if (privateRandom.RandomBool()) return "true";
        else return "false";
    }

    public String getStr(int range) {
        if (strusages == 0) reinitAllStr();
        quickStr = quickAllStr;
        strusages--;
        return basegetStr(range);
    }

    public BigInteger getPrimaryKey(){
        startPrimary=startPrimary.add(BigInteger.ONE);
        return startPrimary;
    }

    //定长数值函数
    public String getFixNumber(int intRange, int decRange, boolean canbeNegative) {
        if (numusages == 0) reinitNumStr();
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

    //快速获取基本字符串的方法，例如纯粹大写、小写、数字等
    private String basegetStr(int range) {
        int piecewise;
        StringBuilder sb = new StringBuilder();
        range = strRangeOptimal(range);

        piecewise = Double.valueOf(Math.sqrt(range)).intValue();

        for (int loop = 0; loop < piecewise; loop++) {
            int sublength = privateRandom.RandomInteger(1, rangeLength);
            int substrart = privateRandom.RandomInteger(0, rangeLength - sublength - 1);
            sb.append(quickStr.substring(substrart, substrart + sublength));
        }

        if (sb.length() < range) {
            int substrart = privateRandom.RandomInteger(0, rangeLength - range + sb.length() - 1);
            sb.append(quickStr, substrart, substrart + range - sb.length());
        }

        return sb.toString();
    }


    //获取不带引号、可以用作对象名称的字符串，并且强制启用SQL优化
    public String getNameStr(int range) {
        return getArbitraryCharacter(strRangeOptimal(range), 'w');
    }

    public static String getArbitraryCharacter(int strRange, char type) {
        int min = 0, max = c.length - 1;

        switch (type) {
            case 'd':
                min = 52;
                max = 61;
                break;
            case 'w'://[a-zA-Z0-9_]
                min = 0;
                max = 62;
                break;
            case 'W':
                min = 63;
                max = 77;
                break;
            case 's'://空格
                min = 32;
                max = 32;
                break;
            case 'S':
                min = 0;
                max = 77;
                break;
            case 'n'://正整数
                return String.valueOf(privateRandom.RandomInteger(0, 100000));
            case 'z':
                min = 0x4e00;
                max = 0x9fa5;
                break;
        }

        return basicCharArrayFill(strRange, 0, strRange, min, max);
    }

    private static String basicCharArrayFill(int range, int start, int end, int min, int max) {
        char[] str = new char[range];

        for (int loop = start; loop < end; loop++) {
            int local = privateRandom.RandomInteger(min, max);
            str[loop] = c[local];
        }
        return new String(str);
    }

    private static int strRangeOptimal(int range) {
        if (range < 1) {
            range = privateRandom.RandomInteger(1, 10);
        } else if (env_properties.getEnvironment("Optimal").equals("true")) {
            if (range < 32 && range > 8) range = range - privateRandom.RandomInteger(1, 8);
            else if (range >= 32) range = privateRandom.RandomInteger(1, range >> 3);
        }
        return range;
    }

    //日期补0
    private static char[] less10give0(int i) {
        if (i < 10) return new char[]{'0'};
        else return new char[]{};
    }
}
