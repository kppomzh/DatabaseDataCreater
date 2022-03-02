// Generated from D:/Document/OneDrive/CodeRepo/DatabaseDataCreater/dbdf-base/antlr\create.g4 by ANTLR 4.9.2
package com.zhzm.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class createParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, CREATE=7, TABLE=8, NOT=9, 
		NULL=10, PRIMARY=11, FOREIGN=12, KEY=13, UNIQUE=14, CHECK=15, CONSTRAINT=16, 
		TABLESPACE=17, DEFAULT=18, SERIAL=19, AUTOINCREMENT=20, IDENTIFIED=21, 
		COLLATE=22, CHARACTER=23, SET=24, ON=25, UPDATE=26, IN=27, IS=28, BETWEEN=29, 
		AND=30, OR=31, REFERENCES=32, COMMENT=33, ENGINE=34, CHARSET=35, ROW_FORMAT=36, 
		DYNAMIC=37, FIXED=38, COMPRESSED=39, REDUNDANT=40, COMPACT=41, USING=42, 
		BTREE=43, UNSIGNED=44, BOOL=45, DATE=46, DATETIME=47, TIMESTAMP=48, TIME=49, 
		INTEGER=50, NUMBER=51, STRING=52, BYTE=53, BLOB=54, UTF=55, LATIN=56, 
		BIG=57, GB=58, UTF8CI=59, LATINCI=60, CHINACI=61, DIGBOOL=62, DIGSTRING=63, 
		Backticks=64, DOUBLE_QUO=65, NAMED=66, CREATENUM=67, DIGINT=68, SINGAL_QUO=69, 
		A=70, B=71, C=72, D=73, E=74, F=75, G=76, H=77, I=78, J=79, K=80, L=81, 
		M=82, N=83, O=84, P=85, Q=86, R=87, S=88, T=89, U=90, V=91, W=92, X=93, 
		Y=94, Z=95, I1=96, I2=97, I3=98, I4=99, I5=100, I6=101, I7=102, I8=103, 
		I9=104, I0=105, POINT=106, COMMA=107, ESC=108, M_COMMENT=109, S_COMMENT=110, 
		WS=111, LT=112, LE=113, ST=114, SE=115, EQUAL=116, NOTEQUAL=117;
	public static final int
		RULE_start = 0, RULE_create = 1, RULE_tablecreatebranch = 2, RULE_relationproperties = 3, 
		RULE_column = 4, RULE_column_options = 5, RULE_dbdf_options = 6, RULE_hasNull = 7, 
		RULE_tableproperties = 8, RULE_full_tablename = 9, RULE_tablespacename = 10, 
		RULE_tablename = 11, RULE_listname = 12, RULE_indexname = 13, RULE_objectName = 14, 
		RULE_ranges = 15, RULE_isnull = 16, RULE_not_null = 17, RULE_inline_constrain = 18, 
		RULE_inline_uniqueKey = 19, RULE_inline_primaryKey = 20, RULE_inline_foreignKey = 21, 
		RULE_inline_generalKey = 22, RULE_inline_checkKey = 23, RULE_constrain = 24, 
		RULE_indexType = 25, RULE_general_key = 26, RULE_primary_key = 27, RULE_foreign_key = 28, 
		RULE_unique_key = 29, RULE_check_key = 30, RULE_check_key_options = 31, 
		RULE_general_key_options = 32, RULE_autoincreasing = 33, RULE_hasDefault = 34, 
		RULE_charset = 35, RULE_collate = 36, RULE_oracle_tableoption = 37, RULE_oracle_tablespaceset = 38, 
		RULE_mysql_tableoptions = 39, RULE_mysql_tableoption = 40, RULE_mysql_engine_set = 41, 
		RULE_mysql_character_set = 42, RULE_mysql_collate = 43, RULE_mysql_rowfomat = 44, 
		RULE_mysql_incrementset = 45, RULE_mysql_onupdate = 46, RULE_mysql_comment = 47, 
		RULE_mysql_function = 48, RULE_advance_data = 49, RULE_numberset = 50, 
		RULE_datatype = 51, RULE_inttype = 52, RULE_int_range = 53, RULE_unsigned = 54, 
		RULE_doubletype = 55, RULE_double_range = 56, RULE_stringtype = 57, RULE_string_range = 58, 
		RULE_lobtype = 59, RULE_booltype = 60, RULE_date = 61, RULE_datetime = 62, 
		RULE_date_range = 63, RULE_data = 64, RULE_integer = 65, RULE_decimal = 66, 
		RULE_bool = 67, RULE_string = 68, RULE_regular_string = 69, RULE_character_type = 70, 
		RULE_collate_type = 71, RULE_row_formattype = 72, RULE_binary_comparison_operator = 73, 
		RULE_boolLinkOption = 74;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "create", "tablecreatebranch", "relationproperties", "column", 
			"column_options", "dbdf_options", "hasNull", "tableproperties", "full_tablename", 
			"tablespacename", "tablename", "listname", "indexname", "objectName", 
			"ranges", "isnull", "not_null", "inline_constrain", "inline_uniqueKey", 
			"inline_primaryKey", "inline_foreignKey", "inline_generalKey", "inline_checkKey", 
			"constrain", "indexType", "general_key", "primary_key", "foreign_key", 
			"unique_key", "check_key", "check_key_options", "general_key_options", 
			"autoincreasing", "hasDefault", "charset", "collate", "oracle_tableoption", 
			"oracle_tablespaceset", "mysql_tableoptions", "mysql_tableoption", "mysql_engine_set", 
			"mysql_character_set", "mysql_collate", "mysql_rowfomat", "mysql_incrementset", 
			"mysql_onupdate", "mysql_comment", "mysql_function", "advance_data", 
			"numberset", "datatype", "inttype", "int_range", "unsigned", "doubletype", 
			"double_range", "stringtype", "string_range", "lobtype", "booltype", 
			"date", "datetime", "date_range", "data", "integer", "decimal", "bool", 
			"string", "regular_string", "character_type", "collate_type", "row_formattype", 
			"binary_comparison_operator", "boolLinkOption"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "')'", "'='", "'+'", "'-'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'`'", "'\"'", null, null, null, "'''", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'1'", "'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", 
			"'0'", "'.'", "','", null, null, null, null, "'>'", "'>='", "'<'", "'<='", 
			null, "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "CREATE", "TABLE", "NOT", "NULL", 
			"PRIMARY", "FOREIGN", "KEY", "UNIQUE", "CHECK", "CONSTRAINT", "TABLESPACE", 
			"DEFAULT", "SERIAL", "AUTOINCREMENT", "IDENTIFIED", "COLLATE", "CHARACTER", 
			"SET", "ON", "UPDATE", "IN", "IS", "BETWEEN", "AND", "OR", "REFERENCES", 
			"COMMENT", "ENGINE", "CHARSET", "ROW_FORMAT", "DYNAMIC", "FIXED", "COMPRESSED", 
			"REDUNDANT", "COMPACT", "USING", "BTREE", "UNSIGNED", "BOOL", "DATE", 
			"DATETIME", "TIMESTAMP", "TIME", "INTEGER", "NUMBER", "STRING", "BYTE", 
			"BLOB", "UTF", "LATIN", "BIG", "GB", "UTF8CI", "LATINCI", "CHINACI", 
			"DIGBOOL", "DIGSTRING", "Backticks", "DOUBLE_QUO", "NAMED", "CREATENUM", 
			"DIGINT", "SINGAL_QUO", "A", "B", "C", "D", "E", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", 
			"I0", "POINT", "COMMA", "ESC", "M_COMMENT", "S_COMMENT", "WS", "LT", 
			"LE", "ST", "SE", "EQUAL", "NOTEQUAL"
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
	public String getGrammarFileName() { return "create.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public createParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public List<CreateContext> create() {
			return getRuleContexts(CreateContext.class);
		}
		public CreateContext create(int i) {
			return getRuleContext(CreateContext.class,i);
		}
		public TerminalNode EOF() { return getToken(createParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			create();
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(151);
					match(T__0);
					setState(152);
					create();
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(158);
			match(T__0);
			setState(159);
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

	public static class CreateContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(createParser.CREATE, 0); }
		public TablecreatebranchContext tablecreatebranch() {
			return getRuleContext(TablecreatebranchContext.class,0);
		}
		public NumbersetContext numberset() {
			return getRuleContext(NumbersetContext.class,0);
		}
		public CreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCreate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCreate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateContext create() throws RecognitionException {
		CreateContext _localctx = new CreateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_create);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(CREATE);
			setState(162);
			tablecreatebranch();
			setState(163);
			numberset();
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablecreatebranchContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(createParser.TABLE, 0); }
		public Full_tablenameContext full_tablename() {
			return getRuleContext(Full_tablenameContext.class,0);
		}
		public RelationpropertiesContext relationproperties() {
			return getRuleContext(RelationpropertiesContext.class,0);
		}
		public TablepropertiesContext tableproperties() {
			return getRuleContext(TablepropertiesContext.class,0);
		}
		public TablecreatebranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablecreatebranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterTablecreatebranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitTablecreatebranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitTablecreatebranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablecreatebranchContext tablecreatebranch() throws RecognitionException {
		TablecreatebranchContext _localctx = new TablecreatebranchContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tablecreatebranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(TABLE);
			setState(166);
			full_tablename();
			setState(167);
			match(T__1);
			setState(168);
			relationproperties();
			setState(169);
			match(T__2);
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(170);
				tableproperties();
				}
				break;
			}
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationpropertiesContext extends ParserRuleContext {
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(createParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(createParser.COMMA, i);
		}
		public List<ConstrainContext> constrain() {
			return getRuleContexts(ConstrainContext.class);
		}
		public ConstrainContext constrain(int i) {
			return getRuleContext(ConstrainContext.class,i);
		}
		public RelationpropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationproperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterRelationproperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitRelationproperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitRelationproperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationpropertiesContext relationproperties() throws RecognitionException {
		RelationpropertiesContext _localctx = new RelationpropertiesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_relationproperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			column();
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(174);
				match(COMMA);
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Backticks:
				case DOUBLE_QUO:
				case NAMED:
					{
					setState(175);
					column();
					}
					break;
				case PRIMARY:
				case FOREIGN:
				case KEY:
				case UNIQUE:
				case CHECK:
				case CONSTRAINT:
					{
					setState(176);
					constrain();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnContext extends ParserRuleContext {
		public ListnameContext listname() {
			return getRuleContext(ListnameContext.class,0);
		}
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public List<Column_optionsContext> column_options() {
			return getRuleContexts(Column_optionsContext.class);
		}
		public Column_optionsContext column_options(int i) {
			return getRuleContext(Column_optionsContext.class,i);
		}
		public Mysql_commentContext mysql_comment() {
			return getRuleContext(Mysql_commentContext.class,0);
		}
		public List<Dbdf_optionsContext> dbdf_options() {
			return getRuleContexts(Dbdf_optionsContext.class);
		}
		public Dbdf_optionsContext dbdf_options(int i) {
			return getRuleContext(Dbdf_optionsContext.class,i);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_column);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			listname();
			setState(185);
			datatype();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << NULL) | (1L << PRIMARY) | (1L << FOREIGN) | (1L << KEY) | (1L << UNIQUE) | (1L << CHECK) | (1L << DEFAULT) | (1L << SERIAL) | (1L << AUTOINCREMENT) | (1L << IDENTIFIED) | (1L << COLLATE) | (1L << CHARACTER))) != 0)) {
				{
				{
				setState(186);
				column_options();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(192);
				mysql_comment();
				}
			}

			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SINGAL_QUO) {
				{
				{
				setState(195);
				dbdf_options();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_optionsContext extends ParserRuleContext {
		public Inline_constrainContext inline_constrain() {
			return getRuleContext(Inline_constrainContext.class,0);
		}
		public AutoincreasingContext autoincreasing() {
			return getRuleContext(AutoincreasingContext.class,0);
		}
		public HasDefaultContext hasDefault() {
			return getRuleContext(HasDefaultContext.class,0);
		}
		public HasNullContext hasNull() {
			return getRuleContext(HasNullContext.class,0);
		}
		public CollateContext collate() {
			return getRuleContext(CollateContext.class,0);
		}
		public CharsetContext charset() {
			return getRuleContext(CharsetContext.class,0);
		}
		public Column_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterColumn_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitColumn_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitColumn_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_optionsContext column_options() throws RecognitionException {
		Column_optionsContext _localctx = new Column_optionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_column_options);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIMARY:
			case FOREIGN:
			case KEY:
			case UNIQUE:
			case CHECK:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				inline_constrain();
				}
				break;
			case SERIAL:
			case AUTOINCREMENT:
			case IDENTIFIED:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				autoincreasing();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				hasDefault();
				}
				break;
			case NOT:
			case NULL:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				hasNull();
				}
				break;
			case COLLATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				collate();
				}
				break;
			case CHARACTER:
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				charset();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dbdf_optionsContext extends ParserRuleContext {
		public Regular_stringContext regular_string() {
			return getRuleContext(Regular_stringContext.class,0);
		}
		public Dbdf_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dbdf_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDbdf_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDbdf_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDbdf_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dbdf_optionsContext dbdf_options() throws RecognitionException {
		Dbdf_optionsContext _localctx = new Dbdf_optionsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dbdf_options);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			regular_string();
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

	public static class HasNullContext extends ParserRuleContext {
		public IsnullContext isnull() {
			return getRuleContext(IsnullContext.class,0);
		}
		public Not_nullContext not_null() {
			return getRuleContext(Not_nullContext.class,0);
		}
		public HasNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hasNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterHasNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitHasNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitHasNull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HasNullContext hasNull() throws RecognitionException {
		HasNullContext _localctx = new HasNullContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_hasNull);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULL:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				isnull();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				not_null();
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

	public static class TablepropertiesContext extends ParserRuleContext {
		public Oracle_tableoptionContext oracle_tableoption() {
			return getRuleContext(Oracle_tableoptionContext.class,0);
		}
		public Mysql_tableoptionsContext mysql_tableoptions() {
			return getRuleContext(Mysql_tableoptionsContext.class,0);
		}
		public TablepropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableproperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterTableproperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitTableproperties(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitTableproperties(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablepropertiesContext tableproperties() throws RecognitionException {
		TablepropertiesContext _localctx = new TablepropertiesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableproperties);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				oracle_tableoption();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				mysql_tableoptions();
				}
				break;
			}
		}
		catch (RecognitionException e) {
			 throw e; 
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Full_tablenameContext extends ParserRuleContext {
		public TablenameContext tablename() {
			return getRuleContext(TablenameContext.class,0);
		}
		public TablespacenameContext tablespacename() {
			return getRuleContext(TablespacenameContext.class,0);
		}
		public TerminalNode POINT() { return getToken(createParser.POINT, 0); }
		public Full_tablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full_tablename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterFull_tablename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitFull_tablename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitFull_tablename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Full_tablenameContext full_tablename() throws RecognitionException {
		Full_tablenameContext _localctx = new Full_tablenameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_full_tablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(219);
				tablespacename();
				setState(220);
				match(POINT);
				}
				break;
			}
			setState(224);
			tablename();
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

	public static class TablespacenameContext extends ParserRuleContext {
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public TablespacenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablespacename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterTablespacename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitTablespacename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitTablespacename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablespacenameContext tablespacename() throws RecognitionException {
		TablespacenameContext _localctx = new TablespacenameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tablespacename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			objectName();
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

	public static class TablenameContext extends ParserRuleContext {
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public TablenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterTablename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitTablename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitTablename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablenameContext tablename() throws RecognitionException {
		TablenameContext _localctx = new TablenameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tablename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			objectName();
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

	public static class ListnameContext extends ParserRuleContext {
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public ListnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterListname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitListname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitListname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListnameContext listname() throws RecognitionException {
		ListnameContext _localctx = new ListnameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			objectName();
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

	public static class IndexnameContext extends ParserRuleContext {
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public IndexnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterIndexname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitIndexname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitIndexname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexnameContext indexname() throws RecognitionException {
		IndexnameContext _localctx = new IndexnameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_indexname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			objectName();
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

	public static class ObjectNameContext extends ParserRuleContext {
		public TerminalNode NAMED() { return getToken(createParser.NAMED, 0); }
		public List<TerminalNode> DOUBLE_QUO() { return getTokens(createParser.DOUBLE_QUO); }
		public TerminalNode DOUBLE_QUO(int i) {
			return getToken(createParser.DOUBLE_QUO, i);
		}
		public List<TerminalNode> Backticks() { return getTokens(createParser.Backticks); }
		public TerminalNode Backticks(int i) {
			return getToken(createParser.Backticks, i);
		}
		public ObjectNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterObjectName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitObjectName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitObjectName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectNameContext objectName() throws RecognitionException {
		ObjectNameContext _localctx = new ObjectNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_objectName);
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAMED:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(NAMED);
				}
				break;
			case DOUBLE_QUO:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(235);
				match(DOUBLE_QUO);
				setState(236);
				match(NAMED);
				setState(237);
				match(DOUBLE_QUO);
				}
				}
				break;
			case Backticks:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(238);
				match(Backticks);
				setState(239);
				match(NAMED);
				setState(240);
				match(Backticks);
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

	public static class RangesContext extends ParserRuleContext {
		public List<TerminalNode> DIGINT() { return getTokens(createParser.DIGINT); }
		public TerminalNode DIGINT(int i) {
			return getToken(createParser.DIGINT, i);
		}
		public TerminalNode BYTE() { return getToken(createParser.BYTE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(createParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(createParser.COMMA, i);
		}
		public RangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ranges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterRanges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitRanges(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitRanges(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangesContext ranges() throws RecognitionException {
		RangesContext _localctx = new RangesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ranges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__1);
			setState(244);
			match(DIGINT);
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(245);
					match(COMMA);
					setState(246);
					match(DIGINT);
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(252);
				match(BYTE);
				}
				break;
			}
			setState(255);
			match(T__2);
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

	public static class IsnullContext extends ParserRuleContext {
		public TerminalNode NULL() { return getToken(createParser.NULL, 0); }
		public IsnullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterIsnull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitIsnull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitIsnull(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsnullContext isnull() throws RecognitionException {
		IsnullContext _localctx = new IsnullContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_isnull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(NULL);
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

	public static class Not_nullContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(createParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(createParser.NULL, 0); }
		public Not_nullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_null; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterNot_null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitNot_null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitNot_null(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Not_nullContext not_null() throws RecognitionException {
		Not_nullContext _localctx = new Not_nullContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_not_null);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(NOT);
			setState(260);
			match(NULL);
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

	public static class Inline_constrainContext extends ParserRuleContext {
		public Inline_uniqueKeyContext inline_uniqueKey() {
			return getRuleContext(Inline_uniqueKeyContext.class,0);
		}
		public Inline_primaryKeyContext inline_primaryKey() {
			return getRuleContext(Inline_primaryKeyContext.class,0);
		}
		public Inline_foreignKeyContext inline_foreignKey() {
			return getRuleContext(Inline_foreignKeyContext.class,0);
		}
		public Inline_generalKeyContext inline_generalKey() {
			return getRuleContext(Inline_generalKeyContext.class,0);
		}
		public Inline_checkKeyContext inline_checkKey() {
			return getRuleContext(Inline_checkKeyContext.class,0);
		}
		public Inline_constrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_constrain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_constrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_constrain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_constrain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_constrainContext inline_constrain() throws RecognitionException {
		Inline_constrainContext _localctx = new Inline_constrainContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_inline_constrain);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNIQUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				inline_uniqueKey();
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				inline_primaryKey();
				}
				break;
			case FOREIGN:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				inline_foreignKey();
				}
				break;
			case KEY:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
				inline_generalKey();
				}
				break;
			case CHECK:
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				inline_checkKey();
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

	public static class Inline_uniqueKeyContext extends ParserRuleContext {
		public TerminalNode UNIQUE() { return getToken(createParser.UNIQUE, 0); }
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public Inline_uniqueKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_uniqueKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_uniqueKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_uniqueKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_uniqueKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_uniqueKeyContext inline_uniqueKey() throws RecognitionException {
		Inline_uniqueKeyContext _localctx = new Inline_uniqueKeyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_inline_uniqueKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(UNIQUE);
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(270);
				match(KEY);
				}
				break;
			}
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

	public static class Inline_primaryKeyContext extends ParserRuleContext {
		public TerminalNode PRIMARY() { return getToken(createParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public Inline_primaryKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_primaryKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_primaryKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_primaryKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_primaryKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_primaryKeyContext inline_primaryKey() throws RecognitionException {
		Inline_primaryKeyContext _localctx = new Inline_primaryKeyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inline_primaryKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(PRIMARY);
			setState(274);
			match(KEY);
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

	public static class Inline_foreignKeyContext extends ParserRuleContext {
		public TerminalNode FOREIGN() { return getToken(createParser.FOREIGN, 0); }
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public TerminalNode REFERENCES() { return getToken(createParser.REFERENCES, 0); }
		public Full_tablenameContext full_tablename() {
			return getRuleContext(Full_tablenameContext.class,0);
		}
		public ListnameContext listname() {
			return getRuleContext(ListnameContext.class,0);
		}
		public Inline_foreignKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_foreignKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_foreignKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_foreignKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_foreignKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_foreignKeyContext inline_foreignKey() throws RecognitionException {
		Inline_foreignKeyContext _localctx = new Inline_foreignKeyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_inline_foreignKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(FOREIGN);
			setState(277);
			match(KEY);
			setState(278);
			match(REFERENCES);
			setState(279);
			full_tablename();
			setState(280);
			match(T__1);
			setState(281);
			listname();
			setState(282);
			match(T__2);
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

	public static class Inline_generalKeyContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public Inline_generalKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_generalKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_generalKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_generalKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_generalKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_generalKeyContext inline_generalKey() throws RecognitionException {
		Inline_generalKeyContext _localctx = new Inline_generalKeyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_inline_generalKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(KEY);
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

	public static class Inline_checkKeyContext extends ParserRuleContext {
		public TerminalNode CHECK() { return getToken(createParser.CHECK, 0); }
		public Check_key_optionsContext check_key_options() {
			return getRuleContext(Check_key_optionsContext.class,0);
		}
		public Inline_checkKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_checkKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInline_checkKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInline_checkKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInline_checkKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_checkKeyContext inline_checkKey() throws RecognitionException {
		Inline_checkKeyContext _localctx = new Inline_checkKeyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_inline_checkKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(CHECK);
			setState(287);
			check_key_options();
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

	public static class ConstrainContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(createParser.USING, 0); }
		public TerminalNode BTREE() { return getToken(createParser.BTREE, 0); }
		public IndexTypeContext indexType() {
			return getRuleContext(IndexTypeContext.class,0);
		}
		public TerminalNode CONSTRAINT() { return getToken(createParser.CONSTRAINT, 0); }
		public IndexnameContext indexname() {
			return getRuleContext(IndexnameContext.class,0);
		}
		public ConstrainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constrain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterConstrain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitConstrain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitConstrain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstrainContext constrain() throws RecognitionException {
		ConstrainContext _localctx = new ConstrainContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constrain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONSTRAINT:
				{
				{
				{
				setState(289);
				match(CONSTRAINT);
				setState(290);
				indexname();
				}
				setState(292);
				indexType();
				}
				}
				break;
			case PRIMARY:
			case FOREIGN:
			case KEY:
			case UNIQUE:
			case CHECK:
				{
				{
				setState(294);
				indexType();
				{
				setState(295);
				indexname();
				}
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USING) {
				{
				setState(299);
				match(USING);
				setState(300);
				match(BTREE);
				}
			}

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

	public static class IndexTypeContext extends ParserRuleContext {
		public General_keyContext general_key() {
			return getRuleContext(General_keyContext.class,0);
		}
		public Check_keyContext check_key() {
			return getRuleContext(Check_keyContext.class,0);
		}
		public Foreign_keyContext foreign_key() {
			return getRuleContext(Foreign_keyContext.class,0);
		}
		public Unique_keyContext unique_key() {
			return getRuleContext(Unique_keyContext.class,0);
		}
		public Primary_keyContext primary_key() {
			return getRuleContext(Primary_keyContext.class,0);
		}
		public IndexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterIndexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitIndexType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitIndexType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexTypeContext indexType() throws RecognitionException {
		IndexTypeContext _localctx = new IndexTypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_indexType);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				general_key();
				}
				break;
			case CHECK:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				check_key();
				}
				break;
			case FOREIGN:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				foreign_key();
				}
				break;
			case UNIQUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				unique_key();
				}
				break;
			case PRIMARY:
				enterOuterAlt(_localctx, 5);
				{
				setState(307);
				primary_key();
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

	public static class General_keyContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public General_key_optionsContext general_key_options() {
			return getRuleContext(General_key_optionsContext.class,0);
		}
		public General_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterGeneral_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitGeneral_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitGeneral_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_keyContext general_key() throws RecognitionException {
		General_keyContext _localctx = new General_keyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_general_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(KEY);
			setState(311);
			general_key_options();
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

	public static class Primary_keyContext extends ParserRuleContext {
		public TerminalNode PRIMARY() { return getToken(createParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public General_key_optionsContext general_key_options() {
			return getRuleContext(General_key_optionsContext.class,0);
		}
		public Primary_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterPrimary_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitPrimary_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitPrimary_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_keyContext primary_key() throws RecognitionException {
		Primary_keyContext _localctx = new Primary_keyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_primary_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(PRIMARY);
			setState(314);
			match(KEY);
			setState(315);
			general_key_options();
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

	public static class Foreign_keyContext extends ParserRuleContext {
		public TerminalNode FOREIGN() { return getToken(createParser.FOREIGN, 0); }
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public List<ListnameContext> listname() {
			return getRuleContexts(ListnameContext.class);
		}
		public ListnameContext listname(int i) {
			return getRuleContext(ListnameContext.class,i);
		}
		public TerminalNode REFERENCES() { return getToken(createParser.REFERENCES, 0); }
		public Full_tablenameContext full_tablename() {
			return getRuleContext(Full_tablenameContext.class,0);
		}
		public Foreign_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterForeign_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitForeign_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitForeign_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Foreign_keyContext foreign_key() throws RecognitionException {
		Foreign_keyContext _localctx = new Foreign_keyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_foreign_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(FOREIGN);
			setState(318);
			match(KEY);
			setState(319);
			match(T__1);
			setState(320);
			listname();
			setState(321);
			match(T__2);
			setState(322);
			match(REFERENCES);
			setState(323);
			full_tablename();
			setState(324);
			match(T__1);
			setState(325);
			listname();
			setState(326);
			match(T__2);
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

	public static class Unique_keyContext extends ParserRuleContext {
		public TerminalNode UNIQUE() { return getToken(createParser.UNIQUE, 0); }
		public General_key_optionsContext general_key_options() {
			return getRuleContext(General_key_optionsContext.class,0);
		}
		public TerminalNode KEY() { return getToken(createParser.KEY, 0); }
		public Unique_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterUnique_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitUnique_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitUnique_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unique_keyContext unique_key() throws RecognitionException {
		Unique_keyContext _localctx = new Unique_keyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unique_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(UNIQUE);
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY) {
				{
				setState(329);
				match(KEY);
				}
			}

			setState(332);
			general_key_options();
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

	public static class Check_keyContext extends ParserRuleContext {
		public TerminalNode CHECK() { return getToken(createParser.CHECK, 0); }
		public List<Check_key_optionsContext> check_key_options() {
			return getRuleContexts(Check_key_optionsContext.class);
		}
		public Check_key_optionsContext check_key_options(int i) {
			return getRuleContext(Check_key_optionsContext.class,i);
		}
		public List<BoolLinkOptionContext> boolLinkOption() {
			return getRuleContexts(BoolLinkOptionContext.class);
		}
		public BoolLinkOptionContext boolLinkOption(int i) {
			return getRuleContext(BoolLinkOptionContext.class,i);
		}
		public Check_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCheck_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCheck_key(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCheck_key(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Check_keyContext check_key() throws RecognitionException {
		Check_keyContext _localctx = new Check_keyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_check_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(CHECK);
			setState(335);
			match(T__1);
			setState(336);
			check_key_options();
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(337);
				boolLinkOption();
				setState(338);
				check_key_options();
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(345);
			match(T__2);
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

	public static class Check_key_optionsContext extends ParserRuleContext {
		public ListnameContext listname() {
			return getRuleContext(ListnameContext.class,0);
		}
		public TerminalNode IN() { return getToken(createParser.IN, 0); }
		public List<DataContext> data() {
			return getRuleContexts(DataContext.class);
		}
		public DataContext data(int i) {
			return getRuleContext(DataContext.class,i);
		}
		public Binary_comparison_operatorContext binary_comparison_operator() {
			return getRuleContext(Binary_comparison_operatorContext.class,0);
		}
		public Advance_dataContext advance_data() {
			return getRuleContext(Advance_dataContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(createParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(createParser.AND, 0); }
		public TerminalNode IS() { return getToken(createParser.IS, 0); }
		public IsnullContext isnull() {
			return getRuleContext(IsnullContext.class,0);
		}
		public Not_nullContext not_null() {
			return getRuleContext(Not_nullContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(createParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(createParser.COMMA, i);
		}
		public Check_key_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_check_key_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCheck_key_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCheck_key_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCheck_key_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Check_key_optionsContext check_key_options() throws RecognitionException {
		Check_key_optionsContext _localctx = new Check_key_optionsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_check_key_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			listname();
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN:
				{
				setState(348);
				match(IN);
				setState(349);
				match(T__1);
				setState(350);
				data();
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(351);
					match(COMMA);
					setState(352);
					data();
					}
					}
					setState(357);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(358);
				match(T__2);
				}
				break;
			case LT:
			case LE:
			case ST:
			case SE:
			case EQUAL:
			case NOTEQUAL:
				{
				setState(360);
				binary_comparison_operator();
				setState(361);
				advance_data();
				}
				break;
			case BETWEEN:
				{
				setState(363);
				match(BETWEEN);
				setState(364);
				data();
				setState(365);
				match(AND);
				setState(366);
				data();
				}
				break;
			case IS:
				{
				setState(368);
				match(IS);
				setState(371);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NULL:
					{
					setState(369);
					isnull();
					}
					break;
				case NOT:
					{
					setState(370);
					not_null();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class General_key_optionsContext extends ParserRuleContext {
		public List<ListnameContext> listname() {
			return getRuleContexts(ListnameContext.class);
		}
		public ListnameContext listname(int i) {
			return getRuleContext(ListnameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(createParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(createParser.COMMA, i);
		}
		public General_key_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_general_key_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterGeneral_key_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitGeneral_key_options(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitGeneral_key_options(this);
			else return visitor.visitChildren(this);
		}
	}

	public final General_key_optionsContext general_key_options() throws RecognitionException {
		General_key_optionsContext _localctx = new General_key_optionsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_general_key_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(T__1);
			setState(376);
			listname();
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(377);
				match(COMMA);
				setState(378);
				listname();
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(384);
			match(T__2);
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

	public static class AutoincreasingContext extends ParserRuleContext {
		public TerminalNode SERIAL() { return getToken(createParser.SERIAL, 0); }
		public TerminalNode AUTOINCREMENT() { return getToken(createParser.AUTOINCREMENT, 0); }
		public TerminalNode IDENTIFIED() { return getToken(createParser.IDENTIFIED, 0); }
		public List<TerminalNode> DIGINT() { return getTokens(createParser.DIGINT); }
		public TerminalNode DIGINT(int i) {
			return getToken(createParser.DIGINT, i);
		}
		public TerminalNode COMMA() { return getToken(createParser.COMMA, 0); }
		public AutoincreasingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoincreasing; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterAutoincreasing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitAutoincreasing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitAutoincreasing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutoincreasingContext autoincreasing() throws RecognitionException {
		AutoincreasingContext _localctx = new AutoincreasingContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_autoincreasing);
		try {
			setState(394);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SERIAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				match(SERIAL);
				}
				break;
			case AUTOINCREMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(AUTOINCREMENT);
				}
				break;
			case IDENTIFIED:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(388);
				match(IDENTIFIED);
				setState(389);
				match(T__1);
				setState(390);
				match(DIGINT);
				setState(391);
				match(COMMA);
				setState(392);
				match(DIGINT);
				setState(393);
				match(T__2);
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

	public static class HasDefaultContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(createParser.DEFAULT, 0); }
		public Advance_dataContext advance_data() {
			return getRuleContext(Advance_dataContext.class,0);
		}
		public Mysql_onupdateContext mysql_onupdate() {
			return getRuleContext(Mysql_onupdateContext.class,0);
		}
		public HasDefaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hasDefault; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterHasDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitHasDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitHasDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HasDefaultContext hasDefault() throws RecognitionException {
		HasDefaultContext _localctx = new HasDefaultContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_hasDefault);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(DEFAULT);
			setState(397);
			advance_data();
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(398);
				mysql_onupdate();
				}
			}

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

	public static class CharsetContext extends ParserRuleContext {
		public TerminalNode CHARACTER() { return getToken(createParser.CHARACTER, 0); }
		public TerminalNode SET() { return getToken(createParser.SET, 0); }
		public Character_typeContext character_type() {
			return getRuleContext(Character_typeContext.class,0);
		}
		public CharsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCharset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCharset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCharset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharsetContext charset() throws RecognitionException {
		CharsetContext _localctx = new CharsetContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_charset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(CHARACTER);
			setState(402);
			match(SET);
			setState(403);
			character_type();
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

	public static class CollateContext extends ParserRuleContext {
		public TerminalNode COLLATE() { return getToken(createParser.COLLATE, 0); }
		public Collate_typeContext collate_type() {
			return getRuleContext(Collate_typeContext.class,0);
		}
		public CollateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCollate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCollate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCollate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollateContext collate() throws RecognitionException {
		CollateContext _localctx = new CollateContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_collate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			match(COLLATE);
			setState(406);
			collate_type();
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

	public static class Oracle_tableoptionContext extends ParserRuleContext {
		public Oracle_tablespacesetContext oracle_tablespaceset() {
			return getRuleContext(Oracle_tablespacesetContext.class,0);
		}
		public Oracle_tableoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oracle_tableoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterOracle_tableoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitOracle_tableoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitOracle_tableoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Oracle_tableoptionContext oracle_tableoption() throws RecognitionException {
		Oracle_tableoptionContext _localctx = new Oracle_tableoptionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_oracle_tableoption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TABLESPACE) {
				{
				setState(408);
				oracle_tablespaceset();
				}
			}

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

	public static class Oracle_tablespacesetContext extends ParserRuleContext {
		public TerminalNode TABLESPACE() { return getToken(createParser.TABLESPACE, 0); }
		public TablespacenameContext tablespacename() {
			return getRuleContext(TablespacenameContext.class,0);
		}
		public Oracle_tablespacesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oracle_tablespaceset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterOracle_tablespaceset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitOracle_tablespaceset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitOracle_tablespaceset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Oracle_tablespacesetContext oracle_tablespaceset() throws RecognitionException {
		Oracle_tablespacesetContext _localctx = new Oracle_tablespacesetContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_oracle_tablespaceset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(TABLESPACE);
			setState(412);
			tablespacename();
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

	public static class Mysql_tableoptionsContext extends ParserRuleContext {
		public List<Mysql_tableoptionContext> mysql_tableoption() {
			return getRuleContexts(Mysql_tableoptionContext.class);
		}
		public Mysql_tableoptionContext mysql_tableoption(int i) {
			return getRuleContext(Mysql_tableoptionContext.class,i);
		}
		public Mysql_tableoptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_tableoptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_tableoptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_tableoptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_tableoptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_tableoptionsContext mysql_tableoptions() throws RecognitionException {
		Mysql_tableoptionsContext _localctx = new Mysql_tableoptionsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_mysql_tableoptions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(414);
					mysql_tableoption();
					}
					} 
				}
				setState(419);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
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

	public static class Mysql_tableoptionContext extends ParserRuleContext {
		public Mysql_engine_setContext mysql_engine_set() {
			return getRuleContext(Mysql_engine_setContext.class,0);
		}
		public Mysql_commentContext mysql_comment() {
			return getRuleContext(Mysql_commentContext.class,0);
		}
		public Mysql_character_setContext mysql_character_set() {
			return getRuleContext(Mysql_character_setContext.class,0);
		}
		public Mysql_collateContext mysql_collate() {
			return getRuleContext(Mysql_collateContext.class,0);
		}
		public Mysql_rowfomatContext mysql_rowfomat() {
			return getRuleContext(Mysql_rowfomatContext.class,0);
		}
		public Mysql_incrementsetContext mysql_incrementset() {
			return getRuleContext(Mysql_incrementsetContext.class,0);
		}
		public Mysql_tableoptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_tableoption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_tableoption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_tableoption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_tableoption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_tableoptionContext mysql_tableoption() throws RecognitionException {
		Mysql_tableoptionContext _localctx = new Mysql_tableoptionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_mysql_tableoption);
		try {
			setState(426);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				mysql_engine_set();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				mysql_comment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				mysql_character_set();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				mysql_collate();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(424);
				mysql_rowfomat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(425);
				mysql_incrementset();
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

	public static class Mysql_engine_setContext extends ParserRuleContext {
		public TerminalNode ENGINE() { return getToken(createParser.ENGINE, 0); }
		public ObjectNameContext objectName() {
			return getRuleContext(ObjectNameContext.class,0);
		}
		public Mysql_engine_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_engine_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_engine_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_engine_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_engine_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_engine_setContext mysql_engine_set() throws RecognitionException {
		Mysql_engine_setContext _localctx = new Mysql_engine_setContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_mysql_engine_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(ENGINE);
			setState(429);
			match(T__3);
			setState(430);
			objectName();
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

	public static class Mysql_character_setContext extends ParserRuleContext {
		public TerminalNode CHARSET() { return getToken(createParser.CHARSET, 0); }
		public Character_typeContext character_type() {
			return getRuleContext(Character_typeContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(createParser.DEFAULT, 0); }
		public Mysql_character_setContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_character_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_character_set(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_character_set(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_character_set(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_character_setContext mysql_character_set() throws RecognitionException {
		Mysql_character_setContext _localctx = new Mysql_character_setContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_mysql_character_set);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(432);
				match(DEFAULT);
				}
			}

			setState(435);
			match(CHARSET);
			setState(436);
			match(T__3);
			setState(437);
			character_type();
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

	public static class Mysql_collateContext extends ParserRuleContext {
		public TerminalNode COLLATE() { return getToken(createParser.COLLATE, 0); }
		public Collate_typeContext collate_type() {
			return getRuleContext(Collate_typeContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(createParser.DEFAULT, 0); }
		public Mysql_collateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_collate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_collate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_collate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_collate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_collateContext mysql_collate() throws RecognitionException {
		Mysql_collateContext _localctx = new Mysql_collateContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_mysql_collate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(439);
				match(DEFAULT);
				}
			}

			setState(442);
			match(COLLATE);
			setState(443);
			match(T__3);
			setState(444);
			collate_type();
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

	public static class Mysql_rowfomatContext extends ParserRuleContext {
		public TerminalNode ROW_FORMAT() { return getToken(createParser.ROW_FORMAT, 0); }
		public Row_formattypeContext row_formattype() {
			return getRuleContext(Row_formattypeContext.class,0);
		}
		public Mysql_rowfomatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_rowfomat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_rowfomat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_rowfomat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_rowfomat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_rowfomatContext mysql_rowfomat() throws RecognitionException {
		Mysql_rowfomatContext _localctx = new Mysql_rowfomatContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_mysql_rowfomat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(ROW_FORMAT);
			setState(447);
			match(T__3);
			setState(448);
			row_formattype();
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

	public static class Mysql_incrementsetContext extends ParserRuleContext {
		public TerminalNode AUTOINCREMENT() { return getToken(createParser.AUTOINCREMENT, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Mysql_incrementsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_incrementset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_incrementset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_incrementset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_incrementset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_incrementsetContext mysql_incrementset() throws RecognitionException {
		Mysql_incrementsetContext _localctx = new Mysql_incrementsetContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_mysql_incrementset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(AUTOINCREMENT);
			setState(451);
			match(T__3);
			setState(452);
			integer();
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

	public static class Mysql_onupdateContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(createParser.ON, 0); }
		public TerminalNode UPDATE() { return getToken(createParser.UPDATE, 0); }
		public Advance_dataContext advance_data() {
			return getRuleContext(Advance_dataContext.class,0);
		}
		public Mysql_onupdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_onupdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_onupdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_onupdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_onupdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_onupdateContext mysql_onupdate() throws RecognitionException {
		Mysql_onupdateContext _localctx = new Mysql_onupdateContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_mysql_onupdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(ON);
			setState(455);
			match(UPDATE);
			setState(456);
			advance_data();
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

	public static class Mysql_commentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(createParser.COMMENT, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Mysql_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_comment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_comment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_commentContext mysql_comment() throws RecognitionException {
		Mysql_commentContext _localctx = new Mysql_commentContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_mysql_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(COMMENT);
			setState(459);
			string();
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

	public static class Mysql_functionContext extends ParserRuleContext {
		public TerminalNode NAMED() { return getToken(createParser.NAMED, 0); }
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public Mysql_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mysql_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterMysql_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitMysql_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitMysql_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mysql_functionContext mysql_function() throws RecognitionException {
		Mysql_functionContext _localctx = new Mysql_functionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_mysql_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			match(NAMED);
			setState(462);
			match(T__1);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << NULL) | (1L << DIGBOOL))) != 0) || _la==DIGINT || _la==SINGAL_QUO) {
				{
				setState(463);
				data();
				}
			}

			setState(466);
			match(T__2);
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

	public static class Advance_dataContext extends ParserRuleContext {
		public DataContext data() {
			return getRuleContext(DataContext.class,0);
		}
		public Mysql_functionContext mysql_function() {
			return getRuleContext(Mysql_functionContext.class,0);
		}
		public Advance_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_advance_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterAdvance_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitAdvance_data(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitAdvance_data(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Advance_dataContext advance_data() throws RecognitionException {
		Advance_dataContext _localctx = new Advance_dataContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_advance_data);
		try {
			setState(470);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case NULL:
			case DIGBOOL:
			case DIGINT:
			case SINGAL_QUO:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				data();
				}
				break;
			case NAMED:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				mysql_function();
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

	public static class NumbersetContext extends ParserRuleContext {
		public TerminalNode CREATENUM() { return getToken(createParser.CREATENUM, 0); }
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public NumbersetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterNumberset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitNumberset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitNumberset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbersetContext numberset() throws RecognitionException {
		NumbersetContext _localctx = new NumbersetContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_numberset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(CREATENUM);
			setState(473);
			match(DIGINT);
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

	public static class DatatypeContext extends ParserRuleContext {
		public InttypeContext inttype() {
			return getRuleContext(InttypeContext.class,0);
		}
		public DoubletypeContext doubletype() {
			return getRuleContext(DoubletypeContext.class,0);
		}
		public StringtypeContext stringtype() {
			return getRuleContext(StringtypeContext.class,0);
		}
		public BooltypeContext booltype() {
			return getRuleContext(BooltypeContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public LobtypeContext lobtype() {
			return getRuleContext(LobtypeContext.class,0);
		}
		public DatetimeContext datetime() {
			return getRuleContext(DatetimeContext.class,0);
		}
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDatatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_datatype);
		try {
			setState(482);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				inttype();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				doubletype();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				stringtype();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(478);
				booltype();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 5);
				{
				setState(479);
				date();
				}
				break;
			case BLOB:
				enterOuterAlt(_localctx, 6);
				{
				setState(480);
				lobtype();
				}
				break;
			case DATETIME:
			case TIMESTAMP:
			case TIME:
				enterOuterAlt(_localctx, 7);
				{
				setState(481);
				datetime();
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

	public static class InttypeContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(createParser.INTEGER, 0); }
		public Int_rangeContext int_range() {
			return getRuleContext(Int_rangeContext.class,0);
		}
		public UnsignedContext unsigned() {
			return getRuleContext(UnsignedContext.class,0);
		}
		public InttypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inttype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInttype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInttype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInttype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InttypeContext inttype() throws RecognitionException {
		InttypeContext _localctx = new InttypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_inttype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(INTEGER);
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(485);
				int_range();
				}
			}

			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNSIGNED) {
				{
				setState(488);
				unsigned();
				}
			}

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

	public static class Int_rangeContext extends ParserRuleContext {
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public Int_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInt_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInt_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInt_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_rangeContext int_range() throws RecognitionException {
		Int_rangeContext _localctx = new Int_rangeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_int_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(491);
			match(T__1);
			setState(492);
			match(DIGINT);
			setState(493);
			match(T__2);
			}
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

	public static class UnsignedContext extends ParserRuleContext {
		public TerminalNode UNSIGNED() { return getToken(createParser.UNSIGNED, 0); }
		public UnsignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterUnsigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitUnsigned(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitUnsigned(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsignedContext unsigned() throws RecognitionException {
		UnsignedContext _localctx = new UnsignedContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_unsigned);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(UNSIGNED);
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

	public static class DoubletypeContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(createParser.NUMBER, 0); }
		public Double_rangeContext double_range() {
			return getRuleContext(Double_rangeContext.class,0);
		}
		public DoubletypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubletype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDoubletype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDoubletype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDoubletype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubletypeContext doubletype() throws RecognitionException {
		DoubletypeContext _localctx = new DoubletypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_doubletype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			match(NUMBER);
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(498);
				double_range();
				}
			}

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

	public static class Double_rangeContext extends ParserRuleContext {
		public List<TerminalNode> DIGINT() { return getTokens(createParser.DIGINT); }
		public TerminalNode DIGINT(int i) {
			return getToken(createParser.DIGINT, i);
		}
		public TerminalNode COMMA() { return getToken(createParser.COMMA, 0); }
		public Double_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDouble_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDouble_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDouble_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_rangeContext double_range() throws RecognitionException {
		Double_rangeContext _localctx = new Double_rangeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_double_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(501);
			match(T__1);
			setState(502);
			match(DIGINT);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(503);
				match(COMMA);
				setState(504);
				match(DIGINT);
				}
			}

			setState(507);
			match(T__2);
			}
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

	public static class StringtypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(createParser.STRING, 0); }
		public String_rangeContext string_range() {
			return getRuleContext(String_rangeContext.class,0);
		}
		public StringtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterStringtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitStringtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitStringtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtypeContext stringtype() throws RecognitionException {
		StringtypeContext _localctx = new StringtypeContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_stringtype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(STRING);
			setState(511);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(510);
				string_range();
				}
			}

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

	public static class String_rangeContext extends ParserRuleContext {
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public TerminalNode BYTE() { return getToken(createParser.BYTE, 0); }
		public String_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterString_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitString_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitString_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_rangeContext string_range() throws RecognitionException {
		String_rangeContext _localctx = new String_rangeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_string_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(513);
			match(T__1);
			setState(514);
			match(DIGINT);
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BYTE) {
				{
				setState(515);
				match(BYTE);
				}
			}

			setState(518);
			match(T__2);
			}
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

	public static class LobtypeContext extends ParserRuleContext {
		public TerminalNode BLOB() { return getToken(createParser.BLOB, 0); }
		public LobtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lobtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterLobtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitLobtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitLobtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LobtypeContext lobtype() throws RecognitionException {
		LobtypeContext _localctx = new LobtypeContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_lobtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(BLOB);
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

	public static class BooltypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(createParser.BOOL, 0); }
		public BooltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booltype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterBooltype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitBooltype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitBooltype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooltypeContext booltype() throws RecognitionException {
		BooltypeContext _localctx = new BooltypeContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_booltype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			match(BOOL);
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

	public static class DateContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(createParser.DATE, 0); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_date);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(DATE);
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

	public static class DatetimeContext extends ParserRuleContext {
		public TerminalNode DATETIME() { return getToken(createParser.DATETIME, 0); }
		public TerminalNode TIME() { return getToken(createParser.TIME, 0); }
		public TerminalNode TIMESTAMP() { return getToken(createParser.TIMESTAMP, 0); }
		public Date_rangeContext date_range() {
			return getRuleContext(Date_rangeContext.class,0);
		}
		public DatetimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datetime; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDatetime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDatetime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDatetime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatetimeContext datetime() throws RecognitionException {
		DatetimeContext _localctx = new DatetimeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_datetime);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DATETIME) | (1L << TIMESTAMP) | (1L << TIME))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(528);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(527);
				date_range();
				}
			}

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

	public static class Date_rangeContext extends ParserRuleContext {
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public Date_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDate_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDate_range(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDate_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_rangeContext date_range() throws RecognitionException {
		Date_rangeContext _localctx = new Date_rangeContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_date_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(530);
			match(T__1);
			setState(531);
			match(DIGINT);
			setState(532);
			match(T__2);
			}
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

	public static class DataContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode NULL() { return getToken(createParser.NULL, 0); }
		public DataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataContext data() throws RecognitionException {
		DataContext _localctx = new DataContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_data);
		try {
			setState(539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				integer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				decimal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(536);
				string();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(537);
				bool();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(538);
				match(NULL);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4 || _la==T__5) {
				{
				setState(541);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(544);
			match(DIGINT);
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

	public static class DecimalContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode POINT() { return getToken(createParser.POINT, 0); }
		public TerminalNode DIGINT() { return getToken(createParser.DIGINT, 0); }
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_decimal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			integer();
			setState(547);
			match(POINT);
			setState(548);
			match(DIGINT);
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
		public TerminalNode DIGBOOL() { return getToken(createParser.DIGBOOL, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_bool);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(DIGBOOL);
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

	public static class StringContext extends ParserRuleContext {
		public List<TerminalNode> SINGAL_QUO() { return getTokens(createParser.SINGAL_QUO); }
		public TerminalNode SINGAL_QUO(int i) {
			return getToken(createParser.SINGAL_QUO, i);
		}
		public TerminalNode DIGSTRING() { return getToken(createParser.DIGSTRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(SINGAL_QUO);
			setState(553);
			match(DIGSTRING);
			setState(554);
			match(SINGAL_QUO);
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

	public static class Regular_stringContext extends ParserRuleContext {
		public List<TerminalNode> SINGAL_QUO() { return getTokens(createParser.SINGAL_QUO); }
		public TerminalNode SINGAL_QUO(int i) {
			return getToken(createParser.SINGAL_QUO, i);
		}
		public TerminalNode DIGSTRING() { return getToken(createParser.DIGSTRING, 0); }
		public Regular_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regular_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterRegular_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitRegular_string(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitRegular_string(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Regular_stringContext regular_string() throws RecognitionException {
		Regular_stringContext _localctx = new Regular_stringContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_regular_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(SINGAL_QUO);
			setState(557);
			match(DIGSTRING);
			setState(558);
			match(SINGAL_QUO);
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

	public static class Character_typeContext extends ParserRuleContext {
		public TerminalNode UTF() { return getToken(createParser.UTF, 0); }
		public TerminalNode LATIN() { return getToken(createParser.LATIN, 0); }
		public TerminalNode BIG() { return getToken(createParser.BIG, 0); }
		public TerminalNode GB() { return getToken(createParser.GB, 0); }
		public Character_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_character_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCharacter_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCharacter_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCharacter_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Character_typeContext character_type() throws RecognitionException {
		Character_typeContext _localctx = new Character_typeContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_character_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UTF) | (1L << LATIN) | (1L << BIG) | (1L << GB))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Collate_typeContext extends ParserRuleContext {
		public TerminalNode UTF8CI() { return getToken(createParser.UTF8CI, 0); }
		public TerminalNode LATINCI() { return getToken(createParser.LATINCI, 0); }
		public TerminalNode CHINACI() { return getToken(createParser.CHINACI, 0); }
		public Collate_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collate_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterCollate_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitCollate_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitCollate_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Collate_typeContext collate_type() throws RecognitionException {
		Collate_typeContext _localctx = new Collate_typeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_collate_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UTF8CI) | (1L << LATINCI) | (1L << CHINACI))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Row_formattypeContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(createParser.DEFAULT, 0); }
		public TerminalNode DYNAMIC() { return getToken(createParser.DYNAMIC, 0); }
		public TerminalNode FIXED() { return getToken(createParser.FIXED, 0); }
		public TerminalNode COMPRESSED() { return getToken(createParser.COMPRESSED, 0); }
		public TerminalNode REDUNDANT() { return getToken(createParser.REDUNDANT, 0); }
		public TerminalNode COMPACT() { return getToken(createParser.COMPACT, 0); }
		public Row_formattypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row_formattype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterRow_formattype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitRow_formattype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitRow_formattype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Row_formattypeContext row_formattype() throws RecognitionException {
		Row_formattypeContext _localctx = new Row_formattypeContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_row_formattype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEFAULT) | (1L << DYNAMIC) | (1L << FIXED) | (1L << COMPRESSED) | (1L << REDUNDANT) | (1L << COMPACT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class Binary_comparison_operatorContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(createParser.LT, 0); }
		public TerminalNode LE() { return getToken(createParser.LE, 0); }
		public TerminalNode ST() { return getToken(createParser.ST, 0); }
		public TerminalNode SE() { return getToken(createParser.SE, 0); }
		public TerminalNode EQUAL() { return getToken(createParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(createParser.NOTEQUAL, 0); }
		public Binary_comparison_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_comparison_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterBinary_comparison_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitBinary_comparison_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitBinary_comparison_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_comparison_operatorContext binary_comparison_operator() throws RecognitionException {
		Binary_comparison_operatorContext _localctx = new Binary_comparison_operatorContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_binary_comparison_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_la = _input.LA(1);
			if ( !(((((_la - 112)) & ~0x3f) == 0 && ((1L << (_la - 112)) & ((1L << (LT - 112)) | (1L << (LE - 112)) | (1L << (ST - 112)) | (1L << (SE - 112)) | (1L << (EQUAL - 112)) | (1L << (NOTEQUAL - 112)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class BoolLinkOptionContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(createParser.AND, 0); }
		public TerminalNode OR() { return getToken(createParser.OR, 0); }
		public BoolLinkOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLinkOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).enterBoolLinkOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof createListener ) ((createListener)listener).exitBoolLinkOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof createVisitor ) return ((createVisitor<? extends T>)visitor).visitBoolLinkOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolLinkOptionContext boolLinkOption() throws RecognitionException {
		BoolLinkOptionContext _localctx = new BoolLinkOptionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_boolLinkOption);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3w\u023d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\3\2\7\2\u009c\n\2\f\2\16\2\u009f\13\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00ae\n\4\3\5\3"+
		"\5\3\5\3\5\5\5\u00b4\n\5\7\5\u00b6\n\5\f\5\16\5\u00b9\13\5\3\6\3\6\3\6"+
		"\7\6\u00be\n\6\f\6\16\6\u00c1\13\6\3\6\5\6\u00c4\n\6\3\6\7\6\u00c7\n\6"+
		"\f\6\16\6\u00ca\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d2\n\7\3\b\3\b\3\t"+
		"\3\t\5\t\u00d8\n\t\3\n\3\n\5\n\u00dc\n\n\3\13\3\13\3\13\5\13\u00e1\n\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00f4\n\20\3\21\3\21\3\21\3\21\7\21\u00fa\n\21\f\21\16"+
		"\21\u00fd\13\21\3\21\5\21\u0100\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u010e\n\24\3\25\3\25\5\25\u0112\n\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u012c\n\32\3\32"+
		"\3\32\5\32\u0130\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u0137\n\33\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\5\37\u014d\n\37\3\37\3\37\3 \3 \3 \3 \3 \3 \7"+
		" \u0157\n \f \16 \u015a\13 \3 \3 \3!\3!\3!\3!\3!\3!\7!\u0164\n!\f!\16"+
		"!\u0167\13!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0176\n!\5!\u0178"+
		"\n!\3\"\3\"\3\"\3\"\7\"\u017e\n\"\f\"\16\"\u0181\13\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\5#\u018d\n#\3$\3$\3$\5$\u0192\n$\3%\3%\3%\3%\3&\3&\3"+
		"&\3\'\5\'\u019c\n\'\3(\3(\3(\3)\7)\u01a2\n)\f)\16)\u01a5\13)\3*\3*\3*"+
		"\3*\3*\3*\5*\u01ad\n*\3+\3+\3+\3+\3,\5,\u01b4\n,\3,\3,\3,\3,\3-\5-\u01bb"+
		"\n-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\5\62\u01d3\n\62\3\62\3\62\3\63\3\63\5\63\u01d9\n"+
		"\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\5\65\u01e5\n\65"+
		"\3\66\3\66\5\66\u01e9\n\66\3\66\5\66\u01ec\n\66\3\67\3\67\3\67\3\67\3"+
		"8\38\39\39\59\u01f6\n9\3:\3:\3:\3:\5:\u01fc\n:\3:\3:\3;\3;\5;\u0202\n"+
		";\3<\3<\3<\5<\u0207\n<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\5@\u0213\n@\3A\3"+
		"A\3A\3A\3B\3B\3B\3B\3B\5B\u021e\nB\3C\5C\u0221\nC\3C\3C\3D\3D\3D\3D\3"+
		"E\3E\3F\3F\3F\3F\3G\3G\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3L\3\u01a3"+
		"\2M\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\2\t\3\2\61\63\3\2\7\b\3\29<\3\2=?\4\2\24"+
		"\24\'+\3\2rw\3\2 !\2\u0238\2\u0098\3\2\2\2\4\u00a3\3\2\2\2\6\u00a7\3\2"+
		"\2\2\b\u00af\3\2\2\2\n\u00ba\3\2\2\2\f\u00d1\3\2\2\2\16\u00d3\3\2\2\2"+
		"\20\u00d7\3\2\2\2\22\u00db\3\2\2\2\24\u00e0\3\2\2\2\26\u00e4\3\2\2\2\30"+
		"\u00e6\3\2\2\2\32\u00e8\3\2\2\2\34\u00ea\3\2\2\2\36\u00f3\3\2\2\2 \u00f5"+
		"\3\2\2\2\"\u0103\3\2\2\2$\u0105\3\2\2\2&\u010d\3\2\2\2(\u010f\3\2\2\2"+
		"*\u0113\3\2\2\2,\u0116\3\2\2\2.\u011e\3\2\2\2\60\u0120\3\2\2\2\62\u012b"+
		"\3\2\2\2\64\u0136\3\2\2\2\66\u0138\3\2\2\28\u013b\3\2\2\2:\u013f\3\2\2"+
		"\2<\u014a\3\2\2\2>\u0150\3\2\2\2@\u015d\3\2\2\2B\u0179\3\2\2\2D\u018c"+
		"\3\2\2\2F\u018e\3\2\2\2H\u0193\3\2\2\2J\u0197\3\2\2\2L\u019b\3\2\2\2N"+
		"\u019d\3\2\2\2P\u01a3\3\2\2\2R\u01ac\3\2\2\2T\u01ae\3\2\2\2V\u01b3\3\2"+
		"\2\2X\u01ba\3\2\2\2Z\u01c0\3\2\2\2\\\u01c4\3\2\2\2^\u01c8\3\2\2\2`\u01cc"+
		"\3\2\2\2b\u01cf\3\2\2\2d\u01d8\3\2\2\2f\u01da\3\2\2\2h\u01e4\3\2\2\2j"+
		"\u01e6\3\2\2\2l\u01ed\3\2\2\2n\u01f1\3\2\2\2p\u01f3\3\2\2\2r\u01f7\3\2"+
		"\2\2t\u01ff\3\2\2\2v\u0203\3\2\2\2x\u020a\3\2\2\2z\u020c\3\2\2\2|\u020e"+
		"\3\2\2\2~\u0210\3\2\2\2\u0080\u0214\3\2\2\2\u0082\u021d\3\2\2\2\u0084"+
		"\u0220\3\2\2\2\u0086\u0224\3\2\2\2\u0088\u0228\3\2\2\2\u008a\u022a\3\2"+
		"\2\2\u008c\u022e\3\2\2\2\u008e\u0232\3\2\2\2\u0090\u0234\3\2\2\2\u0092"+
		"\u0236\3\2\2\2\u0094\u0238\3\2\2\2\u0096\u023a\3\2\2\2\u0098\u009d\5\4"+
		"\3\2\u0099\u009a\7\3\2\2\u009a\u009c\5\4\3\2\u009b\u0099\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\3\2\2\u00a1\u00a2\7\2\2\3\u00a2"+
		"\3\3\2\2\2\u00a3\u00a4\7\t\2\2\u00a4\u00a5\5\6\4\2\u00a5\u00a6\5f\64\2"+
		"\u00a6\5\3\2\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\5\24\13\2\u00a9\u00aa"+
		"\7\4\2\2\u00aa\u00ab\5\b\5\2\u00ab\u00ad\7\5\2\2\u00ac\u00ae\5\22\n\2"+
		"\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\7\3\2\2\2\u00af\u00b7\5"+
		"\n\6\2\u00b0\u00b3\7m\2\2\u00b1\u00b4\5\n\6\2\u00b2\u00b4\5\62\32\2\u00b3"+
		"\u00b1\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b0\3\2"+
		"\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\t\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\5\32\16\2\u00bb\u00bf\5h\65"+
		"\2\u00bc\u00be\5\f\7\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c4\5`\61\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c8\3\2"+
		"\2\2\u00c5\u00c7\5\16\b\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\13\3\2\2\2\u00ca\u00c8\3\2\2"+
		"\2\u00cb\u00d2\5&\24\2\u00cc\u00d2\5D#\2\u00cd\u00d2\5F$\2\u00ce\u00d2"+
		"\5\20\t\2\u00cf\u00d2\5J&\2\u00d0\u00d2\5H%\2\u00d1\u00cb\3\2\2\2\u00d1"+
		"\u00cc\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2"+
		"\2\2\u00d1\u00d0\3\2\2\2\u00d2\r\3\2\2\2\u00d3\u00d4\5\u008cG\2\u00d4"+
		"\17\3\2\2\2\u00d5\u00d8\5\"\22\2\u00d6\u00d8\5$\23\2\u00d7\u00d5\3\2\2"+
		"\2\u00d7\u00d6\3\2\2\2\u00d8\21\3\2\2\2\u00d9\u00dc\5L\'\2\u00da\u00dc"+
		"\5P)\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\23\3\2\2\2\u00dd"+
		"\u00de\5\26\f\2\u00de\u00df\7l\2\2\u00df\u00e1\3\2\2\2\u00e0\u00dd\3\2"+
		"\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\5\30\r\2\u00e3"+
		"\25\3\2\2\2\u00e4\u00e5\5\36\20\2\u00e5\27\3\2\2\2\u00e6\u00e7\5\36\20"+
		"\2\u00e7\31\3\2\2\2\u00e8\u00e9\5\36\20\2\u00e9\33\3\2\2\2\u00ea\u00eb"+
		"\5\36\20\2\u00eb\35\3\2\2\2\u00ec\u00f4\7D\2\2\u00ed\u00ee\7C\2\2\u00ee"+
		"\u00ef\7D\2\2\u00ef\u00f4\7C\2\2\u00f0\u00f1\7B\2\2\u00f1\u00f2\7D\2\2"+
		"\u00f2\u00f4\7B\2\2\u00f3\u00ec\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f3\u00f0"+
		"\3\2\2\2\u00f4\37\3\2\2\2\u00f5\u00f6\7\4\2\2\u00f6\u00ff\7F\2\2\u00f7"+
		"\u00f8\7m\2\2\u00f8\u00fa\7F\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\3\2\2"+
		"\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0100\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fe\u0100\7\67\2\2\u00ff\u00fb\3\2\2\2\u00ff\u00fe\3\2\2\2"+
		"\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\5\2\2\u0102!\3"+
		"\2\2\2\u0103\u0104\7\f\2\2\u0104#\3\2\2\2\u0105\u0106\7\13\2\2\u0106\u0107"+
		"\7\f\2\2\u0107%\3\2\2\2\u0108\u010e\5(\25\2\u0109\u010e\5*\26\2\u010a"+
		"\u010e\5,\27\2\u010b\u010e\5.\30\2\u010c\u010e\5\60\31\2\u010d\u0108\3"+
		"\2\2\2\u010d\u0109\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e\'\3\2\2\2\u010f\u0111\7\20\2\2\u0110\u0112\7\17\2"+
		"\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112)\3\2\2\2\u0113\u0114"+
		"\7\r\2\2\u0114\u0115\7\17\2\2\u0115+\3\2\2\2\u0116\u0117\7\16\2\2\u0117"+
		"\u0118\7\17\2\2\u0118\u0119\7\"\2\2\u0119\u011a\5\24\13\2\u011a\u011b"+
		"\7\4\2\2\u011b\u011c\5\32\16\2\u011c\u011d\7\5\2\2\u011d-\3\2\2\2\u011e"+
		"\u011f\7\17\2\2\u011f/\3\2\2\2\u0120\u0121\7\21\2\2\u0121\u0122\5@!\2"+
		"\u0122\61\3\2\2\2\u0123\u0124\7\22\2\2\u0124\u0125\5\34\17\2\u0125\u0126"+
		"\3\2\2\2\u0126\u0127\5\64\33\2\u0127\u012c\3\2\2\2\u0128\u0129\5\64\33"+
		"\2\u0129\u012a\5\34\17\2\u012a\u012c\3\2\2\2\u012b\u0123\3\2\2\2\u012b"+
		"\u0128\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012e\7,\2\2\u012e\u0130\7-\2"+
		"\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\63\3\2\2\2\u0131\u0137"+
		"\5\66\34\2\u0132\u0137\5> \2\u0133\u0137\5:\36\2\u0134\u0137\5<\37\2\u0135"+
		"\u0137\58\35\2\u0136\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0136\u0133\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137\65\3\2\2\2\u0138\u0139"+
		"\7\17\2\2\u0139\u013a\5B\"\2\u013a\67\3\2\2\2\u013b\u013c\7\r\2\2\u013c"+
		"\u013d\7\17\2\2\u013d\u013e\5B\"\2\u013e9\3\2\2\2\u013f\u0140\7\16\2\2"+
		"\u0140\u0141\7\17\2\2\u0141\u0142\7\4\2\2\u0142\u0143\5\32\16\2\u0143"+
		"\u0144\7\5\2\2\u0144\u0145\7\"\2\2\u0145\u0146\5\24\13\2\u0146\u0147\7"+
		"\4\2\2\u0147\u0148\5\32\16\2\u0148\u0149\7\5\2\2\u0149;\3\2\2\2\u014a"+
		"\u014c\7\20\2\2\u014b\u014d\7\17\2\2\u014c\u014b\3\2\2\2\u014c\u014d\3"+
		"\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\5B\"\2\u014f=\3\2\2\2\u0150\u0151"+
		"\7\21\2\2\u0151\u0152\7\4\2\2\u0152\u0158\5@!\2\u0153\u0154\5\u0096L\2"+
		"\u0154\u0155\5@!\2\u0155\u0157\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u015a"+
		"\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015b\u015c\7\5\2\2\u015c?\3\2\2\2\u015d\u0177\5\32\16"+
		"\2\u015e\u015f\7\35\2\2\u015f\u0160\7\4\2\2\u0160\u0165\5\u0082B\2\u0161"+
		"\u0162\7m\2\2\u0162\u0164\5\u0082B\2\u0163\u0161\3\2\2\2\u0164\u0167\3"+
		"\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0168\3\2\2\2\u0167"+
		"\u0165\3\2\2\2\u0168\u0169\7\5\2\2\u0169\u0178\3\2\2\2\u016a\u016b\5\u0094"+
		"K\2\u016b\u016c\5d\63\2\u016c\u0178\3\2\2\2\u016d\u016e\7\37\2\2\u016e"+
		"\u016f\5\u0082B\2\u016f\u0170\7 \2\2\u0170\u0171\5\u0082B\2\u0171\u0178"+
		"\3\2\2\2\u0172\u0175\7\36\2\2\u0173\u0176\5\"\22\2\u0174\u0176\5$\23\2"+
		"\u0175\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u015e"+
		"\3\2\2\2\u0177\u016a\3\2\2\2\u0177\u016d\3\2\2\2\u0177\u0172\3\2\2\2\u0178"+
		"A\3\2\2\2\u0179\u017a\7\4\2\2\u017a\u017f\5\32\16\2\u017b\u017c\7m\2\2"+
		"\u017c\u017e\5\32\16\2\u017d\u017b\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d"+
		"\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0183\7\5\2\2\u0183C\3\2\2\2\u0184\u018d\7\25\2\2\u0185\u018d\7\26\2"+
		"\2\u0186\u0187\7\27\2\2\u0187\u0188\7\4\2\2\u0188\u0189\7F\2\2\u0189\u018a"+
		"\7m\2\2\u018a\u018b\7F\2\2\u018b\u018d\7\5\2\2\u018c\u0184\3\2\2\2\u018c"+
		"\u0185\3\2\2\2\u018c\u0186\3\2\2\2\u018dE\3\2\2\2\u018e\u018f\7\24\2\2"+
		"\u018f\u0191\5d\63\2\u0190\u0192\5^\60\2\u0191\u0190\3\2\2\2\u0191\u0192"+
		"\3\2\2\2\u0192G\3\2\2\2\u0193\u0194\7\31\2\2\u0194\u0195\7\32\2\2\u0195"+
		"\u0196\5\u008eH\2\u0196I\3\2\2\2\u0197\u0198\7\30\2\2\u0198\u0199\5\u0090"+
		"I\2\u0199K\3\2\2\2\u019a\u019c\5N(\2\u019b\u019a\3\2\2\2\u019b\u019c\3"+
		"\2\2\2\u019cM\3\2\2\2\u019d\u019e\7\23\2\2\u019e\u019f\5\26\f\2\u019f"+
		"O\3\2\2\2\u01a0\u01a2\5R*\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3"+
		"\u01a4\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4Q\3\2\2\2\u01a5\u01a3\3\2\2\2"+
		"\u01a6\u01ad\5T+\2\u01a7\u01ad\5`\61\2\u01a8\u01ad\5V,\2\u01a9\u01ad\5"+
		"X-\2\u01aa\u01ad\5Z.\2\u01ab\u01ad\5\\/\2\u01ac\u01a6\3\2\2\2\u01ac\u01a7"+
		"\3\2\2\2\u01ac\u01a8\3\2\2\2\u01ac\u01a9\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ab\3\2\2\2\u01adS\3\2\2\2\u01ae\u01af\7$\2\2\u01af\u01b0\7\6\2\2\u01b0"+
		"\u01b1\5\36\20\2\u01b1U\3\2\2\2\u01b2\u01b4\7\24\2\2\u01b3\u01b2\3\2\2"+
		"\2\u01b3\u01b4\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b6\7%\2\2\u01b6\u01b7"+
		"\7\6\2\2\u01b7\u01b8\5\u008eH\2\u01b8W\3\2\2\2\u01b9\u01bb\7\24\2\2\u01ba"+
		"\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\7\30"+
		"\2\2\u01bd\u01be\7\6\2\2\u01be\u01bf\5\u0090I\2\u01bfY\3\2\2\2\u01c0\u01c1"+
		"\7&\2\2\u01c1\u01c2\7\6\2\2\u01c2\u01c3\5\u0092J\2\u01c3[\3\2\2\2\u01c4"+
		"\u01c5\7\26\2\2\u01c5\u01c6\7\6\2\2\u01c6\u01c7\5\u0084C\2\u01c7]\3\2"+
		"\2\2\u01c8\u01c9\7\33\2\2\u01c9\u01ca\7\34\2\2\u01ca\u01cb\5d\63\2\u01cb"+
		"_\3\2\2\2\u01cc\u01cd\7#\2\2\u01cd\u01ce\5\u008aF\2\u01cea\3\2\2\2\u01cf"+
		"\u01d0\7D\2\2\u01d0\u01d2\7\4\2\2\u01d1\u01d3\5\u0082B\2\u01d2\u01d1\3"+
		"\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d5\7\5\2\2\u01d5"+
		"c\3\2\2\2\u01d6\u01d9\5\u0082B\2\u01d7\u01d9\5b\62\2\u01d8\u01d6\3\2\2"+
		"\2\u01d8\u01d7\3\2\2\2\u01d9e\3\2\2\2\u01da\u01db\7E\2\2\u01db\u01dc\7"+
		"F\2\2\u01dcg\3\2\2\2\u01dd\u01e5\5j\66\2\u01de\u01e5\5p9\2\u01df\u01e5"+
		"\5t;\2\u01e0\u01e5\5z>\2\u01e1\u01e5\5|?\2\u01e2\u01e5\5x=\2\u01e3\u01e5"+
		"\5~@\2\u01e4\u01dd\3\2\2\2\u01e4\u01de\3\2\2\2\u01e4\u01df\3\2\2\2\u01e4"+
		"\u01e0\3\2\2\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4\u01e3\3\2"+
		"\2\2\u01e5i\3\2\2\2\u01e6\u01e8\7\64\2\2\u01e7\u01e9\5l\67\2\u01e8\u01e7"+
		"\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01ec\5n8\2\u01eb"+
		"\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01eck\3\2\2\2\u01ed\u01ee\7\4\2\2"+
		"\u01ee\u01ef\7F\2\2\u01ef\u01f0\7\5\2\2\u01f0m\3\2\2\2\u01f1\u01f2\7."+
		"\2\2\u01f2o\3\2\2\2\u01f3\u01f5\7\65\2\2\u01f4\u01f6\5r:\2\u01f5\u01f4"+
		"\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6q\3\2\2\2\u01f7\u01f8\7\4\2\2\u01f8"+
		"\u01fb\7F\2\2\u01f9\u01fa\7m\2\2\u01fa\u01fc\7F\2\2\u01fb\u01f9\3\2\2"+
		"\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\7\5\2\2\u01fes"+
		"\3\2\2\2\u01ff\u0201\7\66\2\2\u0200\u0202\5v<\2\u0201\u0200\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202u\3\2\2\2\u0203\u0204\7\4\2\2\u0204\u0206\7F\2\2\u0205"+
		"\u0207\7\67\2\2\u0206\u0205\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u0208\3"+
		"\2\2\2\u0208\u0209\7\5\2\2\u0209w\3\2\2\2\u020a\u020b\78\2\2\u020by\3"+
		"\2\2\2\u020c\u020d\7/\2\2\u020d{\3\2\2\2\u020e\u020f\7\60\2\2\u020f}\3"+
		"\2\2\2\u0210\u0212\t\2\2\2\u0211\u0213\5\u0080A\2\u0212\u0211\3\2\2\2"+
		"\u0212\u0213\3\2\2\2\u0213\177\3\2\2\2\u0214\u0215\7\4\2\2\u0215\u0216"+
		"\7F\2\2\u0216\u0217\7\5\2\2\u0217\u0081\3\2\2\2\u0218\u021e\5\u0084C\2"+
		"\u0219\u021e\5\u0086D\2\u021a\u021e\5\u008aF\2\u021b\u021e\5\u0088E\2"+
		"\u021c\u021e\7\f\2\2\u021d\u0218\3\2\2\2\u021d\u0219\3\2\2\2\u021d\u021a"+
		"\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021c\3\2\2\2\u021e\u0083\3\2\2\2\u021f"+
		"\u0221\t\3\2\2\u0220\u021f\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2"+
		"\2\2\u0222\u0223\7F\2\2\u0223\u0085\3\2\2\2\u0224\u0225\5\u0084C\2\u0225"+
		"\u0226\7l\2\2\u0226\u0227\7F\2\2\u0227\u0087\3\2\2\2\u0228\u0229\7@\2"+
		"\2\u0229\u0089\3\2\2\2\u022a\u022b\7G\2\2\u022b\u022c\7A\2\2\u022c\u022d"+
		"\7G\2\2\u022d\u008b\3\2\2\2\u022e\u022f\7G\2\2\u022f\u0230\7A\2\2\u0230"+
		"\u0231\7G\2\2\u0231\u008d\3\2\2\2\u0232\u0233\t\4\2\2\u0233\u008f\3\2"+
		"\2\2\u0234\u0235\t\5\2\2\u0235\u0091\3\2\2\2\u0236\u0237\t\6\2\2\u0237"+
		"\u0093\3\2\2\2\u0238\u0239\t\7\2\2\u0239\u0095\3\2\2\2\u023a\u023b\t\b"+
		"\2\2\u023b\u0097\3\2\2\2.\u009d\u00ad\u00b3\u00b7\u00bf\u00c3\u00c8\u00d1"+
		"\u00d7\u00db\u00e0\u00f3\u00fb\u00ff\u010d\u0111\u012b\u012f\u0136\u014c"+
		"\u0158\u0165\u0175\u0177\u017f\u018c\u0191\u019b\u01a3\u01ac\u01b3\u01ba"+
		"\u01d2\u01d8\u01e4\u01e8\u01eb\u01f5\u01fb\u0201\u0206\u0212\u021d\u0220";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}