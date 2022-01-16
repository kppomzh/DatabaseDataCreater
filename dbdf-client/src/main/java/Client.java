import com.zhzm.antlr.createLexer;
import com.zhzm.antlr.createParser;
import com.zhzm.datastructure.table.TableStructure;
import com.zhzm.parser.CreateListenerImpl;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Collection;

public class Client {
    public static void main(String[] args){

    }

    private static Collection<TableStructure> antlrProcess(String SQL){
        CodePointCharStream input = CharStreams.fromString(SQL);
        createLexer lexer = new createLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        createParser parser = new createParser(tokens);
        parser.removeErrorListeners();
//        parser.addErrorListener(new UnsupportedSyntaxListener());
        ParseTree tree = parser.start();

        ParseTreeWalker walker = new ParseTreeWalker();
        CreateListenerImpl listener = new CreateListenerImpl();
        walker.walk(listener, tree);

        return listener.getTableStructures();
    }

    private static void help() {
        System.out.println("this is a help.");
    }
}
