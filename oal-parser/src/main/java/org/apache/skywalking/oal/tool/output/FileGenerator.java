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

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Locale;
import org.apache.skywalking.oal.tool.parser.AnalysisResult;

public class FileGenerator {
    private List<AnalysisResult> results;
    private String outputPath;
    private Configuration configuration;
    private DispatcherContext dispatcherContext;

    public FileGenerator(List<AnalysisResult> results, String outputPath) {
        this.results = results;
        this.outputPath = outputPath;
        configuration = new Configuration(new Version("2.3.28"));
        configuration.setEncoding(Locale.ENGLISH, "UTF-8");
        configuration.setClassLoaderForTemplateLoading(FileGenerator.class.getClassLoader(), "/code-templates");
        this.toDispatchers();
    }

    public void generate() throws IOException, TemplateException {
        for (AnalysisResult result : results) {
            generate(result, "AggregateWorker.java", (writer) -> generateAggregateWorker(result, writer));
            generate(result, "Indicator.java", (writer) -> generateIndicatorImplementor(result, writer));
            generate(result, "PersistentWorker.java", (writer) -> generatePersistentWorker(result, writer));
            generate(result, "RemoteWorker.java", (writer) -> generateRemoteWorker(result, writer));
        }

        File file = new File(outputPath, "generated/service/ServiceDispatcher.java");
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        this.generateServiceDispatcher(new FileWriter(file));
    }



    private void generate(AnalysisResult result, String fileSuffix,
        WriteWrapper writeWrapper) throws IOException, TemplateException {
        File file = new File(outputPath, buildSubFolderName(result, fileSuffix));
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        try {
            writeWrapper.execute(fileWriter);
        } finally {
            fileWriter.close();
        }
    }

    private String buildSubFolderName(AnalysisResult result, String suffix) {
        return "generated/"
            + result.getSourceName().toLowerCase() + "/"
            + result.getMetricName().toLowerCase() + "/"
            + result.getMetricName() + suffix;
    }

    void generateAggregateWorker(AnalysisResult result, Writer output) throws IOException, TemplateException {
        configuration.getTemplate("AggregateWorkerTemplate.ftl").process(result, output);
    }

    void generateRemoteWorker(AnalysisResult result, Writer output) throws IOException, TemplateException {
        configuration.getTemplate("RemoteWorkerTemplate.ftl").process(result, output);
    }

    void generatePersistentWorker(AnalysisResult result, Writer output) throws IOException, TemplateException {
        configuration.getTemplate("PersistentWorkerTemplate.ftl").process(result, output);
    }

    void generateIndicatorImplementor(AnalysisResult result, Writer output) throws IOException, TemplateException {
        configuration.getTemplate("IndicatorImplementor.ftl").process(result, output);
    }

    void generateServiceDispatcher(Writer output) throws IOException, TemplateException {
        configuration.getTemplate("ServiceDispatcherTemplate.ftl").process(dispatcherContext, output);
    }

    private void toDispatchers() {
        dispatcherContext = new DispatcherContext();
        for (AnalysisResult result : results) {
            String sourceName = result.getSourceName();
            switch (sourceName) {
                case "Service":
                    dispatcherContext.getServiceIndicators().add(result);
                    break;
                case "Endpoint":
                    dispatcherContext.getServiceInstanceIndicators().add(result);
                    break;
                case "ServiceInstance":
                    dispatcherContext.getEndpointIndicators().add(result);
                    break;
                default:

            }
        }
    }
}
