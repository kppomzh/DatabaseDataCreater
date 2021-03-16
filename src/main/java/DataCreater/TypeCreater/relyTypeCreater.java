package DataCreater.TypeCreater;

import java.util.Collection;

public class relyTypeCreater extends baseTypeCreaterImpl{
    protected baseTypeCreater creater;
    protected Collection<String> data;

    public relyTypeCreater(baseTypeCreater creater, Collection<String> data){
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
