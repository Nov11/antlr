package pb;

import com.khubla.antlr4example.Protobuf3Lexer;
import com.khubla.antlr4example.Protobuf3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Walker {
    private static final Logger logger = LoggerFactory.getLogger(Walker.class);

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/protobuf/helloworld.proto");
        System.out.println(path.toAbsolutePath());
        CharStream input = CharStreams.fromPath(path);
        Protobuf3Lexer protobuf3Lexer = new Protobuf3Lexer(input);

        Protobuf3Parser protobuf3Parser = new Protobuf3Parser(new CommonTokenStream(protobuf3Lexer));

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(new PbListener(), protobuf3Parser.proto());
    }
}
