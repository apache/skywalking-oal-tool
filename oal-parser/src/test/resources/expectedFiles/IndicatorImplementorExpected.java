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

package org.apache.skywalking.oap.server.core.analysis.generated.service.serviceavg;

import java.util.*;
import lombok.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.storage.annotation.Column;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */

public class ServiceAvgIndicator extends AvgIndicator {

    @Setter @Getter @Column(columnName = "id") private int id;
    @Setter @Getter @Column(columnName = "serviceId") private int serviceId;
    @Setter @Getter @Column(columnName = "serviceInstanceId") private int serviceInstanceId;

    @Override public String name() {
        return "service_avg";
    }

    @Override public String id() {
        return String.valueOf(id);
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (int)getTimeBucket();
        return result;
    }


    @Override public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ServiceAvgIndicator indicator = (ServiceAvgIndicator)obj;
        if (id != indicator.id)
            return false;
        if (getTimeBucket() != indicator.getTimeBucket())
            return false;

        return true;
    }


    @Override public RemoteData.Builder serialize() {
        RemoteData.Builder remoteBuilder = RemoteData.newBuilder();

        remoteBuilder.setDataLongs(0, getTimeBucket());
        remoteBuilder.setDataLongs(1, getSummation());
        remoteBuilder.setDataLongs(2, getValue());


        remoteBuilder.setDataIntegers(0, getId());
        remoteBuilder.setDataIntegers(1, getServiceId());
        remoteBuilder.setDataIntegers(2, getServiceInstanceId());
        remoteBuilder.setDataIntegers(3, getCount());

        return remoteBuilder;
    }

    @Override public void deserialize(RemoteData remoteData) {

        setTimeBucket(remoteData.getDataLongs(0));
        setSummation(remoteData.getDataLongs(1));
        setValue(remoteData.getDataLongs(2));


        setId(remoteData.getDataIntegers(0));
        setServiceId(remoteData.getDataIntegers(1));
        setServiceInstanceId(remoteData.getDataIntegers(2));
        setCount(remoteData.getDataIntegers(3));
    }

    @Override public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", getId());
        map.put("serviceId", getServiceId());
        map.put("serviceInstanceId", getServiceInstanceId());
        map.put("summation", getSummation());
        map.put("count", getCount());
        map.put("value", getValue());
        return map;
    }

    @Override public Indicator newOne(Map<String, Object> dbMap) {
        ServiceAvgIndicator indicator = new ServiceAvgIndicator();
        indicator.setId((int)dbMap.get("id"));
        indicator.setServiceId((int)dbMap.get("serviceId"));
        indicator.setServiceInstanceId((int)dbMap.get("serviceInstanceId"));
        indicator.setSummation((long)dbMap.get("summation"));
        indicator.setCount((int)dbMap.get("count"));
        indicator.setValue((long)dbMap.get("value"));
        return indicator;
    }
}