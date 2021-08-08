// Generated from /Users/emengjzs/Documents/programs/ddel/src/main/resources/Ddel.g4 by ANTLR 4.9.1

    package cn.emengjzs.ddel.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DdelParser}.
 */
public interface DdelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(DdelParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(DdelParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpression(DdelParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpression(DdelParser.ArrayLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotExpression(DdelParser.MemberDotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotExpression(DdelParser.MemberDotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexExpression(DdelParser.MemberIndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexExpression(DdelParser.MemberIndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(DdelParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link DdelParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(DdelParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DdelParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(DdelParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DdelParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(DdelParser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DdelParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(DdelParser.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DdelParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(DdelParser.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DdelParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(DdelParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DdelParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(DdelParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DdelParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(DdelParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DdelParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(DdelParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link DdelParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(DdelParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link DdelParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(DdelParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link DdelParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(DdelParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link DdelParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(DdelParser.StringLiteralContext ctx);
}