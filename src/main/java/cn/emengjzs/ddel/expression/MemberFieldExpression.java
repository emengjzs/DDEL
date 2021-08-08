package cn.emengjzs.ddel.expression;

public class MemberFieldExpression extends ExpressionNode {
    private final ExpressionNode member;
    private final ExpressionNode field;

    public MemberFieldExpression(ExpressionNode member, ExpressionNode field) {
        this.member = member;
        this.field = field;
    }
}
