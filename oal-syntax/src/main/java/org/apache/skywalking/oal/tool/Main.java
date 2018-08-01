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

package org.apache.skywalking.oal.tool;

import java.io.File;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * The main of SkyWalking OAL tool
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addRequiredOption("s", "script-filepath", true, "Need the absolute file path of OAL script.");
        options.addRequiredOption("o", "output", true, "Need the root output folder of the generated codes.");

        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse( options, args );

        String scriptFilePath = line.getOptionValue("s");
        String outputPath = line.getOptionValue("o");

        File scriptFile = new File(scriptFilePath);
        if (!scriptFile.exists()) {
            throw new IllegalArgumentException("OAL script file [" + scriptFilePath + "] doesn't exist");
        }
    }
}
