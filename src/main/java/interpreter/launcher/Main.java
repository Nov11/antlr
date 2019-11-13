package interpreter.launcher;

import com.khubla.antlr4example.InterpreterLexer;
import com.khubla.antlr4example.InterpreterListener;
import com.khubla.antlr4example.InterpreterParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.IterativeParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        InterpreterLexer lexer = new InterpreterLexer(CharStreams.fromString("1+2+5"));
        InterpreterParser parser = new InterpreterParser(new CommonTokenStream(lexer));

        InterpreterParser.StartContext ctx = parser.start();

        IterativeParseTreeWalker walker = new IterativeParseTreeWalker();
        walker.walk(new InterpreterListener() {
            @Override
            public void visitTerminal(TerminalNode terminalNode) {
                logger.info("t : {}", terminalNode);
            }

            @Override
            public void visitErrorNode(ErrorNode errorNode) {
                logger.info("e: {}", errorNode);
            }

            @Override
            public void enterEveryRule(ParserRuleContext parserRuleContext) {
                logger.info("enterEveryRule: {}", parserRuleContext);
            }

            @Override
            public void exitEveryRule(ParserRuleContext parserRuleContext) {
                logger.info("exitEveryRule: {}", parserRuleContext);
            }

            @Override
            public void enterStart(InterpreterParser.StartContext ctx) {
                logger.info("enter s: {}", ctx);
            }

            @Override
            public void exitStart(InterpreterParser.StartContext ctx) {
                logger.info("exit s: {}", ctx);
            }

            @Override
            public void enterExpression(InterpreterParser.ExpressionContext ctx) {
                logger.info("enterExpression: {}", ctx);
            }

            @Override
            public void exitExpression(InterpreterParser.ExpressionContext ctx) {
                logger.info("exitExpression: {}", ctx);
            }
        }, ctx);
        System.out.println("My parser has executed Order 66");
    }
}
