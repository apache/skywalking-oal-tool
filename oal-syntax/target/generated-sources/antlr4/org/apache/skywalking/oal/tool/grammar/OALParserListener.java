// Generated from org/apache/skywalking/oal/tool/grammar/OALParser.g4 by ANTLR 4.7.1
package org.apache.skywalking.oal.tool.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OALParser}.
 */
public interface OALParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OALParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OALParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#aggregationStatement}.
	 * @param ctx the parse tree
	 */
	void enterAggregationStatement(OALParser.AggregationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#aggregationStatement}.
	 * @param ctx the parse tree
	 */
	void exitAggregationStatement(OALParser.AggregationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void enterMetricStatement(OALParser.MetricStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void exitMetricStatement(OALParser.MetricStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(OALParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(OALParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(OALParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(OALParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(OALParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(OALParser.AggregateFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(OALParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(OALParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link OALParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpression(OALParser.FilterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#filterExpression}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpression(OALParser.FilterExpressionContext ctx);
}