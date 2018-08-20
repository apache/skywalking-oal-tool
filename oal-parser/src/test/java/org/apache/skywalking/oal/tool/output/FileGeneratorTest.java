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

package org.apache.skywalking.oal.tool.output;

import freemarker.template.TemplateException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import org.apache.skywalking.oal.tool.parser.AnalysisResult;
import org.apache.skywalking.oal.tool.parser.EntryMethod;
import org.apache.skywalking.oal.tool.parser.SourceColumnsFactory;
import org.junit.Assert;
import org.junit.Test;

public class FileGeneratorTest {
    private AnalysisResult buildResult() {
        AnalysisResult result = new AnalysisResult();
        result.setSourceName("Service");
        result.setPackageName("service.serviceavg");
        result.setTableName("service_avg");
        result.setSourceAttribute("latency");
        result.setMetricName("ServiceAvg");
        result.setAggregationFunctionName("avg");
        result.setIndicatorClassName("LongAvgIndicator");
        EntryMethod method = new EntryMethod();
        method.setMethodName("combine");
        method.setArgsExpressions(new LinkedList<>());
        method.getArgsExpressions().add("source.getLatency()");
        method.getArgsExpressions().add("1");
        result.setEntryMethod(method);
        result.addPersistentField("summation", "summation", long.class);
        result.addPersistentField("count", "count", int.class);
        result.addPersistentField("value", "value", long.class);
        result.addPersistentField("timeBucket", "time_bucket", long.class);
        result.addPersistentField("stringField", "string_field", String.class);
        result.setFieldsFromSource(SourceColumnsFactory.getColumns("Service"));
        result.generateSerializeFields();

        return result;
    }

    @Test
    public void testGenerateIndicatorImplementor() throws IOException, TemplateException {
        AnalysisResult result = buildResult();

        List<AnalysisResult> results = new LinkedList<>();
        results.add(result);

        FileGenerator fileGenerator = new FileGenerator(results, ".");
        StringWriter writer = new StringWriter();
        fileGenerator.generateIndicatorImplementor(result, writer);
        Assert.assertEquals(readExpectedFile("IndicatorImplementorExpected.java"), writer.toString());

        //fileGenerator.generateIndicatorImplementor(result, new OutputStreamWriter(System.out));
    }

    @Test
    public void testServiceDispatcher() throws IOException, TemplateException {
        AnalysisResult result = buildResult();

        List<AnalysisResult> results = new LinkedList<>();
        results.add(result);

        FileGenerator fileGenerator = new FileGenerator(results, ".");
        StringWriter writer = new StringWriter();
        fileGenerator.generateServiceDispatcher(writer);
        Assert.assertEquals(readExpectedFile("ServiceDispatcherExpected.java"), writer.toString());

        //fileGenerator.generateServiceDispatcher(new OutputStreamWriter(System.out));
    }

    private String readExpectedFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(FileGenerator.class.getResourceAsStream("/expectedFiles/" + filename)));

        StringBuilder fileContent = new StringBuilder();
        String sCurrentLine;

        while ((sCurrentLine = reader.readLine()) != null) {
            fileContent.append(sCurrentLine).append("\n");
        }

        return fileContent.toString();
    }
}
