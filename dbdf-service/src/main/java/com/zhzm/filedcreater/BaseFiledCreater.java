package com.zhzm.filedcreater;

import com.zhzm.datacreater.table.TableMaker;
import com.zhzm.utils.BaseEnvironment;

public abstract class BaseFiledCreater {
    protected TableMaker tableMaker;

    public BaseFiledCreater(TableMaker tableMaker) {
        this.tableMaker = tableMaker;
    }


    /**
     * 生成对应数据形式的插入内容
     *
     * @return
     * @throws Exception
     */
    public String makeinsert(int makenum) {
        StringBuilder Return = new StringBuilder(packHead());

        for (int loop = 0; loop < makenum; loop++) {
            try {
                Return.append(packFiled());
            } catch (Exception e) {
                System.out.println(Return);
                throw new RuntimeException(e.getMessage());
            }
        }

        Return.deleteCharAt(Return.length() - 1);
        Return.append(packTail());
//        Return.deleteCharAt(Return.length() - 1);

        return new String(Return.toString().getBytes(), BaseEnvironment.getEnvirmentCharset());
    }

    /**
     * 用于唯一约束检测，每一个线程会分配一个
     *
     * @param ls
     * @param appendStr
     */
//    protected boolean addtoSet(ListStructure ls, String appendStr) {
//        if (ls.isSingal()) {
//            if (unique.get(ls.getListname()).contains(appendStr)) {
//                return false;//错误标记，用于一旦出现了重复的字段内容的时候重新生成数据
//            } else {
//                unique.get(ls.getListname()).add(appendStr);
//            }
//        }
//        return true;
//    }

    /**
     * @return
     */
    protected String[] makeOnceData(){
        return tableMaker.getLineContent().values().toArray(new String[0]);
    }

    /**
     * 依赖于不同的数据格式，一条数据插入时候的头部特殊格式
     *
     * @return
     */
    protected abstract String packHead();

    /**
     * 依赖于不同的数据格式，各类型字段的特殊格式
     *
     * @return
     */
    protected abstract String packFiled() throws Exception;

    /**
     * 依赖于不同的数据格式，一条数据插入时候的尾部特殊格式
     *
     * @return
     */
    protected abstract String packTail();
}
