package com.zhzm.utils.insert;

import com.zhzm.datacreater.line.BaseFiledCreater;
import com.zhzm.output.tF;
import com.zhzm.utils.BaseEnvironment;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CreateInsertSQLProcess {
    private int basicThreads = Integer.valueOf(BaseEnvironment.getEnvironment("basicThread"));
    private ExecutorService service = Executors.newFixedThreadPool(basicThreads);//根据CPU核心最大值确定线程数量，一般是核心数减一
    private tF output;

    public void createInsertSQL(List<BaseFiledCreater> creaters) throws Exception {
        makePool(creaters);

        service.shutdown();
        service.awaitTermination(7, TimeUnit.DAYS);
    }

    private void makePool(List<BaseFiledCreater> writerlist) throws CloneNotSupportedException {
        for (int loop = 0; loop < writerlist.size(); loop++)
            service.execute(new SQLCreaterRunner(
                    writerlist.get(loop),
                    output));
    }

    public void setOutput(tF output) {
        this.output = output;
    }
}
