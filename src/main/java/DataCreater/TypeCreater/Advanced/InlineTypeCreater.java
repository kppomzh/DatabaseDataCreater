package DataCreater.TypeCreater.Advanced;

import DataCreater.TypeCreater.baseTypeCreater;
import Utils.privateRandom;
import org.jetbrains.annotations.NotNull;

public class InlineTypeCreater implements baseTypeCreater {
    private String[] inlineArray;

    public InlineTypeCreater(@NotNull String[] inline){
        inlineArray=inline;
    }

    @Override
    public String getString(Object... option) {
        return inlineArray[privateRandom.RandomInteger(0,inlineArray.length)];
    }
}
