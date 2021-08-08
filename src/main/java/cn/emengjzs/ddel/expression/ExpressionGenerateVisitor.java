package cn.emengjzs.ddel.expression;

import cn.emengjzs.ddel.antlr.DdelParser;
import cn.emengjzs.ddel.antlr.DdelVisitor;
import org.antlr.v4.runtime.tree.*;

public class ExpressionGenerateVisitor extends AbstractParseTreeVisitor<ExpressionNode>
        implements DdelVisitor<ExpressionNode> {


    @Override
    public ExpressionNode visitLiteralExpression(DdelParser.LiteralExpressionContext ctx) {
        return visit(ctx.getChild(0));
    }

    @Override
    public ExpressionNode visitArrayLiteralExpression(DdelParser.ArrayLiteralExpressionContext ctx) {
        return null;
    }

    @Override
    public ExpressionNode visitMemberDotExpression(DdelParser.MemberDotExpressionContext ctx) {
        ExpressionNode member = visit(ctx.getChild(0));
        ExpressionNode field = new VarNode(ctx.IDENTIFIER().getText());
        return new MemberFieldExpression(member, field);
    }

    @Override
    public ExpressionNode visitMemberIndexExpression(DdelParser.MemberIndexExpressionContext ctx) {
        ExpressionNode member = visit(ctx.getChild(0));
        ExpressionNode field = visit(ctx.getChild(1));
        return new MemberFieldExpression(member, field);
    }

    @Override
    public ExpressionNode visitIdentifierExpression(DdelParser.IdentifierExpressionContext ctx) {
        return new VarNode(ctx.getText());
    }

    @Override
    public ExpressionNode visitExpressionSequence(DdelParser.ExpressionSequenceContext ctx) {
        return null;
    }

    @Override
    public ExpressionNode visitArrayLiteral(DdelParser.ArrayLiteralContext ctx) {
        return null;
    }

    @Override
    public ExpressionNode visitElementList(DdelParser.ElementListContext ctx) {
        return null;
    }

    @Override
    public ExpressionNode visitArrayElement(DdelParser.ArrayElementContext ctx) {
        return null;
    }

    @Override
    public ExpressionNode visitDecimalLiteral(DdelParser.DecimalLiteralContext ctx) {
        return new DecimalLiteralNode(Integer.parseInt(ctx.getText()));
    }

    @Override
    public ExpressionNode visitStringLiteral(DdelParser.StringLiteralContext ctx) {
        return new StringLiteralNode(ctx.getText());
    }
}
