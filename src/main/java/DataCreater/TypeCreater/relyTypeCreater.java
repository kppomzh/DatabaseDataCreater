package DataCreater.TypeCreater;

import java.util.List;

public class relyTypeCreater extends baseTypeCreaterImpl{
    protected baseTypeCreater creater;
    protected List<String> data;

    public relyTypeCreater(baseTypeCreater creater, List<String> data){
        this.creater=creater;
        this.data=data;
    }

    @Override
    public String getString(Object... option) {
        String s=creater.getString(option);
        data.add(s);
        return s;
    }
}
