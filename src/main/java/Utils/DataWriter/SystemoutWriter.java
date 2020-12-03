package Utils.DataWriter;

public class SystemoutWriter extends Writer {
    public SystemoutWriter() {}

    @Override
    public boolean WriteLine(String insert) {
        System.out.println(insert);
        return true;
    }
}
