// Generated from org/apache/skywalking/oal/tool/grammar/OALParser.g4 by ANTLR 4.7.1
package org.apache.skywalking.oal.tool.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OALParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FROM=1, FILTER=2, SRC_ALL=3, SRC_SERVICE=4, SRC_SERVICE_INSTANCE=5, SRC_ENDPOINT=6, 
		SRC_SERVICE_RELATION=7, SRC_SERVICE_INSTANCE_RELATION=8, SRC_ENDPOINT_RELATION=9, 
		SRC_SERVICE_INSTANCE_JVM_CPU=10, SRC_SERVICE_INSTANCE_JVM_MEMORY=11, SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL=12, 
		DECIMAL_LITERAL=13, BOOL_LITERAL=14, CHAR_LITERAL=15, STRING_LITERAL=16, 
		DelimitedComment=17, LineComment=18, SPACE=19, IDENTIFIER=20, DOT=21, 
		LR_BRACKET=22, RR_BRACKET=23, COMMA=24, SEMI=25, EQUAL=26;
	public static final int
		RULE_root = 0, RULE_aggregationStatement = 1, RULE_metricStatement = 2, 
		RULE_source = 3, RULE_variable = 4, RULE_aggregateFunction = 5, RULE_functionName = 6, 
		RULE_filterExpression = 7;
	public static final String[] ruleNames = {
		"root", "aggregationStatement", "metricStatement", "source", "variable", 
		"aggregateFunction", "functionName", "filterExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'from'", "'filter'", "'All'", "'Service'", "'ServiceInstance'", 
		"'Endpoint'", "'ServiceRelation'", "'ServiceInstanceRelation'", "'EndpointRelation'", 
		null, null, "'ServiceInstance_JVM_Memory_Pool'", null, null, null, null, 
		null, null, null, null, "'.'", "'('", "')'", "','", "';'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FROM", "FILTER", "SRC_ALL", "SRC_SERVICE", "SRC_SERVICE_INSTANCE", 
		"SRC_ENDPOINT", "SRC_SERVICE_RELATION", "SRC_SERVICE_INSTANCE_RELATION", 
		"SRC_ENDPOINT_RELATION", "SRC_SERVICE_INSTANCE_JVM_CPU", "SRC_SERVICE_INSTANCE_JVM_MEMORY", 
		"SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL", "DECIMAL_LITERAL", "BOOL_LITERAL", 
		"CHAR_LITERAL", "STRING_LITERAL", "DelimitedComment", "LineComment", "SPACE", 
		"IDENTIFIER", "DOT", "LR_BRACKET", "RR_BRACKET", "COMMA", "SEMI", "EQUAL"
	};
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
	public String getGrammarFileName() { return "OALParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OALParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public List<AggregationStatementContext> aggregationStatement() {
			return getRuleContexts(AggregationStatementContext.class);
		}
		public AggregationStatementContext aggregationStatement(int i) {
			return getRuleContext(AggregationStatementContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(16);
				aggregationStatement();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class AggregationStatementContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(OALParser.EQUAL, 0); }
		public MetricStatementContext metricStatement() {
			return getRuleContext(MetricStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(OALParser.SEMI, 0); }
		public TerminalNode EOF() { return getToken(OALParser.EOF, 0); }
		public List<TerminalNode> SPACE() { return getTokens(OALParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(OALParser.SPACE, i);
		}
		public TerminalNode DelimitedComment() { return getToken(OALParser.DelimitedComment, 0); }
		public TerminalNode LineComment() { return getToken(OALParser.LineComment, 0); }
		public AggregationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterAggregationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitAggregationStatement(this);
		}
	}

	public final AggregationStatementContext aggregationStatement() throws RecognitionException {
		AggregationStatementContext _localctx = new AggregationStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aggregationStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			variable();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(23);
				match(SPACE);
				}
			}

			setState(26);
			match(EQUAL);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(27);
				match(SPACE);
				}
			}

			setState(30);
			metricStatement();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DelimitedComment) {
				{
				setState(31);
				match(DelimitedComment);
				}
			}

			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LineComment) {
				{
				setState(34);
				match(LineComment);
				}
			}

			setState(37);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==SEMI) ) {
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

	public static class MetricStatementContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(OALParser.FROM, 0); }
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(OALParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(OALParser.DOT, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public MetricStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterMetricStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitMetricStatement(this);
		}
	}

	public final MetricStatementContext metricStatement() throws RecognitionException {
		MetricStatementContext _localctx = new MetricStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_metricStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(FROM);
			setState(40);
			match(LR_BRACKET);
			setState(41);
			source();
			setState(42);
			match(DOT);
			setState(43);
			match(IDENTIFIER);
			setState(44);
			match(RR_BRACKET);
			setState(45);
			match(DOT);
			setState(46);
			aggregateFunction();
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

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode SRC_ALL() { return getToken(OALParser.SRC_ALL, 0); }
		public TerminalNode SRC_SERVICE() { return getToken(OALParser.SRC_SERVICE, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE() { return getToken(OALParser.SRC_SERVICE_INSTANCE, 0); }
		public TerminalNode SRC_ENDPOINT() { return getToken(OALParser.SRC_ENDPOINT, 0); }
		public TerminalNode SRC_SERVICE_RELATION() { return getToken(OALParser.SRC_SERVICE_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_RELATION() { return getToken(OALParser.SRC_SERVICE_INSTANCE_RELATION, 0); }
		public TerminalNode SRC_ENDPOINT_RELATION() { return getToken(OALParser.SRC_ENDPOINT_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_CPU() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_CPU, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_source);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SRC_ALL) | (1L << SRC_SERVICE) | (1L << SRC_SERVICE_INSTANCE) | (1L << SRC_ENDPOINT) | (1L << SRC_SERVICE_RELATION) | (1L << SRC_SERVICE_INSTANCE_RELATION) | (1L << SRC_ENDPOINT_RELATION) | (1L << SRC_SERVICE_INSTANCE_JVM_CPU) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL))) != 0)) ) {
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(IDENTIFIER);
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

	public static class AggregateFunctionContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public TerminalNode LR_BRACKET() { return getToken(OALParser.LR_BRACKET, 0); }
		public TerminalNode RR_BRACKET() { return getToken(OALParser.RR_BRACKET, 0); }
		public FilterExpressionContext filterExpression() {
			return getRuleContext(FilterExpressionContext.class,0);
		}
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterAggregateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitAggregateFunction(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_aggregateFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			functionName();
			setState(53);
			match(LR_BRACKET);
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(54);
				filterExpression();
				}
				break;
			}
			setState(57);
			match(RR_BRACKET);
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

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFunctionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFunctionName(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IDENTIFIER);
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

	public static class FilterExpressionContext extends ParserRuleContext {
		public FilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitFilterExpression(this);
		}
	}

	public final FilterExpressionContext filterExpression() throws RecognitionException {
		FilterExpressionContext _localctx = new FilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_filterExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34B\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\3\3\3\5\3\33\n\3\3\3\3\3\5\3\37\n\3\3\3\3\3\5\3#\n\3\3"+
		"\3\5\3&\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\7\5\7:\n\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f"+
		"\16\20\2\4\3\3\33\33\3\2\5\16\2?\2\25\3\2\2\2\4\30\3\2\2\2\6)\3\2\2\2"+
		"\b\62\3\2\2\2\n\64\3\2\2\2\f\66\3\2\2\2\16=\3\2\2\2\20?\3\2\2\2\22\24"+
		"\5\4\3\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3"+
		"\3\2\2\2\27\25\3\2\2\2\30\32\5\n\6\2\31\33\7\25\2\2\32\31\3\2\2\2\32\33"+
		"\3\2\2\2\33\34\3\2\2\2\34\36\7\34\2\2\35\37\7\25\2\2\36\35\3\2\2\2\36"+
		"\37\3\2\2\2\37 \3\2\2\2 \"\5\6\4\2!#\7\23\2\2\"!\3\2\2\2\"#\3\2\2\2#%"+
		"\3\2\2\2$&\7\24\2\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\t\2\2\2(\5\3\2\2"+
		"\2)*\7\3\2\2*+\7\30\2\2+,\5\b\5\2,-\7\27\2\2-.\7\26\2\2./\7\31\2\2/\60"+
		"\7\27\2\2\60\61\5\f\7\2\61\7\3\2\2\2\62\63\t\3\2\2\63\t\3\2\2\2\64\65"+
		"\7\26\2\2\65\13\3\2\2\2\66\67\5\16\b\2\679\7\30\2\28:\5\20\t\298\3\2\2"+
		"\29:\3\2\2\2:;\3\2\2\2;<\7\31\2\2<\r\3\2\2\2=>\7\26\2\2>\17\3\2\2\2?@"+
		"\3\2\2\2@\21\3\2\2\2\b\25\32\36\"%9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}