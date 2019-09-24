package CreateSQLParser.Lex;

import java.util.Objects;

public class Coolean {
    public static Coolean letter = new Coolean("letter");
    public static Coolean mark = new Coolean("mark");
    public static Coolean stop = new Coolean("stop");
    String status;

    private Coolean(String str) {
        this.status = str;
    }

    @Override
    public String toString() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (o.hashCode() == this.hashCode())
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 37 * hash + Objects.hashCode(this.status);
        return hash;
    }
}
