package com.zhzm.client.writer;

public class SystemoutWriter extends tF {
    public SystemoutWriter() {}

    @Override
    public boolean WriteLine(String insert) {
        System.out.println(insert);
        return true;
    }
}
