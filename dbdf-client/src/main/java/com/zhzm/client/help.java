package com.zhzm.client;

import com.zhzm.utils.BaseEnvironment;

public class help {
    static String help="本程序的作用是根据给定的建立数据库表的SQL（create语句），自动的生成给定行数的数据，\n" +
            "这些数据可以以insert语句的方式产生，也可以是逗号隔开的格式通过数据库外部表或load工具来利用。支持通过JDBC直接导入数据。支持json。\n" +
            "目前本工具不支持过分复杂的create，比如带有索引或者约束定义位置太偏的SQL方言，会被掠过。\n" +
            "目前可以在每个字段的后面加上stringtype关键字来指定当前字段的数据格式，\n其中固定格式包括ch_idcard（中国身份证号）、" +
            "telephone（手机号）、email（电子邮件）、ch_word（汉字字符串）、a/b/c/d/e_ip（五种IP地址）、warp_latitude（经纬度）的随机生成。\n" +
            "字段类型会覆盖先前指定的类型，所以务必保证对应字段的数据类型是长度足够的字符串形式。\n" +
            "例如create table t(id varchar2(20) stringtype ch_idcard);，就会向id字段中填入随机的身份证号。\n" +
            "目前可以在每个字段的后面加上numberarea关键字指定生成数值类型的范围，例如numberarea 5~10，就会生成范围在{5,6,7,8,9,10}之内的任意数，根据字段类型也可以是浮点数。 \n" +
            "目前可以在每个字段后面加上大括号来表示本字段只用某几个固定的值来填充，比如\"name varchar(10) {\"aaa\",\"bbb\"}\"，这样的话那么这个字段里的值就只有aaa和bbb；\n" +
            "或者也可以用\"id number {1,2,3}\"；该方式会覆盖唯一约束、默认值、stringtype、numberarea等方式。\n"+
            "目前可以通过default关键字设置数值型/字符型字段的默认值，但是不对数据逻辑进行检验，请自行保证正确性。\n"+
            "-f:指定输入的SQL文件目录，如果不指定的话将会询问对什么样的create创建数据\n" +
            "-H:指定输出的数据条数，如果不指定的话将会询问具体的输出条数\n" +
            "-p:生成服务器通讯端口，默认值8088。\n" +
            "-h:显示帮助\n" +
            "-v:显示当前工具版本\n" +
            "-o:指定保存输出数据的文件夹位置\n" +
            "-t:指定输出文件格式\"jdbc\"、\"sql\"、\"csv\"、\"json\"四种方式。关于数据库连接选项的设置这里暂时不提供，请用配置文件实现。\n" +
            "-i:指定生成数据的载入方式，有\"jdbc\"、\"sql\"、\"csv\"、\"json\"四种方式。关于数据库连接选项的设置这里暂时不提供，请用配置文件实现。\n"
            ;


    public static void printVersion(){
        System.out.println(BaseEnvironment.getEnvironment("version"));
    }
    public static void printHelpMessage()
    {
        System.out.println(help);
    }
}
