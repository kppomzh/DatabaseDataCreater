package Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArraySetList<T> extends ArrayList<T> {
    private Set<T> onlySet=new HashSet<>();

    public boolean add(T element){
        if(onlySet.add(element)){
            return super.add(element);
        }
        else {
            return false;
        }
    }
}
