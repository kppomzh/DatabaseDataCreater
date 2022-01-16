package com.zhzm.datastructure.table.index;

import com.zhzm.ENUM.BoolLinkOption;

public class CheckOption {
    private String invListname;
    private String type;
    private BoolLinkOption link=BoolLinkOption.AND;
    private Object[] options;

    public String getInvListname() {
        return invListname;
    }

    public void setInvListname(String invListname) {
        this.invListname = invListname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] getOptions() {
        return options;
    }

    public void setOptions(Object[] options) {
        this.options = options;
    }

    public BoolLinkOption getLink() {
        return link;
    }

    public void setLink(BoolLinkOption link) {
        this.link = link;
    }
}
