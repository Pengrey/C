// Generated from BDEX.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BDEXParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_line = 2, RULE_expr = 3, RULE_var = 4, 
		RULE_noRetFunc = 5, RULE_func = 6, RULE_forloop = 7, RULE_bool = 8, RULE_type = 9, 
		RULE_opBool = 10, RULE_opArit = 11, RULE_op = 12, RULE_define = 13, RULE_val = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "line", "expr", "var", "noRetFunc", "func", "forloop", 
			"bool", "type", "opBool", "opArit", "op", "define", "val"
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

	@Override
	public String getGrammarFileName() { return "BDEX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BDEXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BDEXParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Delete) | (1L << Line) | (1L << Add) | (1L << Alter) | (1L << Col) | (1L << String) | (1L << Bool) | (1L << Int) | (1L << Real) | (1L << Table) | (1L << Template) | (1L << Print) | (1L << For) | (1L << WORD) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(30);
				stat();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(BDEXParser.NEWLINE, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Delete) | (1L << Line) | (1L << Add) | (1L << Alter) | (1L << Col) | (1L << String) | (1L << Bool) | (1L << Int) | (1L << Real) | (1L << Table) | (1L << Template) | (1L << Print) | (1L << For) | (1L << WORD))) != 0)) {
				{
				setState(38);
				line();
				}
			}

			setState(41);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
	 
		public LineContext() { }
		public void copyFrom(LineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrognoRetFuncContext extends LineContext {
		public NoRetFuncContext noRetFunc() {
			return getRuleContext(NoRetFuncContext.class,0);
		}
		public PrognoRetFuncContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterPrognoRetFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitPrognoRetFunc(this);
		}
	}
	public static class ProgVarContext extends LineContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ProgVarContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterProgVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitProgVar(this);
		}
	}
	public static class ProgDefContext extends LineContext {
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public ProgDefContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterProgDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitProgDef(this);
		}
	}
	public static class StatLoopContext extends LineContext {
		public ForloopContext forloop() {
			return getRuleContext(ForloopContext.class,0);
		}
		public StatLoopContext(LineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterStatLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitStatLoop(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Line:
			case Col:
			case String:
			case Bool:
			case Int:
			case Real:
			case Table:
			case Template:
				_localctx = new ProgVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				var();
				}
				break;
			case WORD:
				_localctx = new ProgDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				define();
				}
				break;
			case Delete:
			case Add:
			case Alter:
			case Print:
				_localctx = new PrognoRetFuncContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				noRetFunc();
				}
				break;
			case For:
				_localctx = new StatLoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				forloop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprLineContext extends ExprContext {
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public ExprLineContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprLine(this);
		}
	}
	public static class ExprCreateContext extends ExprContext {
		public TerminalNode Create() { return getToken(BDEXParser.Create, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public ExprCreateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprCreate(this);
		}
	}
	public static class ExprPrintContext extends ExprContext {
		public TerminalNode Input() { return getToken(BDEXParser.Input, 0); }
		public TerminalNode STRING() { return getToken(BDEXParser.STRING, 0); }
		public ExprPrintContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprPrint(this);
		}
	}
	public static class ExprJoinContext extends ExprContext {
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Join() { return getToken(BDEXParser.Join, 0); }
		public ExprJoinContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprJoin(this);
		}
	}
	public static class ExprReadContext extends ExprContext {
		public TerminalNode Read() { return getToken(BDEXParser.Read, 0); }
		public TerminalNode STRING() { return getToken(BDEXParser.STRING, 0); }
		public ExprReadContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprRead(this);
		}
	}
	public static class ExprJoinOnContext extends ExprContext {
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Join() { return getToken(BDEXParser.Join, 0); }
		public TerminalNode On() { return getToken(BDEXParser.On, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public ExprJoinOnContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprJoinOn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprJoinOn(this);
		}
	}
	public static class ExprValContext extends ExprContext {
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public ExprValContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprVal(this);
		}
	}
	public static class ExprWhereContext extends ExprContext {
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public TerminalNode Where() { return getToken(BDEXParser.Where, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public ExprWhereContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprWhere(this);
		}
	}
	public static class ExprGetContext extends ExprContext {
		public TerminalNode Get() { return getToken(BDEXParser.Get, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Where() { return getToken(BDEXParser.Where, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public ExprGetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprGet(this);
		}
	}
	public static class ExprSaveContext extends ExprContext {
		public TerminalNode Save() { return getToken(BDEXParser.Save, 0); }
		public TerminalNode STRING() { return getToken(BDEXParser.STRING, 0); }
		public ExprSaveContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprSave(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprSave(this);
		}
	}
	public static class ExprGetLineContext extends ExprContext {
		public TerminalNode Get() { return getToken(BDEXParser.Get, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public TerminalNode Where() { return getToken(BDEXParser.Where, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public ExprGetLineContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprGetLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprGetLine(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			int _alt;
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new ExprCreateContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(Create);
				setState(50);
				match(WORD);
				}
				break;
			case 2:
				_localctx = new ExprGetLineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(Get);
				setState(52);
				match(WORD);
				setState(53);
				match(Line);
				setState(54);
				match(WORD);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Where) {
					{
					setState(55);
					match(Where);
					setState(56);
					opBool();
					}
				}

				}
				break;
			case 3:
				_localctx = new ExprGetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				match(Get);
				setState(60);
				match(WORD);
				setState(61);
				match(WORD);
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Where) {
					{
					setState(62);
					match(Where);
					setState(63);
					opBool();
					}
				}

				}
				break;
			case 4:
				_localctx = new ExprPrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(Input);
				setState(67);
				match(T__0);
				setState(68);
				match(STRING);
				setState(69);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new ExprReadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				match(Read);
				setState(71);
				match(T__0);
				setState(72);
				match(STRING);
				setState(73);
				match(T__1);
				}
				break;
			case 6:
				_localctx = new ExprSaveContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				match(Save);
				setState(75);
				match(T__0);
				setState(76);
				match(STRING);
				setState(77);
				match(T__1);
				}
				break;
			case 7:
				_localctx = new ExprJoinOnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				match(WORD);
				setState(79);
				match(Join);
				setState(80);
				match(WORD);
				setState(81);
				match(On);
				setState(82);
				opBool();
				}
				break;
			case 8:
				_localctx = new ExprJoinContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(83);
				match(WORD);
				setState(84);
				match(Join);
				setState(85);
				match(WORD);
				}
				break;
			case 9:
				_localctx = new ExprWhereContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(86);
				match(WORD);
				setState(87);
				match(Where);
				setState(88);
				opBool();
				}
				break;
			case 10:
				_localctx = new ExprLineContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(89);
				match(T__2);
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(90);
						val();
						setState(91);
						match(T__3);
						}
						} 
					}
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(98);
				val();
				setState(99);
				match(T__4);
				}
				break;
			case 11:
				_localctx = new ExprValContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(101);
				val();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	 
		public VarContext() { }
		public void copyFrom(VarContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarLineContext extends VarContext {
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarLineContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarLine(this);
		}
	}
	public static class VarRealContext extends VarContext {
		public TerminalNode Real() { return getToken(BDEXParser.Real, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarRealContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarReal(this);
		}
	}
	public static class VarBoolContext extends VarContext {
		public TerminalNode Bool() { return getToken(BDEXParser.Bool, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarBoolContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarBool(this);
		}
	}
	public static class VarTableContext extends VarContext {
		public TerminalNode Table() { return getToken(BDEXParser.Table, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarTableContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarTable(this);
		}
	}
	public static class VarStrContext extends VarContext {
		public TerminalNode String() { return getToken(BDEXParser.String, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarStrContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarStr(this);
		}
	}
	public static class VarTableCatContext extends VarContext {
		public TerminalNode Template() { return getToken(BDEXParser.Template, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Where() { return getTokens(BDEXParser.Where); }
		public TerminalNode Where(int i) {
			return getToken(BDEXParser.Where, i);
		}
		public List<OpBoolContext> opBool() {
			return getRuleContexts(OpBoolContext.class);
		}
		public OpBoolContext opBool(int i) {
			return getRuleContext(OpBoolContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarTableCatContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarTableCat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarTableCat(this);
		}
	}
	public static class VarColContext extends VarContext {
		public TerminalNode Col() { return getToken(BDEXParser.Col, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarColContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarCol(this);
		}
	}
	public static class VarIntContext extends VarContext {
		public TerminalNode Int() { return getToken(BDEXParser.Int, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public VarIntContext(VarContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterVarInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitVarInt(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case String:
				_localctx = new VarStrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(String);
				setState(105);
				match(WORD);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(106);
					match(T__5);
					setState(108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(107);
						expr();
						}
						}
						setState(110); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Bool:
				_localctx = new VarBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(Bool);
				setState(115);
				match(WORD);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(116);
					match(T__5);
					setState(118); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(117);
						expr();
						}
						}
						setState(120); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Int:
				_localctx = new VarIntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(Int);
				setState(125);
				match(WORD);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(126);
					match(T__5);
					setState(128); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(127);
						expr();
						}
						}
						setState(130); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Real:
				_localctx = new VarRealContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(Real);
				setState(135);
				match(WORD);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(136);
					match(T__5);
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(137);
						expr();
						}
						}
						setState(140); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Line:
				_localctx = new VarLineContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(Line);
				setState(145);
				match(WORD);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(146);
					match(T__5);
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(147);
						expr();
						}
						}
						setState(150); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Table:
				_localctx = new VarTableContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(Table);
				setState(155);
				match(WORD);
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(156);
					match(T__5);
					setState(158); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(157);
						expr();
						}
						}
						setState(160); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Template:
				_localctx = new VarTableCatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(164);
				match(Template);
				setState(165);
				match(WORD);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					match(T__2);
					setState(167);
					match(WORD);
					setState(168);
					match(T__6);
					setState(175);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Line:
					case String:
					case Bool:
					case Int:
					case Real:
					case Table:
					case Func:
						{
						setState(169);
						type();
						}
						break;
					case WORD:
						{
						setState(170);
						match(WORD);
						setState(171);
						match(T__7);
						setState(172);
						match(WORD);
						setState(173);
						match(Where);
						setState(174);
						opBool();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(177);
					match(T__4);
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(183);
					match(T__5);
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(184);
						expr();
						}
						}
						setState(187); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			case Col:
				_localctx = new VarColContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(191);
				match(Col);
				setState(192);
				type();
				setState(193);
				match(WORD);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(194);
					match(T__5);
					setState(196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(195);
						expr();
						}
						}
						setState(198); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << Create) | (1L << Get) | (1L << Input) | (1L << Read) | (1L << Save) | (1L << Func) | (1L << True) | (1L << False) | (1L << WORD) | (1L << STRING) | (1L << NUM) | (1L << REAL))) != 0) );
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NoRetFuncContext extends ParserRuleContext {
		public NoRetFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noRetFunc; }
	 
		public NoRetFuncContext() { }
		public void copyFrom(NoRetFuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NoRetAddLineCostumContext extends NoRetFuncContext {
		public TerminalNode Add() { return getToken(BDEXParser.Add, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public NoRetAddLineCostumContext(NoRetFuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterNoRetAddLineCostum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitNoRetAddLineCostum(this);
		}
	}
	public static class NoRetPrintContext extends NoRetFuncContext {
		public TerminalNode Print() { return getToken(BDEXParser.Print, 0); }
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public NoRetPrintContext(NoRetFuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterNoRetPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitNoRetPrint(this);
		}
	}
	public static class NoRetAddColContext extends NoRetFuncContext {
		public TerminalNode Add() { return getToken(BDEXParser.Add, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Col() { return getToken(BDEXParser.Col, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public NoRetAddColContext(NoRetFuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterNoRetAddCol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitNoRetAddCol(this);
		}
	}
	public static class NoRetDelContext extends NoRetFuncContext {
		public TerminalNode Delete() { return getToken(BDEXParser.Delete, 0); }
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public TerminalNode Where() { return getToken(BDEXParser.Where, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public NoRetDelContext(NoRetFuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterNoRetDel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitNoRetDel(this);
		}
	}
	public static class NoRetAlterContext extends NoRetFuncContext {
		public TerminalNode Alter() { return getToken(BDEXParser.Alter, 0); }
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public TerminalNode Where() { return getToken(BDEXParser.Where, 0); }
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public NoRetAlterContext(NoRetFuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterNoRetAlter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitNoRetAlter(this);
		}
	}

	public final NoRetFuncContext noRetFunc() throws RecognitionException {
		NoRetFuncContext _localctx = new NoRetFuncContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_noRetFunc);
		int _la;
		try {
			int _alt;
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new NoRetPrintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(Print);
				setState(205);
				match(T__0);
				setState(206);
				val();
				setState(207);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new NoRetDelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(Delete);
				setState(210);
				match(WORD);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Line) {
					{
					setState(211);
					match(Line);
					setState(212);
					match(Where);
					setState(213);
					opBool();
					}
				}

				}
				break;
			case 3:
				_localctx = new NoRetAddLineCostumContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(Add);
				setState(217);
				match(WORD);
				setState(218);
				match(Line);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(219);
					match(T__8);
					setState(224);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(220);
							match(WORD);
							setState(221);
							match(T__3);
							}
							} 
						}
						setState(226);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
					}
					setState(227);
					match(WORD);
					setState(228);
					match(T__9);
					}
				}

				setState(231);
				match(T__0);
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(232);
						val();
						setState(233);
						match(T__3);
						}
						} 
					}
					setState(239);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(240);
				val();
				setState(241);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new NoRetAddColContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				match(Add);
				setState(244);
				match(WORD);
				setState(245);
				match(Col);
				setState(246);
				match(T__8);
				setState(247);
				match(WORD);
				setState(248);
				match(T__9);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(249);
					match(T__0);
					setState(255);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(250);
							val();
							setState(251);
							match(T__3);
							}
							} 
						}
						setState(257);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
					}
					setState(258);
					val();
					setState(259);
					match(T__1);
					}
				}

				}
				break;
			case 5:
				_localctx = new NoRetAlterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				match(Alter);
				setState(264);
				match(WORD);
				setState(265);
				match(Line);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(266);
					match(T__8);
					setState(271);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(267);
							match(WORD);
							setState(268);
							match(T__3);
							}
							} 
						}
						setState(273);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					}
					setState(274);
					match(WORD);
					setState(275);
					match(T__9);
					}
				}

				setState(278);
				match(T__0);
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(279);
						val();
						setState(280);
						match(T__3);
						}
						} 
					}
					setState(286);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				setState(287);
				val();
				setState(288);
				match(T__1);
				setState(289);
				match(Where);
				setState(290);
				opBool();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode Func() { return getToken(BDEXParser.Func, 0); }
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitFunc(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(Func);
			setState(296); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(295);
					op();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(298); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForloopContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(BDEXParser.For, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ForloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forloop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterForloop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitForloop(this);
		}
	}

	public final ForloopContext forloop() throws RecognitionException {
		ForloopContext _localctx = new ForloopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forloop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(For);
			setState(301);
			match(T__0);
			setState(302);
			type();
			setState(303);
			match(WORD);
			setState(304);
			match(T__1);
			setState(305);
			match(WORD);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(306);
				match(T__7);
				setState(307);
				match(WORD);
				}
			}

			setState(310);
			match(T__10);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Delete) | (1L << Line) | (1L << Add) | (1L << Alter) | (1L << Col) | (1L << String) | (1L << Bool) | (1L << Int) | (1L << Real) | (1L << Table) | (1L << Template) | (1L << Print) | (1L << For) | (1L << WORD) | (1L << NEWLINE))) != 0)) {
				{
				{
				setState(311);
				stat();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolTrueContext extends BoolContext {
		public TerminalNode True() { return getToken(BDEXParser.True, 0); }
		public BoolTrueContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterBoolTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitBoolTrue(this);
		}
	}
	public static class BoolFalseContext extends BoolContext {
		public TerminalNode False() { return getToken(BDEXParser.False, 0); }
		public BoolFalseContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterBoolFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitBoolFalse(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bool);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case True:
				_localctx = new BoolTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				match(True);
				}
				break;
			case False:
				_localctx = new BoolFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				match(False);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(BDEXParser.String, 0); }
		public TerminalNode Bool() { return getToken(BDEXParser.Bool, 0); }
		public TerminalNode Int() { return getToken(BDEXParser.Int, 0); }
		public TerminalNode Real() { return getToken(BDEXParser.Real, 0); }
		public TerminalNode Line() { return getToken(BDEXParser.Line, 0); }
		public TerminalNode Table() { return getToken(BDEXParser.Table, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		try {
			setState(330);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				match(String);
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(Bool);
				}
				break;
			case Int:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				match(Int);
				}
				break;
			case Real:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				match(Real);
				}
				break;
			case Line:
				enterOuterAlt(_localctx, 5);
				{
				setState(327);
				match(Line);
				}
				break;
			case Table:
				enterOuterAlt(_localctx, 6);
				{
				setState(328);
				match(Table);
				}
				break;
			case Func:
				enterOuterAlt(_localctx, 7);
				{
				setState(329);
				func();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpBoolContext extends ParserRuleContext {
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public OpBoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opBool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterOpBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitOpBool(this);
		}
	}

	public final OpBoolContext opBool() throws RecognitionException {
		OpBoolContext _localctx = new OpBoolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_opBool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			val();
			setState(333);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(334);
			val();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpAritContext extends ParserRuleContext {
		public List<ValContext> val() {
			return getRuleContexts(ValContext.class);
		}
		public ValContext val(int i) {
			return getRuleContext(ValContext.class,i);
		}
		public OpAritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opArit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterOpArit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitOpArit(this);
		}
	}

	public final OpAritContext opArit() throws RecognitionException {
		OpAritContext _localctx = new OpAritContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_opArit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			val();
			setState(337);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(338);
			val();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
	 
		public OpContext() { }
		public void copyFrom(OpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpAritmeticaContext extends OpContext {
		public OpAritContext opArit() {
			return getRuleContext(OpAritContext.class,0);
		}
		public OpAritmeticaContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterOpAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitOpAritmetica(this);
		}
	}
	public static class OpBooleanContext extends OpContext {
		public OpBoolContext opBool() {
			return getRuleContext(OpBoolContext.class,0);
		}
		public OpBooleanContext(OpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterOpBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitOpBoolean(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_op);
		try {
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new OpBooleanContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				opBool();
				}
				break;
			case 2:
				_localctx = new OpAritmeticaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				opArit();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitDefine(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(WORD);
			setState(345);
			match(T__5);
			setState(346);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValContext extends ParserRuleContext {
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
	 
		public ValContext() { }
		public void copyFrom(ValContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValNumContext extends ValContext {
		public TerminalNode NUM() { return getToken(BDEXParser.NUM, 0); }
		public ValNumContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValNum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValNum(this);
		}
	}
	public static class ValRealContext extends ValContext {
		public TerminalNode REAL() { return getToken(BDEXParser.REAL, 0); }
		public ValRealContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValReal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValReal(this);
		}
	}
	public static class ValTableColumnContext extends ValContext {
		public List<TerminalNode> WORD() { return getTokens(BDEXParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(BDEXParser.WORD, i);
		}
		public ValTableColumnContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValTableColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValTableColumn(this);
		}
	}
	public static class ValWordContext extends ValContext {
		public TerminalNode WORD() { return getToken(BDEXParser.WORD, 0); }
		public ValWordContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValWord(this);
		}
	}
	public static class ValBoolContext extends ValContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ValBoolContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValBool(this);
		}
	}
	public static class ValFuncContext extends ValContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public ValFuncContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterValFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitValFunc(this);
		}
	}
	public static class ExprWordContext extends ValContext {
		public TerminalNode STRING() { return getToken(BDEXParser.STRING, 0); }
		public ExprWordContext(ValContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).enterExprWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BDEXListener ) ((BDEXListener)listener).exitExprWord(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_val);
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new ValNumContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(NUM);
				}
				break;
			case 2:
				_localctx = new ValRealContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(REAL);
				}
				break;
			case 3:
				_localctx = new ValWordContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(WORD);
				}
				break;
			case 4:
				_localctx = new ValTableColumnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				match(WORD);
				setState(352);
				match(T__7);
				setState(353);
				match(WORD);
				}
				break;
			case 5:
				_localctx = new ExprWordContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(354);
				match(STRING);
				}
				break;
			case 6:
				_localctx = new ValBoolContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(355);
				bool();
				}
				break;
			case 7:
				_localctx = new ValFuncContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(356);
				func();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u016a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2"+
		"\16\2%\13\2\3\2\3\2\3\3\5\3*\n\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4\62\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5<\n\5\3\5\3\5\3\5\3\5\3\5\5\5C\n\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5`\n\5\f\5\16\5c\13\5\3\5\3\5\3"+
		"\5\3\5\5\5i\n\5\3\6\3\6\3\6\3\6\6\6o\n\6\r\6\16\6p\5\6s\n\6\3\6\3\6\3"+
		"\6\3\6\6\6y\n\6\r\6\16\6z\5\6}\n\6\3\6\3\6\3\6\3\6\6\6\u0083\n\6\r\6\16"+
		"\6\u0084\5\6\u0087\n\6\3\6\3\6\3\6\3\6\6\6\u008d\n\6\r\6\16\6\u008e\5"+
		"\6\u0091\n\6\3\6\3\6\3\6\3\6\6\6\u0097\n\6\r\6\16\6\u0098\5\6\u009b\n"+
		"\6\3\6\3\6\3\6\3\6\6\6\u00a1\n\6\r\6\16\6\u00a2\5\6\u00a5\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b2\n\6\3\6\3\6\6\6\u00b6\n"+
		"\6\r\6\16\6\u00b7\3\6\3\6\6\6\u00bc\n\6\r\6\16\6\u00bd\5\6\u00c0\n\6\3"+
		"\6\3\6\3\6\3\6\3\6\6\6\u00c7\n\6\r\6\16\6\u00c8\5\6\u00cb\n\6\5\6\u00cd"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d9\n\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00e1\n\7\f\7\16\7\u00e4\13\7\3\7\3\7\5\7\u00e8\n\7\3"+
		"\7\3\7\3\7\3\7\7\7\u00ee\n\7\f\7\16\7\u00f1\13\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0100\n\7\f\7\16\7\u0103\13\7\3\7\3"+
		"\7\3\7\5\7\u0108\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0110\n\7\f\7\16\7\u0113"+
		"\13\7\3\7\3\7\5\7\u0117\n\7\3\7\3\7\3\7\3\7\7\7\u011d\n\7\f\7\16\7\u0120"+
		"\13\7\3\7\3\7\3\7\3\7\3\7\5\7\u0127\n\7\3\b\3\b\6\b\u012b\n\b\r\b\16\b"+
		"\u012c\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0137\n\t\3\t\3\t\7\t\u013b"+
		"\n\t\f\t\16\t\u013e\13\t\3\t\3\t\3\n\3\n\5\n\u0144\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u014d\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\5\16\u0159\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0168\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36\2\4\4\2\13\f\17\21\3\2\22\26\2\u01a3\2#\3\2\2\2\4)"+
		"\3\2\2\2\6\61\3\2\2\2\bh\3\2\2\2\n\u00cc\3\2\2\2\f\u0126\3\2\2\2\16\u0128"+
		"\3\2\2\2\20\u012e\3\2\2\2\22\u0143\3\2\2\2\24\u014c\3\2\2\2\26\u014e\3"+
		"\2\2\2\30\u0152\3\2\2\2\32\u0158\3\2\2\2\34\u015a\3\2\2\2\36\u0167\3\2"+
		"\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3"+
		"\2\2\2&\'\7\2\2\3\'\3\3\2\2\2(*\5\6\4\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2"+
		"+,\7\64\2\2,\5\3\2\2\2-\62\5\n\6\2.\62\5\34\17\2/\62\5\f\7\2\60\62\5\20"+
		"\t\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\7\3\2\2\2\63"+
		"\64\7\27\2\2\64i\7\60\2\2\65\66\7\36\2\2\66\67\7\60\2\2\678\7\32\2\28"+
		";\7\60\2\29:\7\35\2\2:<\5\26\f\2;9\3\2\2\2;<\3\2\2\2<i\3\2\2\2=>\7\36"+
		"\2\2>?\7\60\2\2?B\7\60\2\2@A\7\35\2\2AC\5\26\f\2B@\3\2\2\2BC\3\2\2\2C"+
		"i\3\2\2\2DE\7\37\2\2EF\7\3\2\2FG\7\61\2\2Gi\7\4\2\2HI\7 \2\2IJ\7\3\2\2"+
		"JK\7\61\2\2Ki\7\4\2\2LM\7!\2\2MN\7\3\2\2NO\7\61\2\2Oi\7\4\2\2PQ\7\60\2"+
		"\2QR\7\"\2\2RS\7\60\2\2ST\7#\2\2Ti\5\26\f\2UV\7\60\2\2VW\7\"\2\2Wi\7\60"+
		"\2\2XY\7\60\2\2YZ\7\35\2\2Zi\5\26\f\2[a\7\5\2\2\\]\5\36\20\2]^\7\6\2\2"+
		"^`\3\2\2\2_\\\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2"+
		"\2de\5\36\20\2ef\7\7\2\2fi\3\2\2\2gi\5\36\20\2h\63\3\2\2\2h\65\3\2\2\2"+
		"h=\3\2\2\2hD\3\2\2\2hH\3\2\2\2hL\3\2\2\2hP\3\2\2\2hU\3\2\2\2hX\3\2\2\2"+
		"h[\3\2\2\2hg\3\2\2\2i\t\3\2\2\2jk\7%\2\2kr\7\60\2\2ln\7\b\2\2mo\5\b\5"+
		"\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2\2\2rl\3\2\2\2rs\3\2\2"+
		"\2s\u00cd\3\2\2\2tu\7&\2\2u|\7\60\2\2vx\7\b\2\2wy\5\b\5\2xw\3\2\2\2yz"+
		"\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|v\3\2\2\2|}\3\2\2\2}\u00cd\3\2"+
		"\2\2~\177\7\'\2\2\177\u0086\7\60\2\2\u0080\u0082\7\b\2\2\u0081\u0083\5"+
		"\b\5\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0080\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u00cd\3\2\2\2\u0088\u0089\7(\2\2\u0089\u0090\7\60\2\2\u008a"+
		"\u008c\7\b\2\2\u008b\u008d\5\b\5\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008a\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u00cd\3\2\2\2\u0092\u0093\7\32"+
		"\2\2\u0093\u009a\7\60\2\2\u0094\u0096\7\b\2\2\u0095\u0097\5\b\5\2\u0096"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099\u009b\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u00cd\3\2\2\2\u009c\u009d\7)\2\2\u009d\u00a4\7\60\2\2\u009e\u00a0\7\b"+
		"\2\2\u009f\u00a1\5\b\5\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009e\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00cd\3\2\2\2\u00a6\u00a7\7*\2\2\u00a7"+
		"\u00b5\7\60\2\2\u00a8\u00a9\7\5\2\2\u00a9\u00aa\7\60\2\2\u00aa\u00b1\7"+
		"\t\2\2\u00ab\u00b2\5\24\13\2\u00ac\u00ad\7\60\2\2\u00ad\u00ae\7\n\2\2"+
		"\u00ae\u00af\7\60\2\2\u00af\u00b0\7\35\2\2\u00b0\u00b2\5\26\f\2\u00b1"+
		"\u00ab\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7\7"+
		"\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00bf\3\2\2\2\u00b9\u00bb\7\b"+
		"\2\2\u00ba\u00bc\5\b\5\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00b9\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00cd\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2"+
		"\u00c3\5\24\13\2\u00c3\u00ca\7\60\2\2\u00c4\u00c6\7\b\2\2\u00c5\u00c7"+
		"\5\b\5\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cb\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cd\3\2\2\2\u00ccj\3\2\2\2\u00cct\3\2\2\2\u00cc~\3\2\2\2"+
		"\u00cc\u0088\3\2\2\2\u00cc\u0092\3\2\2\2\u00cc\u009c\3\2\2\2\u00cc\u00a6"+
		"\3\2\2\2\u00cc\u00c1\3\2\2\2\u00cd\13\3\2\2\2\u00ce\u00cf\7,\2\2\u00cf"+
		"\u00d0\7\3\2\2\u00d0\u00d1\5\36\20\2\u00d1\u00d2\7\4\2\2\u00d2\u0127\3"+
		"\2\2\2\u00d3\u00d4\7\30\2\2\u00d4\u00d8\7\60\2\2\u00d5\u00d6\7\32\2\2"+
		"\u00d6\u00d7\7\35\2\2\u00d7\u00d9\5\26\f\2\u00d8\u00d5\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u0127\3\2\2\2\u00da\u00db\7\33\2\2\u00db\u00dc\7\60\2\2"+
		"\u00dc\u00e7\7\32\2\2\u00dd\u00e2\7\13\2\2\u00de\u00df\7\60\2\2\u00df"+
		"\u00e1\7\6\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5"+
		"\u00e6\7\60\2\2\u00e6\u00e8\7\f\2\2\u00e7\u00dd\3\2\2\2\u00e7\u00e8\3"+
		"\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ef\7\3\2\2\u00ea\u00eb\5\36\20\2\u00eb"+
		"\u00ec\7\6\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ee\u00f1\3\2"+
		"\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f2\u00f3\5\36\20\2\u00f3\u00f4\7\4\2\2\u00f4\u0127\3"+
		"\2\2\2\u00f5\u00f6\7\33\2\2\u00f6\u00f7\7\60\2\2\u00f7\u00f8\7$\2\2\u00f8"+
		"\u00f9\7\13\2\2\u00f9\u00fa\7\60\2\2\u00fa\u0107\7\f\2\2\u00fb\u0101\7"+
		"\3\2\2\u00fc\u00fd\5\36\20\2\u00fd\u00fe\7\6\2\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fc\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\5\36\20\2\u0105"+
		"\u0106\7\4\2\2\u0106\u0108\3\2\2\2\u0107\u00fb\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u0127\3\2\2\2\u0109\u010a\7\34\2\2\u010a\u010b\7\60\2\2\u010b"+
		"\u0116\7\32\2\2\u010c\u0111\7\13\2\2\u010d\u010e\7\60\2\2\u010e\u0110"+
		"\7\6\2\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0114\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0115\7\60"+
		"\2\2\u0115\u0117\7\f\2\2\u0116\u010c\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u011e\7\3\2\2\u0119\u011a\5\36\20\2\u011a\u011b\7"+
		"\6\2\2\u011b\u011d\3\2\2\2\u011c\u0119\3\2\2\2\u011d\u0120\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0121\u0122\5\36\20\2\u0122\u0123\7\4\2\2\u0123\u0124\7\35\2\2\u0124"+
		"\u0125\5\26\f\2\u0125\u0127\3\2\2\2\u0126\u00ce\3\2\2\2\u0126\u00d3\3"+
		"\2\2\2\u0126\u00da\3\2\2\2\u0126\u00f5\3\2\2\2\u0126\u0109\3\2\2\2\u0127"+
		"\r\3\2\2\2\u0128\u012a\7+\2\2\u0129\u012b\5\32\16\2\u012a\u0129\3\2\2"+
		"\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\17"+
		"\3\2\2\2\u012e\u012f\7-\2\2\u012f\u0130\7\3\2\2\u0130\u0131\5\24\13\2"+
		"\u0131\u0132\7\60\2\2\u0132\u0133\7\4\2\2\u0133\u0136\7\60\2\2\u0134\u0135"+
		"\7\n\2\2\u0135\u0137\7\60\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2"+
		"\u0137\u0138\3\2\2\2\u0138\u013c\7\r\2\2\u0139\u013b\5\4\3\2\u013a\u0139"+
		"\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7\16\2\2\u0140\21\3\2\2"+
		"\2\u0141\u0144\7.\2\2\u0142\u0144\7/\2\2\u0143\u0141\3\2\2\2\u0143\u0142"+
		"\3\2\2\2\u0144\23\3\2\2\2\u0145\u014d\7%\2\2\u0146\u014d\7&\2\2\u0147"+
		"\u014d\7\'\2\2\u0148\u014d\7(\2\2\u0149\u014d\7\32\2\2\u014a\u014d\7)"+
		"\2\2\u014b\u014d\5\16\b\2\u014c\u0145\3\2\2\2\u014c\u0146\3\2\2\2\u014c"+
		"\u0147\3\2\2\2\u014c\u0148\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014a\3\2"+
		"\2\2\u014c\u014b\3\2\2\2\u014d\25\3\2\2\2\u014e\u014f\5\36\20\2\u014f"+
		"\u0150\t\2\2\2\u0150\u0151\5\36\20\2\u0151\27\3\2\2\2\u0152\u0153\5\36"+
		"\20\2\u0153\u0154\t\3\2\2\u0154\u0155\5\36\20\2\u0155\31\3\2\2\2\u0156"+
		"\u0159\5\26\f\2\u0157\u0159\5\30\r\2\u0158\u0156\3\2\2\2\u0158\u0157\3"+
		"\2\2\2\u0159\33\3\2\2\2\u015a\u015b\7\60\2\2\u015b\u015c\7\b\2\2\u015c"+
		"\u015d\5\b\5\2\u015d\35\3\2\2\2\u015e\u0168\7\62\2\2\u015f\u0168\7\63"+
		"\2\2\u0160\u0168\7\60\2\2\u0161\u0162\7\60\2\2\u0162\u0163\7\n\2\2\u0163"+
		"\u0168\7\60\2\2\u0164\u0168\7\61\2\2\u0165\u0168\5\22\n\2\u0166\u0168"+
		"\5\16\b\2\u0167\u015e\3\2\2\2\u0167\u015f\3\2\2\2\u0167\u0160\3\2\2\2"+
		"\u0167\u0161\3\2\2\2\u0167\u0164\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166"+
		"\3\2\2\2\u0168\37\3\2\2\2-#)\61;Bahprz|\u0084\u0086\u008e\u0090\u0098"+
		"\u009a\u00a2\u00a4\u00b1\u00b7\u00bd\u00bf\u00c8\u00ca\u00cc\u00d8\u00e2"+
		"\u00e7\u00ef\u0101\u0107\u0111\u0116\u011e\u0126\u012c\u0136\u013c\u0143"+
		"\u014c\u0158\u0167";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}