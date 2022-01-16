package com.zhzm.utils;

/**
 * 检查不同类型字符串的格式是否正确，主要用于一些自定义格式和默认值
 */
public class StringSpecificationOutput {
    public static String specNumber(String num, int intRange, int decRange) {
        if(intRange==0 && decRange==0)
            return num;

        String[] nums = num.split("\\.");
        String Return;
        if (nums[0].toCharArray()[0] == '-' || nums[0].toCharArray()[0] == '+') {
            intRange++;
        }
        if (nums[0].length() > intRange&& intRange>1) {
            nums[0] = nums[0].substring(0, intRange);
        }
        Return = nums[0];
        if (nums.length > 1) {
            if (nums[1].length() > decRange)
                Return = Return + '.' + nums[1].substring(0, decRange);
        }
        return Return;
    }

    public static String specDate(String date) {
        StringBuilder specstr = new StringBuilder(),
                sb = new StringBuilder();
        String[] dates = date.split(" "), datestrs, timestrs;
        datestrs = dates[0].split("-");

        switch (datestrs.length) {
            case 1:
                if (datestrs[0].length() > 6)
                    specstr.append("yyyymmdd");
                else specstr.append("yymmdd");
                break;
            case 2:
                if (datestrs[0].length() <= datestrs[1].length()) {
                    if (datestrs[0].length() == 2)
                        specstr.append("yy-mmdd");
                    else
                        specstr.append("yyyy-mmdd");
                } else {
                    if (datestrs[0].length() == 4)
                        specstr.append("yymm-dd");
                    else
                        specstr.append("yyyymm-dd");
                }
                break;
            case 3:
                if (datestrs[0].length() == 2)
                    specstr.append("yy-mm-dd");
                else
                    specstr.append("yyyy-mm-dd");
                break;
            default:
                break;
        }
        if (dates.length>1) {
            specstr.append(' ');
            timestrs = dates[1].split(":");
            if (Integer.valueOf(timestrs[0]) > 12)
                specstr.append("hh24");
            else
                specstr.append("hh");
            specstr.append(":mi:ss");
        }

        sb.append("to_date('");
        sb.append(date);
        sb.append("','");
        sb.append(specstr);
        sb.append("')");
        return sb.toString();
    }

    public static String specString(String str, int range) {
        String Return;
        if (range == 0)
            Return = str;
        else if (str.length() > range)
            Return = str.substring(0, range);
        else Return = str;

        return Return;
    }

    public static String specBool(String bool) {
        if (bool.equals("true") || bool.equals("1"))
            return "true";
        else
            return "false";
    }

    public static Double[] specLineNumber(String arnum){
        String[] nums=arnum.split(",");
        Double[] res=new Double[nums.length];

        for (int i = 0; i < res.length; i++) {
            res[i]=Double.valueOf(nums[i]);
        }
        return res;
    }

    public static Object[] changeDataType(String type,Object[] obj){
        switch (type){
            case "integer":
                for (int i = 0; i < obj.length; i++) {
                    obj[i]=Integer.parseInt(obj[i].toString());
                }
                break;
            case "double":
                for (int i = 0; i < obj.length; i++) {
                    obj[i]=Double.parseDouble(obj[i].toString());
                }
                break;
        }
        return obj;
    }
}
