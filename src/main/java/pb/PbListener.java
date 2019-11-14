package pb;

import com.khubla.antlr4example.Protobuf3Listener;
import com.khubla.antlr4example.Protobuf3Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PbListener implements Protobuf3Listener {
    private static final Logger logger = LoggerFactory.getLogger(PbListener.class);

    @Override
    public void enterProto(Protobuf3Parser.ProtoContext ctx) {

    }

    @Override
    public void exitProto(Protobuf3Parser.ProtoContext ctx) {

    }

    @Override
    public void enterSyntax(Protobuf3Parser.SyntaxContext ctx) {

    }

    @Override
    public void exitSyntax(Protobuf3Parser.SyntaxContext ctx) {

    }

    @Override
    public void enterImportStatement(Protobuf3Parser.ImportStatementContext ctx) {

    }

    @Override
    public void exitImportStatement(Protobuf3Parser.ImportStatementContext ctx) {

    }

    @Override
    public void enterPackageStatement(Protobuf3Parser.PackageStatementContext ctx) {

    }

    @Override
    public void exitPackageStatement(Protobuf3Parser.PackageStatementContext ctx) {

    }

    @Override
    public void enterOption(Protobuf3Parser.OptionContext ctx) {

    }

    @Override
    public void exitOption(Protobuf3Parser.OptionContext ctx) {

    }

    @Override
    public void enterOptionName(Protobuf3Parser.OptionNameContext ctx) {

    }

    @Override
    public void exitOptionName(Protobuf3Parser.OptionNameContext ctx) {

    }

    @Override
    public void enterTopLevelDef(Protobuf3Parser.TopLevelDefContext ctx) {

    }

    @Override
    public void exitTopLevelDef(Protobuf3Parser.TopLevelDefContext ctx) {

    }

    private static String getMessageName(Protobuf3Parser.MessageContext ctx) {
        return ctx.getChild(1).getText();
    }

    private static String getFieldName(ParseTree parseTree) {
        return parseTree.getText();
    }

    @Override
    public void enterMessage(Protobuf3Parser.MessageContext ctx) {
        logger.info("void check{}({} obj) {", getMessageName(ctx), getMessageName(ctx));
    }

    @Override
    public void exitMessage(Protobuf3Parser.MessageContext ctx) {
        logger.info("}");
    }

    @Override
    public void enterMessageBody(Protobuf3Parser.MessageBodyContext ctx) {
    }

    @Override
    public void exitMessageBody(Protobuf3Parser.MessageBodyContext ctx) {

    }

    @Override
    public void enterEnumDefinition(Protobuf3Parser.EnumDefinitionContext ctx) {

    }

    @Override
    public void exitEnumDefinition(Protobuf3Parser.EnumDefinitionContext ctx) {

    }

    @Override
    public void enterEnumBody(Protobuf3Parser.EnumBodyContext ctx) {

    }

    @Override
    public void exitEnumBody(Protobuf3Parser.EnumBodyContext ctx) {

    }

    @Override
    public void enterEnumField(Protobuf3Parser.EnumFieldContext ctx) {

    }

    @Override
    public void exitEnumField(Protobuf3Parser.EnumFieldContext ctx) {

    }

    @Override
    public void enterEnumValueOption(Protobuf3Parser.EnumValueOptionContext ctx) {

    }

    @Override
    public void exitEnumValueOption(Protobuf3Parser.EnumValueOptionContext ctx) {

    }

    @Override
    public void enterService(Protobuf3Parser.ServiceContext ctx) {

    }

    @Override
    public void exitService(Protobuf3Parser.ServiceContext ctx) {

    }

    @Override
    public void enterRpc(Protobuf3Parser.RpcContext ctx) {

    }

    @Override
    public void exitRpc(Protobuf3Parser.RpcContext ctx) {

    }

    @Override
    public void enterReserved(Protobuf3Parser.ReservedContext ctx) {

    }

    @Override
    public void exitReserved(Protobuf3Parser.ReservedContext ctx) {

    }

    @Override
    public void enterRanges(Protobuf3Parser.RangesContext ctx) {

    }

    @Override
    public void exitRanges(Protobuf3Parser.RangesContext ctx) {

    }

    @Override
    public void enterRange(Protobuf3Parser.RangeContext ctx) {

    }

    @Override
    public void exitRange(Protobuf3Parser.RangeContext ctx) {

    }

    @Override
    public void enterFieldNames(Protobuf3Parser.FieldNamesContext ctx) {

    }

    @Override
    public void exitFieldNames(Protobuf3Parser.FieldNamesContext ctx) {

    }

    @Override
    public void enterType(Protobuf3Parser.TypeContext ctx) {

    }

    @Override
    public void exitType(Protobuf3Parser.TypeContext ctx) {

    }

    @Override
    public void enterFieldNumber(Protobuf3Parser.FieldNumberContext ctx) {

    }

    @Override
    public void exitFieldNumber(Protobuf3Parser.FieldNumberContext ctx) {

    }

    static String getType(Protobuf3Parser.FieldContext ctx) {
        return ctx.getChild(0).getText();
    }

    static String getName(Protobuf3Parser.FieldContext ctx) {
        return ctx.getChild(1).getText();
    }

    @Override
    public void enterField(Protobuf3Parser.FieldContext ctx) {
        logger.info("type : {}", getType(ctx));
        logger.info("name : {}", getName(ctx));
    }

    @Override
    public void exitField(Protobuf3Parser.FieldContext ctx) {

    }

    @Override
    public void enterFieldOptions(Protobuf3Parser.FieldOptionsContext ctx) {

    }

    @Override
    public void exitFieldOptions(Protobuf3Parser.FieldOptionsContext ctx) {

    }

    @Override
    public void enterFieldOption(Protobuf3Parser.FieldOptionContext ctx) {

    }

    @Override
    public void exitFieldOption(Protobuf3Parser.FieldOptionContext ctx) {

    }

    @Override
    public void enterOneof(Protobuf3Parser.OneofContext ctx) {

    }

    @Override
    public void exitOneof(Protobuf3Parser.OneofContext ctx) {

    }

    @Override
    public void enterOneofField(Protobuf3Parser.OneofFieldContext ctx) {

    }

    @Override
    public void exitOneofField(Protobuf3Parser.OneofFieldContext ctx) {

    }

    @Override
    public void enterMapField(Protobuf3Parser.MapFieldContext ctx) {

    }

    @Override
    public void exitMapField(Protobuf3Parser.MapFieldContext ctx) {

    }

    @Override
    public void enterKeyType(Protobuf3Parser.KeyTypeContext ctx) {

    }

    @Override
    public void exitKeyType(Protobuf3Parser.KeyTypeContext ctx) {

    }

    @Override
    public void enterReservedWord(Protobuf3Parser.ReservedWordContext ctx) {

    }

    @Override
    public void exitReservedWord(Protobuf3Parser.ReservedWordContext ctx) {

    }

    @Override
    public void enterFullIdent(Protobuf3Parser.FullIdentContext ctx) {

    }

    @Override
    public void exitFullIdent(Protobuf3Parser.FullIdentContext ctx) {

    }

    @Override
    public void enterMessageName(Protobuf3Parser.MessageNameContext ctx) {

    }

    @Override
    public void exitMessageName(Protobuf3Parser.MessageNameContext ctx) {

    }

    @Override
    public void enterEnumName(Protobuf3Parser.EnumNameContext ctx) {

    }

    @Override
    public void exitEnumName(Protobuf3Parser.EnumNameContext ctx) {

    }

    @Override
    public void enterMessageOrEnumName(Protobuf3Parser.MessageOrEnumNameContext ctx) {

    }

    @Override
    public void exitMessageOrEnumName(Protobuf3Parser.MessageOrEnumNameContext ctx) {

    }

    @Override
    public void enterFieldName(Protobuf3Parser.FieldNameContext ctx) {

    }

    @Override
    public void exitFieldName(Protobuf3Parser.FieldNameContext ctx) {

    }

    @Override
    public void enterOneofName(Protobuf3Parser.OneofNameContext ctx) {

    }

    @Override
    public void exitOneofName(Protobuf3Parser.OneofNameContext ctx) {

    }

    @Override
    public void enterMapName(Protobuf3Parser.MapNameContext ctx) {

    }

    @Override
    public void exitMapName(Protobuf3Parser.MapNameContext ctx) {

    }

    @Override
    public void enterServiceName(Protobuf3Parser.ServiceNameContext ctx) {

    }

    @Override
    public void exitServiceName(Protobuf3Parser.ServiceNameContext ctx) {

    }

    @Override
    public void enterRpcName(Protobuf3Parser.RpcNameContext ctx) {

    }

    @Override
    public void exitRpcName(Protobuf3Parser.RpcNameContext ctx) {

    }

    @Override
    public void enterMessageType(Protobuf3Parser.MessageTypeContext ctx) {

    }

    @Override
    public void exitMessageType(Protobuf3Parser.MessageTypeContext ctx) {

    }

    @Override
    public void enterMessageOrEnumType(Protobuf3Parser.MessageOrEnumTypeContext ctx) {

    }

    @Override
    public void exitMessageOrEnumType(Protobuf3Parser.MessageOrEnumTypeContext ctx) {

    }

    @Override
    public void enterEmptyStatement(Protobuf3Parser.EmptyStatementContext ctx) {

    }

    @Override
    public void exitEmptyStatement(Protobuf3Parser.EmptyStatementContext ctx) {

    }

    @Override
    public void enterConstant(Protobuf3Parser.ConstantContext ctx) {

    }

    @Override
    public void exitConstant(Protobuf3Parser.ConstantContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
