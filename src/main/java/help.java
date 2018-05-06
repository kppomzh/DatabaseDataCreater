public class help {
    static String help="本程序的作用是根据给定的建立数据库表的SQL \n" +
            "（create语句），自动的生成给定行数的数据，\n" +
            "这些数据可以以insert语句的方式产生，也可以\n" +
            "是逗号隔开的格式通过数据库外部表或load工具\n" +
            "来利用。支持通过JDBC直接导入数据。\n" +
            "目前本工具不支持过分复杂的create，比如带有\n" +
            "索引或者带默认值的SQL，会被掠过。\n" +
            "-f:指定输入的SQL文件目录，如果不指定的话将会询问对什么样的create创建数据\n" +
            "-n:指定输出的数据条数，如果不指定的话将会询问具体的输出条数\n" +
            "-h:显示帮助\n" +
            "-o:指定保存输出数据的文件夹位置\n" +
            "-t:指定线程数量，请根据CPU核心数量来确定\n" +
            "-i:指定生成数据的载入方式，有\"jdbc\"、\"file\"、\"load\"三种方式。\n" +
            "关于数据库连接选项的设置这里暂时不提供，\n请用配置文件实现";
    public void printHelpMessage()
    {
        System.out.println(help);
    }
}
