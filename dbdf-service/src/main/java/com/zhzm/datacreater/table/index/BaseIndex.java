package com.zhzm.datacreater.table.index;

/**
 * 该类可以负责保存外键信息、主键/唯一索引，通过不同的子类实现
 */
public abstract class BaseIndex {
    protected Integer size;
    protected String[] involvedLists;

    public BaseIndex(String... listnames){
        involvedLists=listnames;
    }

    /**
     * @param content
     * @return 指示出现问题的是哪个字段（content数组的下标），上层maker将会再次调用该字段的生成器生成一个新的结果
     * -1代表一些正常；-2代表无法获知具体出问题的地方，可以随机选一个生成
     */
    public abstract int addLine(String... content);

    public String[] getInvolvedLists() {
        return involvedLists;
    }

}
