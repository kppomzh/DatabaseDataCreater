package Utils.DataWriter;

import dataStructure.RuntimeEnvironment;

public class SystemoutWriter extends BaseWriter {
    public SystemoutWriter(RuntimeEnvironment env) {
        super(env);
    }

    @Override
    public boolean WriteLine(String insert) {
        System.out.println(insert);
        return true;
    }
}
