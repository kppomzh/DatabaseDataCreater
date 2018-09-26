# DatabaseDataCreater：一个用于从create table的SQL当中自动生成自定义的insert数据的工具

## 最简化使用方法
1.下载https://github.com/kiloline/DatabaseDataCreater/releases/download/1.1.0/1.1.0.zip  
2.解压  
3.命令行定位到jar包所在位置  
4.输入命令：java -jar DBDF-1.1.0-jar-with-dependencies.jar  
5.按照提示输入create命令和输出条数  
6.在jar包所在的文件夹下就可以找到和表名一致的.sql文件，里面是相应条数的insert数据  
7.复制粘贴运行三连  

## 程序参数详解
-h:显示帮助。  
-f:指定输入的SQL文件位置，如果不指定的话将会询问对什么样的create创建数据。  
-n:指定输出的数据条数，如果不指定的话将会询问具体的输出条数。  
-o:指定保存输出数据的文件夹位置。  
-t:指定线程数量，请根据CPU核心数量来确定。  
-i:指定生成数据的载入方式，有"jdbc"、"sql"、"csv"、"json"、"mongo"五种方式。  
-a:允许异步写（将一个表的insert拆分成多个sql文件），可以加快生成速度；在-t参数大于1时才有实际意义。  
-O:允许SQL优化，将长度上限特别大的字段随机缩短长度，可以加快生成速度，或者模拟现实当中的字段长度。  

## 支持的SQL数据类型
1.数值型  
number  
numeric  
integer  
int  
float  
double  
decimal  
  
2.字符型
varchar  
varchar2  
char  
nvarchar  
string  
text  
  
3.日期型
date  
timestamp  
  
4.布尔型  
boolean  

## 自定义数据格式，按照预计生成数据的方法
### 一般的数据库当中已经存在的方法
1.默认值/default：该关键字后面的跟随的常量将会成为

### 本程序默认的数据格式实现
1.stringtype  
2.numberarea  

### 如何自定义
1.inline方式：  
2.stringtype for free:  

## 配置文件config.properties的参数设置
### 数据库连接部分参数
DBsoftware=  
IP=  
port=  
user=  
password=  
database=  

### 数据导入
toDB=  
#传递给DB的方式，目前允许jdbc（通过jdbc传SQL），sql（写到对应的表名称的sql文件里），
#csv（通过写入类似外部表的文件载入），json（json字符串文件）
baseFileDir=E:/  
canbeNegative=false  
#是否允许数值型数据出现负数，当指定输入范围时失效  

### 性能参数
Optimal=false  
#优化，（伪）随机缩短字符串长度，避免超长字符串的变量生成导致长时间卡顿  
asynchronous=true  
#异步写文件加快输出
TOTAL_THREADS=4  
#这个值请根据CPU核心数量来确定，注意请排除超线程的逻辑核心，不然电脑会奇卡无比  
defaultProportion=0.9  
#默认比例  

## 注意事项
1.关于数据库连接选项的设置这里暂时不提供，请用配置文件实现。  
2.如果通过JDBC方式直接写入数据库的话，由于JDBC本身效率不佳，并且为了保证数据库一致性，并不会开启异步写；也就是-a参数是无效的。  
3.目前文件路径不能带空格，因为暂时没加对于单双引号的参数识别。  
