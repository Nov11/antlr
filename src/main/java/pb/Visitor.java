package pb;

import com.khubla.antlr4example.Protobuf3BaseVisitor;
import com.khubla.antlr4example.Protobuf3Lexer;
import com.khubla.antlr4example.Protobuf3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Visitor {
    private static final Logger logger = LoggerFactory.getLogger(Visitor.class);

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/protobuf/helloworld.proto");
        CharStream input = CharStreams.fromPath(path);
        Protobuf3Lexer protobuf3Lexer = new Protobuf3Lexer(input);
        Protobuf3Parser protobuf3Parser = new Protobuf3Parser(new CommonTokenStream(protobuf3Lexer));

//        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
//        parseTreeWalker.walk(new PbListener(), protobuf3Parser.proto());
        MessageVisitor messageVisitor = new MessageVisitor();
//        messageVisitor.
        messageVisitor.visit(protobuf3Parser.proto());
    }

    private static class MessageVisitor extends Protobuf3BaseVisitor<List<String>> {
        @Override
        public List<String> visitMessage(Protobuf3Parser.MessageContext ctx) {
            String msgName = ctx.messageName().getText();
            logger.info("msgName : {}", msgName);
            return super.visitMessage(ctx);
        }
    }
}
