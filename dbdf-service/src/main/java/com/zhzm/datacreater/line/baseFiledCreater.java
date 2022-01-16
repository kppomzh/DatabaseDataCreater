package com.zhzm.datacreater.line;

import com.zhzm.datastructure.table.ListStructure;
import com.zhzm.utils.BaseEnvironment;
import com.zhzm.datacreater.table.TableMaker;

import java.util.*;

public abstract class baseFiledCreater {
    protected TableMaker tableMaker;

    public baseFiledCreater(TableMaker maker) {
        this.tableMaker = maker;
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

        return new String(Return.toString().getBytes(), BaseEnvironment.getEnvirmentCharset());
    }

    /**
     * @return
     */
    protected Map<String,String> makeOnceData(){
        return tableMaker.getLineContent();
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
