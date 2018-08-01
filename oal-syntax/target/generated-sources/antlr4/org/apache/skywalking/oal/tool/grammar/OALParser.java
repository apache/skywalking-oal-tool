// Generated from org/apache/skywalking/oal/tool/grammar/OALParser.g4 by ANTLR 4.3
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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=23, FILTER=2, SRC_ALL=3, DOT=20, SEMI=24, SRC_SERVICE_INSTANCE=5, 
		SRC_SERVICE_INSTANCE_JVM_MEMORY=11, LineComment=18, LR_BRACKET=21, FROM=1, 
		SRC_SERVICE_INSTANCE_JVM_CPU=10, DelimitedComment=17, SRC_SERVICE=4, SRC_SERVICE_RELATION=7, 
		BOOL_LITERAL=14, SRC_ENDPOINT_RELATION=9, SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL=12, 
		SRC_ENDPOINT=6, RR_BRACKET=22, SRC_SERVICE_INSTANCE_RELATION=8, STRING_LITERAL=16, 
		CHAR_LITERAL=15, IDENTIFIER=19, DECIMAL_LITERAL=13;
	public static final String[] tokenNames = {
		"<INVALID>", "'from'", "'filter'", "'All'", "'Service'", "'ServiceInstance'", 
		"'Endpoint'", "'ServiceRelation'", "'ServiceInstanceRelation'", "'EndpointRelation'", 
		"SRC_SERVICE_INSTANCE_JVM_CPU", "SRC_SERVICE_INSTANCE_JVM_MEMORY", "'ServiceInstance_JVM_Memory_Pool'", 
		"DECIMAL_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", "DelimitedComment", 
		"LineComment", "IDENTIFIER", "'.'", "'('", "')'", "','", "';'"
	};
	public static final int
		RULE_root = 0, RULE_metricStatements = 1, RULE_metricStatement = 2, RULE_source = 3;
	public static final String[] ruleNames = {
		"root", "metricStatements", "metricStatement", "source"
	};

	@Override
	public String getGrammarFileName() { return "OALParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode EOF() { return getToken(OALParser.EOF, 0); }
		public MetricStatementsContext metricStatements() {
			return getRuleContext(MetricStatementsContext.class,0);
		}
		public TerminalNode DelimitedComment() { return getToken(OALParser.DelimitedComment, 0); }
		public TerminalNode LineComment() { return getToken(OALParser.LineComment, 0); }
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
			setState(9);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(8); metricStatements();
				}
				break;
			}
			setState(12);
			_la = _input.LA(1);
			if (_la==DelimitedComment) {
				{
				setState(11); match(DelimitedComment);
				}
			}

			setState(15);
			_la = _input.LA(1);
			if (_la==LineComment) {
				{
				setState(14); match(LineComment);
				}
			}

			setState(17); match(EOF);
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

	public static class MetricStatementsContext extends ParserRuleContext {
		public List<MetricStatementContext> metricStatement() {
			return getRuleContexts(MetricStatementContext.class);
		}
		public MetricStatementContext metricStatement(int i) {
			return getRuleContext(MetricStatementContext.class,i);
		}
		public MetricStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metricStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).enterMetricStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OALParserListener ) ((OALParserListener)listener).exitMetricStatements(this);
		}
	}

	public final MetricStatementsContext metricStatements() throws RecognitionException {
		MetricStatementsContext _localctx = new MetricStatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_metricStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FROM) {
				{
				{
				setState(19); metricStatement();
				}
				}
				setState(24);
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

	public static class MetricStatementContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TerminalNode FROM() { return getToken(OALParser.FROM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(OALParser.IDENTIFIER, 0); }
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
			setState(25); match(FROM);
			setState(26); match(LR_BRACKET);
			setState(27); source();
			setState(28); match(DOT);
			setState(29); match(IDENTIFIER);
			setState(30); match(RR_BRACKET);
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
		public TerminalNode SRC_ENDPOINT() { return getToken(OALParser.SRC_ENDPOINT, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_CPU() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_CPU, 0); }
		public TerminalNode SRC_SERVICE_RELATION() { return getToken(OALParser.SRC_SERVICE_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_RELATION() { return getToken(OALParser.SRC_SERVICE_INSTANCE_RELATION, 0); }
		public TerminalNode SRC_ENDPOINT_RELATION() { return getToken(OALParser.SRC_ENDPOINT_RELATION, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE_JVM_MEMORY() { return getToken(OALParser.SRC_SERVICE_INSTANCE_JVM_MEMORY, 0); }
		public TerminalNode SRC_SERVICE_INSTANCE() { return getToken(OALParser.SRC_SERVICE_INSTANCE, 0); }
		public TerminalNode SRC_ALL() { return getToken(OALParser.SRC_ALL, 0); }
		public TerminalNode SRC_SERVICE() { return getToken(OALParser.SRC_SERVICE, 0); }
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
			setState(32);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SRC_ALL) | (1L << SRC_SERVICE) | (1L << SRC_SERVICE_INSTANCE) | (1L << SRC_ENDPOINT) | (1L << SRC_SERVICE_RELATION) | (1L << SRC_SERVICE_INSTANCE_RELATION) | (1L << SRC_ENDPOINT_RELATION) | (1L << SRC_SERVICE_INSTANCE_JVM_CPU) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY) | (1L << SRC_SERVICE_INSTANCE_JVM_MEMORY_POOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32%\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\5\2\f\n\2\3\2\5\2\17\n\2\3\2\5\2\22\n\2\3\2\3\2"+
		"\3\3\7\3\27\n\3\f\3\16\3\32\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\2\2\6\2\4\6\b\2\3\3\2\5\16$\2\13\3\2\2\2\4\30\3\2\2\2\6\33\3\2\2\2"+
		"\b\"\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\13\f\3\2\2\2\f\16\3\2\2\2\r\17\7"+
		"\23\2\2\16\r\3\2\2\2\16\17\3\2\2\2\17\21\3\2\2\2\20\22\7\24\2\2\21\20"+
		"\3\2\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\24\7\2\2\3\24\3\3\2\2\2\25\27"+
		"\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\5"+
		"\3\2\2\2\32\30\3\2\2\2\33\34\7\3\2\2\34\35\7\27\2\2\35\36\5\b\5\2\36\37"+
		"\7\26\2\2\37 \7\25\2\2 !\7\30\2\2!\7\3\2\2\2\"#\t\2\2\2#\t\3\2\2\2\6\13"+
		"\16\21\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}