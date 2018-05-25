package SavingTypeString;

import java.util.HashSet;

public class stringType {
    private static stringType st=new stringType();
    private HashSet<String> typeSet;
    private stringType(){
        typeSet=new HashSet<>();
        typeSet.add("c");
        typeSet.add("b");
        typeSet.add("s");
        typeSet.add("n");
        typeSet.add("m");
    }

    public static boolean checkStringType(String s)
    {
        return st.typeSet.contains(s);
    }
}
