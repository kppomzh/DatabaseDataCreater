package DataCreater.TypeCreater;

import Utils.privateRandom;

public class boolTypeCreater extends baseTypeCreaterImpl {
    @Override
    public String getString(Object... option) {
        return String.valueOf(privateRandom.RandomBool());
    }
}
