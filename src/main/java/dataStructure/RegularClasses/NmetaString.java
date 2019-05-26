package dataStructure.RegularClasses;

public class NmetaString implements Regular {
    private String str;
    private LengthExpression length;

    public NmetaString(String str) {
        this.str = str;
        try {
            length=new LengthExpression(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRealName() {
        return "NmetaString";
    }

    @Override
    public void setLength(LengthExpression l) {
        length=l;
    }

    @Override
    public String getGeneratedString() {
        StringBuilder sb=new StringBuilder();
        int StringLength=length.getReplaceNum();
        for(int loop = 0; loop < StringLength; loop++) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Override
    public int getRegularLength() {
        return str.length();
    }
}
