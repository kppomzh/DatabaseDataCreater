package Utils.Record;

//public record RuntimeEnvironment(
//    int createNum,
//    String sqlString,
//    String dBsoftware,
//    String ip,
//    String port,
//    String user,
//    String password,
//    String database,
//    String toDB,
//    String baseFileDir,
//    String writerEngine,
//    int total_threads,
//    int longerInsertNumber,
//    double defaultProportion,
//    boolean optimal,
//    boolean canbeNegative,
//    boolean longerInsert,
//    Charset envirmentCharset
//) {}

public final class RuntimeEnvironment {
    private final String ServerHost;
    private final Integer ServerPort;

    public RuntimeEnvironment(String ServerHost,Integer ServerPort) {
        this.ServerHost=ServerHost;
        this.ServerPort=ServerPort;
    }

    public String getServerHost() {
        return ServerHost;
    }

    public Integer getServerPort() {
        return ServerPort;
    }
}
