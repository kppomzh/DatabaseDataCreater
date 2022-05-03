package com.zhzm.utils.insert;

import com.zhzm.datacreater.line.BaseFiledCreater;
import com.zhzm.output.tF;
import com.zhzm.utils.BaseEnvironment;

import java.util.Objects;

/**
 * 产生独立线程和数据格式判断
 */
public class SQLCreaterRunner implements Runnable {

    private tF writer;

    private BaseFiledCreater bc;
    private int partCreatemax;

    public SQLCreaterRunner(BaseFiledCreater tableStructure, tF writer) {
        this.writer = writer;
        bc=tableStructure;
        partCreatemax=Objects.equals(BaseEnvironment.getEnvironment("longerInsert"), "true")?
                Integer.parseInt(BaseEnvironment.getEnvironment("longerInsertNumber")):1;
    }

    @Override
    public void run() {
        if(!bc.isClosed()) {
            writer.WriteLine(bc.makeinsert(partCreatemax));
        }
    }
}
