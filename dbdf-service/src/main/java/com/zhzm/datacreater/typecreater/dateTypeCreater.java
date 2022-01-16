package com.zhzm.datacreater.typecreater;

import com.zhzm.utils.BaseEnvironment;
import com.zhzm.utils.privateRandom;

public class dateTypeCreater extends baseTypeCreaterImpl {
    private String wrapBefore,wrapAfter;
    private boolean outuse=true;

    public dateTypeCreater(){
        super();
        if(BaseEnvironment.getEnvironment("toDB").equals("sql")){
            switch (BaseEnvironment.getEnvironment("DBsoftware","oracle").toLowerCase()){
                case "oracle":
                case "postgresql":
                    wrapBefore="to_date('";
                    wrapAfter="','yyyy-mm-dd hh24:mi:ss')";
                    break;
                case "db2":
                    wrapBefore="to_date('";
                    wrapAfter="','yyyy-MM-dd hh:mi:ss')";
                    break;
                case "mysql":
                    wrapBefore="date('";
                    wrapAfter="')";
                    break;
                case "sqlserver":
                    wrapBefore="cast('";
                    wrapAfter="' as datetime)";
                    break;
                case "sqlite":
                    wrapBefore="datetime('";
                    wrapAfter="')";
                    break;
                default:
                    wrapBefore="'";
                    wrapAfter="'";
                    break;
            }
        }
        else{
            wrapBefore="'";
            wrapAfter="'";
        }
    }

    private String getDate() {
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


        if (outuse){
            sb.insert(4, '-');
            sb.insert(7, '-');
            sb.append(' ');
            sb.append(less10give0(hour));
            sb.append(hour);
            sb.append(':');
            sb.append(less10give0(minute));
            sb.append(minute);
            sb.append(':');
            sb.append(less10give0(second));
            sb.append(second);
            sb.insert(0,wrapBefore);
            sb.append(wrapAfter);
        }

        return sb.toString();
    }

    //日期补0
    private static char[] less10give0(int i) {
        if (i < 10) return new char[]{'0'};
        else return new char[]{};
    }

    @Override
    public String getString() {
        return getDate();
    }

    /**
     * @param outuse 输入true时会加上单位间的分隔符，false会输出yyyyMMdd这样的格式
     */
    public void setOutuse(boolean outuse) {
        this.outuse = outuse;
    }
}
