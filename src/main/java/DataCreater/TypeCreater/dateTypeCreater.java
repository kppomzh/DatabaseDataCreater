package DataCreater.TypeCreater;

import Utils.env_properties;
import Utils.privateRandom;

public class dateTypeCreater extends baseTypeCreaterImpl {
    private static String getDate(boolean outuse) {
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
                    sb.insert(0, "to_date('");
                    sb.append("','yyyymmdd hh:mi:ss')");
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

    //日期补0
    private static char[] less10give0(int i) {
        if (i < 10) return new char[]{'0'};
        else return new char[]{};
    }

    @Override
    public String getString(Object... option) {
        return getDate(option==null?true:(Boolean)option[0]);
    }
}
