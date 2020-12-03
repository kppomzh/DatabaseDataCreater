package DataCreater.TypeCreater;

import Utils.env_properties;
import Utils.privateRandom;

public class stringTypeCreater extends baseTypeCreaterImpl {
    //strusages:总字符串使用重置次数，到达0的时候将会重置字符串，增强随机性
    //piecewise:分段，将会把一个字符串分成几段拼接完成，根据简单的计算，开根号可以在随机性和性能上取得比较平衡的效果
    private int rangeLength, strusages, piecewise;
    private String quickStr;

    public stringTypeCreater(int range) {
        if (range < 1) {
            rangeLength = privateRandom.RandomInteger(1, 10);
        } else if (env_properties.getEnvironment("optimal").equals("true")) {
            if (range < 32 && range > 8) rangeLength = range - privateRandom.RandomInteger(1, 8);
            else if (range >= 32) rangeLength = privateRandom.RandomInteger(1, range >> 3);
        } else {
            rangeLength = range;
        }
        piecewise = Double.valueOf(Math.sqrt(rangeLength)).intValue();

        reinitStr();
    }

    //快速获取基本字符串的方法，例如纯粹大写、小写、数字等
    @Override
    public String getString(Object... option) {
        if (strusages == 0) reinitStr();
        strusages--;

        StringBuilder sb = new StringBuilder();

        for (int loop = 0; loop < piecewise; loop++) {
            int sublength = privateRandom.RandomInteger(1, rangeLength);
            int substrart = privateRandom.RandomInteger(0, rangeLength - sublength - 1);
            sb.append(quickStr, substrart, substrart + sublength);
        }

        if (sb.length() < rangeLength) {
            //此处的计算取决于当前的目标字符串还需要多少个字符，计算
            sb.append(quickStr, 0, rangeLength - sb.length());
        }
        else if(sb.length()>rangeLength)
            sb.delete(rangeLength,sb.length());

        sb.insert(0,'\'');
        sb.append('\'');
        return sb.toString();
    }

    private void reinitStr() {
        strusages = 2047;
        int slRangeLength = 64 * rangeLength;
        quickStr = basicCharArrayFill(slRangeLength, 0, slRangeLength, 0, 77);
    }
}
