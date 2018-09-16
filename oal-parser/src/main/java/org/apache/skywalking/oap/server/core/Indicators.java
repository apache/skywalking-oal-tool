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

package org.apache.skywalking.oap.server.core;

import java.util.HashMap;
import java.util.Map;
import org.apache.skywalking.oap.server.core.analysis.indicator.CPMIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.CountIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.DoubleAvgIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.LongAvgIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.P50Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.P75Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.P90Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.P95Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.P99Indicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.PercentIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.SumIndicator;
import org.apache.skywalking.oap.server.core.analysis.indicator.ThermodynamicIndicator;

public class Indicators {
    private static Map<String, Class<? extends Indicator>> REGISTER = new HashMap<>();

    static {
        REGISTER.put("longAvg", LongAvgIndicator.class);
        REGISTER.put("doubleAvg", DoubleAvgIndicator.class);
        REGISTER.put("percent", PercentIndicator.class);
        REGISTER.put("sum", SumIndicator.class);
        REGISTER.put("count", CountIndicator.class);
        REGISTER.put("cpm", CPMIndicator.class);
        REGISTER.put("p99", P99Indicator.class);
        REGISTER.put("p95", P95Indicator.class);
        REGISTER.put("p90", P90Indicator.class);
        REGISTER.put("p75", P75Indicator.class);
        REGISTER.put("p50", P50Indicator.class);
        REGISTER.put("thermodynamic", ThermodynamicIndicator.class);
    }

    public static Class<? extends Indicator> find(String functionName) {
        String func = functionName;
        Class<? extends Indicator> indicatorClass = REGISTER.get(func);
        if (indicatorClass == null) {
            throw new IllegalArgumentException("Can't find indicator.");
        }
        return indicatorClass;
    }

}
