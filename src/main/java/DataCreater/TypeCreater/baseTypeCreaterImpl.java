package DataCreater.TypeCreater;

import Utils.env_properties;
import Utils.privateRandom;

public abstract class baseTypeCreaterImpl implements baseTypeCreater,Cloneable {
    protected static char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',//25
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',//51
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',//52-61
            '_',//62
            '(', ')', '<', '>', '?', '~', '!', '^', '%', '#', '+', '-', '=', '@', '$'//63-77
    };

    @Override
    public abstract String getString(Object... option);

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

    protected static String basicCharArrayFill(int range, int start, int end, int min, int max) {
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
}
