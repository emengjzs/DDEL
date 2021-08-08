package cn.emengjzs.ddel;

import cn.emengjzs.ddel.antlr.DdelLexer;
import cn.emengjzs.ddel.antlr.DdelParser;
import cn.emengjzs.ddel.expression.ExpressionGenerateVisitor;
import cn.emengjzs.ddel.expression.ExpressionNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class ParseTest {

    @Test
    public void test() {
        CharStream input = CharStreams.fromString("a['v']");
        // 词法分析->Token流->生成语法分析器对象
        DdelLexer lexer = new DdelLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DdelParser parser = new DdelParser(tokens);
        ParseTree tree = parser.expression();
        ExpressionGenerateVisitor evalVisitor = new ExpressionGenerateVisitor();
        ExpressionNode expressionNode = evalVisitor.visit(tree);
        ExpressionNode expressionNode1 = expressionNode;
    }

}
