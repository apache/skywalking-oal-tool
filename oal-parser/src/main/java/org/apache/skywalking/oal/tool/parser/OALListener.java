/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oal.tool.parser;

import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.skywalking.oal.tool.grammar.OALParser;
import org.apache.skywalking.oal.tool.grammar.OALParserBaseListener;

public class OALListener extends OALParserBaseListener {
    private List<AnalysisResult> results;
    private AnalysisResult current;

    public OALListener(List<AnalysisResult> results) {
        this.results = results;
    }

    @Override
    public void enterAggregationStatement(@NotNull OALParser.AggregationStatementContext ctx) {
        current = new AnalysisResult();
    }

    @Override
    public void exitAggregationStatement(@NotNull OALParser.AggregationStatementContext ctx) {
        results.add(current);
        current = null;
    }

    @Override public void enterVariable(OALParser.VariableContext ctx) {
    }

    @Override public void exitVariable(OALParser.VariableContext ctx) {
        current.setMetricName(ctx.getText());
    }
}
