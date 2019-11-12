package interpreter.launcher;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import interpreter.InterpreterParser;
import interpreter.InterpreterLexer;


public class Main {
    public static void main(String[] args) {
        InterpreterLexer lexer = new InterpreterLexer(CharStreams.fromString("1+2+5"));
        InterpreterParser parser = new InterpreterParser(new CommonTokenStream(lexer));

        parser.start();
        System.out.println("My parser has executed Order 66");
    }
}
