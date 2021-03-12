package Exception.DataException;

import Exception.BaseException;

public class ForeignTableRelyException extends BaseException {
    public ForeignTableRelyException(String table,String parentTable) {
        super("已知表");
        errMessage.append(table);
        errMessage.append("的外键约束关联表");
        errMessage.append(parentTable);
        errMessage.append("不存在，请检查SQL中是否存在该表。");
    }
}
