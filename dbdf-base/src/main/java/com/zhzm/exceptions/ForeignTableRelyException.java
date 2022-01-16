package com.zhzm.exceptions;

public class ForeignTableRelyException extends BaseException {
    public ForeignTableRelyException(String table, String parentTable) {
        errMessage.append("已知表");
        errMessage.append(table);
        errMessage.append("的外键约束关联表");
        errMessage.append(parentTable);
        errMessage.append("不存在，请检查SQL中是否存在该表。");
    }
}
