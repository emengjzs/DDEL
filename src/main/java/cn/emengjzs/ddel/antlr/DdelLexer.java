// Generated from /Users/emengjzs/Documents/programs/ddel/src/main/resources/Ddel.g4 by ANTLR 4.9.1

    package cn.emengjzs.ddel.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DdelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DECIMAL_LITERAL=1, STRING_LITERAL=2, DOT=3, LBRACK=4, RBRACK=5, COMMA=6, 
		IDENTIFIER=7, WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DECIMAL_LITERAL", "STRING_LITERAL", "DOT", "LBRACK", "RBRACK", "COMMA", 
			"IDENTIFIER", "WS", "ExponentPart", "EscapeSequence", "HexDigit", "Digits", 
			"LetterOrDigit", "Letter"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'.'", "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DECIMAL_LITERAL", "STRING_LITERAL", "DOT", "LBRACK", "RBRACK", 
			"COMMA", "IDENTIFIER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public DdelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ddel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\ny\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\5\2#\n\2\5\2%\n\2"+
		"\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\7\b;\n\b\f\b\16\b>\13\b\3\t\6\tA\n\t\r\t\16\tB\3\t\3\t"+
		"\3\n\3\n\5\nI\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13Q\n\13\3\13\5\13T\n"+
		"\13\3\13\3\13\3\13\6\13Y\n\13\r\13\16\13Z\3\13\3\13\3\13\3\13\3\13\5\13"+
		"b\n\13\3\f\3\f\3\r\3\r\7\rh\n\r\f\r\16\rk\13\r\3\r\5\rn\n\r\3\16\3\16"+
		"\5\16r\n\16\3\17\3\17\3\17\3\17\5\17x\n\17\2\2\20\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\2\25\2\27\2\31\2\33\2\35\2\3\2\21\3\2\63;\6\2\f\f\17"+
		"\17))^^\5\2\13\f\16\17\"\"\4\2GGgg\4\2--//\n\2$$))^^ddhhppttvv\3\2\62"+
		"\65\3\2\629\5\2\62;CHch\3\2\62;\4\2\62;aa\6\2&&C\\aac|\4\2\2\u0081\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\2\u0083\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\3$\3\2\2\2\5&\3\2\2\2\7\60\3\2\2\2\t\62\3\2\2\2\13\64\3\2\2\2\r"+
		"\66\3\2\2\2\178\3\2\2\2\21@\3\2\2\2\23F\3\2\2\2\25a\3\2\2\2\27c\3\2\2"+
		"\2\31e\3\2\2\2\33q\3\2\2\2\35w\3\2\2\2\37%\7\62\2\2 \"\t\2\2\2!#\5\31"+
		"\r\2\"!\3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\37\3\2\2\2$ \3\2\2\2%\4\3\2\2\2"+
		"&+\7)\2\2\'*\n\3\2\2(*\5\25\13\2)\'\3\2\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2"+
		"\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7)\2\2/\6\3\2\2\2\60\61\7\60\2\2"+
		"\61\b\3\2\2\2\62\63\7]\2\2\63\n\3\2\2\2\64\65\7_\2\2\65\f\3\2\2\2\66\67"+
		"\7.\2\2\67\16\3\2\2\28<\5\35\17\29;\5\33\16\2:9\3\2\2\2;>\3\2\2\2<:\3"+
		"\2\2\2<=\3\2\2\2=\20\3\2\2\2><\3\2\2\2?A\t\4\2\2@?\3\2\2\2AB\3\2\2\2B"+
		"@\3\2\2\2BC\3\2\2\2CD\3\2\2\2DE\b\t\2\2E\22\3\2\2\2FH\t\5\2\2GI\t\6\2"+
		"\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\5\31\r\2K\24\3\2\2\2LM\7^\2\2Mb\t\7"+
		"\2\2NS\7^\2\2OQ\t\b\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RT\t\t\2\2SP\3\2"+
		"\2\2ST\3\2\2\2TU\3\2\2\2Ub\t\t\2\2VX\7^\2\2WY\7w\2\2XW\3\2\2\2YZ\3\2\2"+
		"\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\5\27\f\2]^\5\27\f\2^_\5\27\f\2_`"+
		"\5\27\f\2`b\3\2\2\2aL\3\2\2\2aN\3\2\2\2aV\3\2\2\2b\26\3\2\2\2cd\t\n\2"+
		"\2d\30\3\2\2\2em\t\13\2\2fh\t\f\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3"+
		"\2\2\2jl\3\2\2\2ki\3\2\2\2ln\t\13\2\2mi\3\2\2\2mn\3\2\2\2n\32\3\2\2\2"+
		"or\5\35\17\2pr\t\13\2\2qo\3\2\2\2qp\3\2\2\2r\34\3\2\2\2sx\t\r\2\2tx\n"+
		"\16\2\2uv\t\17\2\2vx\t\20\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2x\36\3\2\2"+
		"\2\22\2\"$)+<BHPSZaimqw\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}