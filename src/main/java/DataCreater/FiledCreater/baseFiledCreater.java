package DataCreater.FiledCreater;

import Utils.baseEnvironment;
import dataStructure.ListStructure;
import dataStructure.TableStructure;

import java.util.*;

public abstract class baseFiledCreater {
    protected TableStructure tableStructure;
    private Map<String, Set<String>> unique;
    protected ListStructure[] toMakeInserts;

    public baseFiledCreater(TableStructure tableStructure) {
        this.tableStructure = tableStructure;
        this.unique = new HashMap<>();
        List<ListStructure> temp=new ArrayList<>();
        while (this.tableStructure.hasNext()) {
            ListStructure list = tableStructure.getNextStruc();

            if (list.isUnmake()) {
                continue;
            }
            else {
                if (list.isSingal()) {
                    unique.put(list.getListname(), new HashSet<>());
                }
                temp.add(list);
            }
        }
        toMakeInserts=temp.toArray(new ListStructure[0]);
    }


    /**
     * 生成对应数据形式的插入内容
     *
     * @return
     * @throws Exception
     */
    public String makeinsert(int makenum) {
        StringBuilder Return = new StringBuilder(packHead());

        for (int loop = 0; loop < makenum; loop++) {
            try {
                Return.append(packFiled());
            } catch (Exception e) {
                System.out.println(Return.toString());
                throw new RuntimeException(e.getMessage());
            }
        }

        Return.deleteCharAt(Return.length() - 1);
        Return.append(packTail());
//        Return.deleteCharAt(Return.length() - 1);

        return new String(Return.toString().getBytes(), baseEnvironment.getEnvirmentCharset());
    }

    /**
     * 用于唯一约束检测，每一个线程会分配一个
     *
     * @param ls
     * @param appendStr
     */
    protected boolean addtoSet(ListStructure ls, String appendStr) {
        if (ls.isSingal()) {
            if (unique.get(ls.getListname()).contains(appendStr)) {
                return false;//错误标记，用于一旦出现了重复的字段内容的时候重新生成数据
            } else {
                unique.get(ls.getListname()).add(appendStr);
            }
        }
        return true;
    }

    /**
     * @return
     */
    protected String[] makeOnceData(){
        String fileds[]=new String[toMakeInserts.length];
        for (int i = 0; i < toMakeInserts.length; i++) {
            fileds[i]=toMakeInserts[i].getString();
            while (!addtoSet(toMakeInserts[i], fileds[i])) {
                fileds[i] = toMakeInserts[i].getString();
            }
        }
        return fileds;
    }

    /**
     * 依赖于不同的数据格式，一条数据插入时候的头部特殊格式
     *
     * @return
     */
    protected abstract String packHead();

    /**
     * 依赖于不同的数据格式，各类型字段的特殊格式
     *
     * @return
     */
    protected abstract String packFiled() throws Exception;

    /**
     * 依赖于不同的数据格式，一条数据插入时候的尾部特殊格式
     *
     * @return
     */
    protected abstract String packTail();
}
