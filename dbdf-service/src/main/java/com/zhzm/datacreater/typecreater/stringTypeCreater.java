package com.zhzm.datacreater.typecreater;

import com.zhzm.utils.privateRandom;

public class stringTypeCreater extends baseTypeCreaterImpl {
    //strusages:总字符串使用重置次数，到达0的时候将会重置字符串，增强随机性
    //piecewise:分段，将会把一个字符串分成几段拼接完成，根据简单的计算，开根号可以在随机性和性能上取得比较平衡的效果
    //rangeLength:每一次截取字符串的最大长度
    private int rangeLength, strusages, piecewise;
    private String quickStr;

    public stringTypeCreater(int range) {
        super();
        if (range < 1) {
            range = privateRandom.RandomInteger(1, 10);
        }
        piecewise = (int)Math.ceil(Math.sqrt(range));
        rangeLength = (int)Math.floor(Math.sqrt(range)*2-1);

        reinitStr();
    }

    //快速获取基本字符串的方法，例如纯粹大写、小写、数字等
    @Override
    public String getString() {
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
