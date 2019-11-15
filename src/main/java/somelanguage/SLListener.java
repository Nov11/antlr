package somelanguage;

import com.khubla.antlr4example.SomeLanguageBaseListener;
import com.khubla.antlr4example.SomeLanguageLexer;
import com.khubla.antlr4example.SomeLanguageParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.NotNull;

public class SLListener {
    public static void main(String[] args) {
        String code = "public class Class {\n" +
                "    private String name;\n" +
                "    private Collection<Method> methods;\n" +
                "}\n" +
                "\n" +
                "public class Method {\n" +
                "    private String name;\n" +
                "    private Collection<Instruction> instructions;\n" +
                "}\n" +
                "\n" +
                "public class Instruction {\n" +
                "    private String name;\n" +
                "}";
        CharStream charStream = new ANTLRInputStream(code);
        SomeLanguageLexer lexer = new SomeLanguageLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        SomeLanguageParser parser = new SomeLanguageParser(tokens);

    }


}