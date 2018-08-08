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

package org.apache.skywalking.oap.server.core.analysis.generated;

import org.apache.skywalking.oap.server.core.CoreModule;
import org.apache.skywalking.oap.server.core.analysis.SourceDispatcher;
import org.apache.skywalking.oap.server.core.analysis.worker.define.WorkerMapper;
import org.apache.skywalking.oap.server.core.source.Service;
import org.apache.skywalking.oap.server.library.module.ModuleManager;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
public class ServiceDispatcher implements SourceDispatcher<Service> {

    private final ModuleManager moduleManager;
    private ServiceAvgAggregateWorker ServiceAvg;

    public ServiceDispatcher(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Override public void dispatch(Service source) {
        doServiceAvg(source);
    }

    private void doServiceAvg(Service source) {
        if (avgAggregator == null) {
            WorkerMapper workerMapper = moduleManager.find(CoreModule.NAME).getService(WorkerMapper.class);
            avgAggregator = (ServiceAvgAggregateWorker)workerMapper.findInstanceByClass(ServiceAvgAggregateWorker.class);
        }

        ServiceAvgIndicator indicator = new ServiceAvgIndicator();

        indicator.setTimeBucket(source.getTimeBucket());
        indicator.setId(source.getId())
        indicator.combine(
            source.getLatency(), 1);
        avgAggregator.in(indicator);
    }
}