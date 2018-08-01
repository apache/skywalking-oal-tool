// Generated from org/apache/skywalking/oal/tool/grammar/OALParser.g4 by ANTLR 4.3
package org.apache.skywalking.oal.tool.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OALParser}.
 */
public interface OALParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OALParser#metricStatements}.
	 * @param ctx the parse tree
	 */
	void enterMetricStatements(@NotNull OALParser.MetricStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#metricStatements}.
	 * @param ctx the parse tree
	 */
	void exitMetricStatements(@NotNull OALParser.MetricStatementsContext ctx);

	/**
	 * Enter a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull OALParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull OALParser.RootContext ctx);

	/**
	 * Enter a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void enterMetricStatement(@NotNull OALParser.MetricStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#metricStatement}.
	 * @param ctx the parse tree
	 */
	void exitMetricStatement(@NotNull OALParser.MetricStatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(@NotNull OALParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OALParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(@NotNull OALParser.SourceContext ctx);
}