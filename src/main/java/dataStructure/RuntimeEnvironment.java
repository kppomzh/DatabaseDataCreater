package dataStructure;

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

import java.nio.charset.Charset;

public final class RuntimeEnvironment{
    private final double createNum;
    private final String SQLString;
    private final String DBsoftware,IP,port,user,password,database;

    private final String toDB,baseFileDir,WriterEngine;

    private final int TOTAL_THREADS,longerInsertNumber;
    private final double defaultProportion;
    private final boolean Optimal,canbeNegative,longerInsert;

    private final Charset envirmentCharset;

    public RuntimeEnvironment(Double createNum, String sqlString, String dBsoftware, String ip, String port, String user, String password, String database, String toDB, String baseFileDir, String writerEngine, int total_threads, int longerInsertNumber, double defaultProportion, boolean optimal, boolean canbeNegative, boolean longerInsert, Charset envirmentCharset) {
        this.createNum = createNum;
        SQLString = sqlString;
        DBsoftware = dBsoftware;
        IP = ip;
        this.port = port;
        this.user = user;
        this.password = password;
        this.database = database;
        this.toDB = toDB;
        this.baseFileDir = baseFileDir;
        WriterEngine = writerEngine;
        TOTAL_THREADS = total_threads;
        this.longerInsertNumber = longerInsertNumber;
        this.defaultProportion = defaultProportion;
        Optimal = optimal;
        this.canbeNegative = canbeNegative;
        this.longerInsert = longerInsert;
        this.envirmentCharset = envirmentCharset;
    }

    public double getCreateNum() {
        return createNum;
    }

    public Charset getEnvirmentCharset() {
        return envirmentCharset;
    }

    public String getSQLString() {
        return SQLString;
    }

    public String getDBsoftware() {
        return DBsoftware;
    }

    public String getIP() {
        return IP;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }

    public String getToDB() {
        return toDB;
    }

    public String getBaseFileDir() {
        return baseFileDir;
    }

    public String getWriterEngine() {
        return WriterEngine;
    }

    public int getTOTAL_THREADS() {
        return TOTAL_THREADS;
    }

    public int getLongerInsertNumber() {
        return longerInsertNumber;
    }

    public double getDefaultProportion() {
        return defaultProportion;
    }

    public boolean isOptimal() {
        return Optimal;
    }

    public boolean isCanbeNegative() {
        return canbeNegative;
    }

    public boolean isLongerInsert() {
        return longerInsert;
    }
}
