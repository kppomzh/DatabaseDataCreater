public class help {
    static String help="本程序的作用是根据给定的建立数据库表的SQL（create语句），自动的生成给定行数的数据，\n" +
            "这些数据可以以insert语句的方式产生，也可以是逗号隔开的格式通过数据库外部表或load工具来利用。支持通过JDBC直接导入数据。支持json。\n" +
            "目前本工具不支持过分复杂的create，比如带有索引或者约束定义位置太偏的SQL方言，会被掠过。\n" +
            "目前可以在每个字段的后面加上stringtype关键字来指定当前字段的数据格式，其中固定格式包括ch_idcard（中国身份证号）、\n" +
            "telephone（手机号）、email（电子邮件）、ch_word（汉字字符串）的随机生成；自定义格式支持以下五种：字母 c、大写字母 b、小写字母 s、数字 n、（特定）标点符号 m\n" +
            "，字母后面加上数字表示生成数量，另外可以用单引号表达特定字符串，比如'http://'，就可以在特定位置生成http://字符串。\n" +
            "字段类型会覆盖先前指定的类型，所以务必保证对应字段的数据类型是长度足够的字符串形式。\n" +
            "例如create table t(id varchar2(20) stringtype ch_idcard);，就会向id字段中填入随机的身份证号。\n" +
            "-f:指定输入的SQL文件目录，如果不指定的话将会询问对什么样的create创建数据\n" +
            "-n:指定输出的数据条数，如果不指定的话将会询问具体的输出条数\n" +
            "-h:显示帮助\n" +
            "-o:指定保存输出数据的文件夹位置\n" +
            "-t:指定线程数量，请根据CPU核心数量来确定\n" +
            "-i:指定生成数据的载入方式，有\"jdbc\"、\"sql\"、\"csv\"、\"json\"四种方式。关于数据库连接选项的设置这里暂时不提供，\n请用配置文" +
            "件实现。\n" +
            "-a:允许异步写（将一个表的insert拆分成多个sql文件），可以加快生成速度。\n" +
            "-O:允许SQL优化，将特别长的字符串随机缩短长度之后再输出，可以加快生成速度。\n";
    public static void printHelpMessage()
    {
        System.out.println(help);
    }
}
