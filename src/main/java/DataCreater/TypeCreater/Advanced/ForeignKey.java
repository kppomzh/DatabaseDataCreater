package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreaterImpl;
import Utils.ArraySetList;
import Utils.privateRandom;
import dataStructure.ListStructure;

import java.util.List;

public class ForeignKey extends baseTypeCreaterImpl {
    private List<String> content;

    public ForeignKey(ListStructure structure){
        this.content=structure.getRelyContent();
    }

    @Override
    public String getString(Object... option) {
        return content.get(privateRandom.RandomInteger(0,content.size()));
    }
}
