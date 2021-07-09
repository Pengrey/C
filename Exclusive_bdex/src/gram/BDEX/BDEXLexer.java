// Generated from BDEX.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BDEXLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Create=21, Delete=22, Update=23, Line=24, 
		Add=25, Alter=26, Where=27, Get=28, Input=29, Read=30, Save=31, Join=32, 
		On=33, Col=34, String=35, Bool=36, Int=37, Real=38, Table=39, Template=40, 
		Func=41, Print=42, For=43, True=44, False=45, WORD=46, STRING=47, NUM=48, 
		REAL=49, NEWLINE=50, WS=51, LINE_COMMENT=52, COMMENT=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "Create", "Delete", "Update", "Line", "Add", 
			"Alter", "Where", "Get", "Input", "Read", "Save", "Join", "On", "Col", 
			"String", "Bool", "Int", "Real", "Table", "Template", "Func", "Print", 
			"For", "True", "False", "WORD", "STRING", "NUM", "REAL", "NEWLINE", "WS", 
			"LINE_COMMENT", "COMMENT", "LETTER", "DIGIT", "ESC"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'['", "','", "']'", "'='", "':'", "'.'", "'<'", 
			"'>'", "'{'", "'}'", "'=='", "'!='", "'<='", "'+'", "'-'", "'/'", "'*'", 
			"'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Create", "Delete", 
			"Update", "Line", "Add", "Alter", "Where", "Get", "Input", "Read", "Save", 
			"Join", "On", "Col", "String", "Bool", "Int", "Real", "Table", "Template", 
			"Func", "Print", "For", "True", "False", "WORD", "STRING", "NUM", "REAL", 
			"NEWLINE", "WS", "LINE_COMMENT", "COMMENT"
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


	public BDEXLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BDEX.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0178\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3."+
		"\3.\3/\3/\3/\7/\u012a\n/\f/\16/\u012d\13/\3\60\3\60\3\60\7\60\u0132\n"+
		"\60\f\60\16\60\u0135\13\60\3\60\3\60\3\61\5\61\u013a\n\61\3\61\6\61\u013d"+
		"\n\61\r\61\16\61\u013e\3\62\3\62\3\62\6\62\u0144\n\62\r\62\16\62\u0145"+
		"\5\62\u0148\n\62\3\63\5\63\u014b\n\63\3\63\3\63\3\64\6\64\u0150\n\64\r"+
		"\64\16\64\u0151\3\64\3\64\3\65\3\65\7\65\u0158\n\65\f\65\16\65\u015b\13"+
		"\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u0165\n\66\f\66\16\66"+
		"\u0168\13\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\38\38\39\39\39\39\59\u0177"+
		"\n9\5\u0133\u0159\u0166\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a"+
		"\62c\63e\64g\65i\66k\67m\2o\2q\2\3\2\31\4\2EEee\4\2TTtt\4\2GGgg\4\2CC"+
		"cc\4\2VVvv\4\2FFff\4\2NNnn\4\2WWww\4\2RRrr\4\2KKkk\4\2PPpp\4\2YYyy\4\2"+
		"JJjj\4\2IIii\4\2UUuu\4\2XXxx\4\2LLll\4\2QQqq\4\2DDdd\4\2OOoo\4\2HHhh\4"+
		"\2\13\13\"\"\5\2C\\aac|\2\u0181\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\3s\3\2\2\2\5u\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13"+
		"{\3\2\2\2\r}\3\2\2\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2"+
		"\25\u0085\3\2\2\2\27\u0087\3\2\2\2\31\u0089\3\2\2\2\33\u008b\3\2\2\2\35"+
		"\u008e\3\2\2\2\37\u0091\3\2\2\2!\u0094\3\2\2\2#\u0096\3\2\2\2%\u0098\3"+
		"\2\2\2\'\u009a\3\2\2\2)\u009c\3\2\2\2+\u009e\3\2\2\2-\u00a5\3\2\2\2/\u00ac"+
		"\3\2\2\2\61\u00b3\3\2\2\2\63\u00b8\3\2\2\2\65\u00bc\3\2\2\2\67\u00c2\3"+
		"\2\2\29\u00c8\3\2\2\2;\u00cc\3\2\2\2=\u00d2\3\2\2\2?\u00d7\3\2\2\2A\u00dc"+
		"\3\2\2\2C\u00e1\3\2\2\2E\u00e4\3\2\2\2G\u00e8\3\2\2\2I\u00ef\3\2\2\2K"+
		"\u00f4\3\2\2\2M\u00f8\3\2\2\2O\u00fd\3\2\2\2Q\u0103\3\2\2\2S\u010c\3\2"+
		"\2\2U\u0111\3\2\2\2W\u0117\3\2\2\2Y\u011b\3\2\2\2[\u0120\3\2\2\2]\u0126"+
		"\3\2\2\2_\u012e\3\2\2\2a\u0139\3\2\2\2c\u0140\3\2\2\2e\u014a\3\2\2\2g"+
		"\u014f\3\2\2\2i\u0155\3\2\2\2k\u0160\3\2\2\2m\u016e\3\2\2\2o\u0170\3\2"+
		"\2\2q\u0176\3\2\2\2st\7*\2\2t\4\3\2\2\2uv\7+\2\2v\6\3\2\2\2wx\7]\2\2x"+
		"\b\3\2\2\2yz\7.\2\2z\n\3\2\2\2{|\7_\2\2|\f\3\2\2\2}~\7?\2\2~\16\3\2\2"+
		"\2\177\u0080\7<\2\2\u0080\20\3\2\2\2\u0081\u0082\7\60\2\2\u0082\22\3\2"+
		"\2\2\u0083\u0084\7>\2\2\u0084\24\3\2\2\2\u0085\u0086\7@\2\2\u0086\26\3"+
		"\2\2\2\u0087\u0088\7}\2\2\u0088\30\3\2\2\2\u0089\u008a\7\177\2\2\u008a"+
		"\32\3\2\2\2\u008b\u008c\7?\2\2\u008c\u008d\7?\2\2\u008d\34\3\2\2\2\u008e"+
		"\u008f\7#\2\2\u008f\u0090\7?\2\2\u0090\36\3\2\2\2\u0091\u0092\7>\2\2\u0092"+
		"\u0093\7?\2\2\u0093 \3\2\2\2\u0094\u0095\7-\2\2\u0095\"\3\2\2\2\u0096"+
		"\u0097\7/\2\2\u0097$\3\2\2\2\u0098\u0099\7\61\2\2\u0099&\3\2\2\2\u009a"+
		"\u009b\7,\2\2\u009b(\3\2\2\2\u009c\u009d\7\'\2\2\u009d*\3\2\2\2\u009e"+
		"\u009f\t\2\2\2\u009f\u00a0\t\3\2\2\u00a0\u00a1\t\4\2\2\u00a1\u00a2\t\5"+
		"\2\2\u00a2\u00a3\t\6\2\2\u00a3\u00a4\t\4\2\2\u00a4,\3\2\2\2\u00a5\u00a6"+
		"\t\7\2\2\u00a6\u00a7\t\4\2\2\u00a7\u00a8\t\b\2\2\u00a8\u00a9\t\4\2\2\u00a9"+
		"\u00aa\t\6\2\2\u00aa\u00ab\t\4\2\2\u00ab.\3\2\2\2\u00ac\u00ad\t\t\2\2"+
		"\u00ad\u00ae\t\n\2\2\u00ae\u00af\t\7\2\2\u00af\u00b0\t\5\2\2\u00b0\u00b1"+
		"\t\6\2\2\u00b1\u00b2\t\4\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\t\b\2\2\u00b4"+
		"\u00b5\t\13\2\2\u00b5\u00b6\t\f\2\2\u00b6\u00b7\t\4\2\2\u00b7\62\3\2\2"+
		"\2\u00b8\u00b9\t\5\2\2\u00b9\u00ba\t\7\2\2\u00ba\u00bb\t\7\2\2\u00bb\64"+
		"\3\2\2\2\u00bc\u00bd\t\5\2\2\u00bd\u00be\t\b\2\2\u00be\u00bf\t\6\2\2\u00bf"+
		"\u00c0\t\4\2\2\u00c0\u00c1\t\3\2\2\u00c1\66\3\2\2\2\u00c2\u00c3\t\r\2"+
		"\2\u00c3\u00c4\t\16\2\2\u00c4\u00c5\t\4\2\2\u00c5\u00c6\t\3\2\2\u00c6"+
		"\u00c7\t\4\2\2\u00c78\3\2\2\2\u00c8\u00c9\t\17\2\2\u00c9\u00ca\t\4\2\2"+
		"\u00ca\u00cb\t\6\2\2\u00cb:\3\2\2\2\u00cc\u00cd\t\13\2\2\u00cd\u00ce\t"+
		"\f\2\2\u00ce\u00cf\t\n\2\2\u00cf\u00d0\t\t\2\2\u00d0\u00d1\t\6\2\2\u00d1"+
		"<\3\2\2\2\u00d2\u00d3\t\3\2\2\u00d3\u00d4\t\4\2\2\u00d4\u00d5\t\5\2\2"+
		"\u00d5\u00d6\t\7\2\2\u00d6>\3\2\2\2\u00d7\u00d8\t\20\2\2\u00d8\u00d9\t"+
		"\5\2\2\u00d9\u00da\t\21\2\2\u00da\u00db\t\4\2\2\u00db@\3\2\2\2\u00dc\u00dd"+
		"\t\22\2\2\u00dd\u00de\t\23\2\2\u00de\u00df\t\13\2\2\u00df\u00e0\t\f\2"+
		"\2\u00e0B\3\2\2\2\u00e1\u00e2\t\23\2\2\u00e2\u00e3\t\f\2\2\u00e3D\3\2"+
		"\2\2\u00e4\u00e5\t\2\2\2\u00e5\u00e6\t\23\2\2\u00e6\u00e7\t\b\2\2\u00e7"+
		"F\3\2\2\2\u00e8\u00e9\t\20\2\2\u00e9\u00ea\t\6\2\2\u00ea\u00eb\t\3\2\2"+
		"\u00eb\u00ec\t\13\2\2\u00ec\u00ed\t\f\2\2\u00ed\u00ee\t\17\2\2\u00eeH"+
		"\3\2\2\2\u00ef\u00f0\t\24\2\2\u00f0\u00f1\t\23\2\2\u00f1\u00f2\t\23\2"+
		"\2\u00f2\u00f3\t\b\2\2\u00f3J\3\2\2\2\u00f4\u00f5\t\13\2\2\u00f5\u00f6"+
		"\t\f\2\2\u00f6\u00f7\t\6\2\2\u00f7L\3\2\2\2\u00f8\u00f9\t\3\2\2\u00f9"+
		"\u00fa\t\4\2\2\u00fa\u00fb\t\5\2\2\u00fb\u00fc\t\b\2\2\u00fcN\3\2\2\2"+
		"\u00fd\u00fe\t\6\2\2\u00fe\u00ff\t\5\2\2\u00ff\u0100\t\24\2\2\u0100\u0101"+
		"\t\b\2\2\u0101\u0102\t\4\2\2\u0102P\3\2\2\2\u0103\u0104\t\6\2\2\u0104"+
		"\u0105\t\4\2\2\u0105\u0106\t\25\2\2\u0106\u0107\t\n\2\2\u0107\u0108\t"+
		"\b\2\2\u0108\u0109\t\5\2\2\u0109\u010a\t\6\2\2\u010a\u010b\t\4\2\2\u010b"+
		"R\3\2\2\2\u010c\u010d\t\26\2\2\u010d\u010e\t\t\2\2\u010e\u010f\t\f\2\2"+
		"\u010f\u0110\t\2\2\2\u0110T\3\2\2\2\u0111\u0112\t\n\2\2\u0112\u0113\t"+
		"\3\2\2\u0113\u0114\t\13\2\2\u0114\u0115\t\f\2\2\u0115\u0116\t\6\2\2\u0116"+
		"V\3\2\2\2\u0117\u0118\t\26\2\2\u0118\u0119\t\23\2\2\u0119\u011a\t\3\2"+
		"\2\u011aX\3\2\2\2\u011b\u011c\t\6\2\2\u011c\u011d\t\3\2\2\u011d\u011e"+
		"\t\t\2\2\u011e\u011f\t\4\2\2\u011fZ\3\2\2\2\u0120\u0121\t\26\2\2\u0121"+
		"\u0122\t\5\2\2\u0122\u0123\t\b\2\2\u0123\u0124\t\20\2\2\u0124\u0125\t"+
		"\4\2\2\u0125\\\3\2\2\2\u0126\u012b\5m\67\2\u0127\u012a\5m\67\2\u0128\u012a"+
		"\5o8\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c^\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012e\u0133\7$\2\2\u012f\u0132\5q9\2\u0130\u0132\13\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7$"+
		"\2\2\u0137`\3\2\2\2\u0138\u013a\7/\2\2\u0139\u0138\3\2\2\2\u0139\u013a"+
		"\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u013d\5o8\2\u013c\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013fb\3\2\2\2"+
		"\u0140\u0147\5a\61\2\u0141\u0143\7\60\2\2\u0142\u0144\5o8\2\u0143\u0142"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"\u0148\3\2\2\2\u0147\u0141\3\2\2\2\u0147\u0148\3\2\2\2\u0148d\3\2\2\2"+
		"\u0149\u014b\7\17\2\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c"+
		"\3\2\2\2\u014c\u014d\7\f\2\2\u014df\3\2\2\2\u014e\u0150\t\27\2\2\u014f"+
		"\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b\64\2\2\u0154h\3\2\2\2\u0155\u0159"+
		"\7%\2\2\u0156\u0158\13\2\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2"+
		"\2\2\u015c\u015d\5e\63\2\u015d\u015e\3\2\2\2\u015e\u015f\b\65\2\2\u015f"+
		"j\3\2\2\2\u0160\u0161\7\61\2\2\u0161\u0162\7,\2\2\u0162\u0166\3\2\2\2"+
		"\u0163\u0165\13\2\2\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0167"+
		"\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"\u016a\7,\2\2\u016a\u016b\7\61\2\2\u016b\u016c\3\2\2\2\u016c\u016d\b\66"+
		"\2\2\u016dl\3\2\2\2\u016e\u016f\t\30\2\2\u016fn\3\2\2\2\u0170\u0171\4"+
		"\62;\2\u0171p\3\2\2\2\u0172\u0173\7^\2\2\u0173\u0177\7$\2\2\u0174\u0175"+
		"\7^\2\2\u0175\u0177\7^\2\2\u0176\u0172\3\2\2\2\u0176\u0174\3\2\2\2\u0177"+
		"r\3\2\2\2\20\2\u0129\u012b\u0131\u0133\u0139\u013e\u0145\u0147\u014a\u0151"+
		"\u0159\u0166\u0176\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}