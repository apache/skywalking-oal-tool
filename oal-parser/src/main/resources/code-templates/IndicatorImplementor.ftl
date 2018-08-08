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

package org.apache.skywalking.oap.server.core.analysis.generated.${packageName};

import java.util.*;
import lombok.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.remote.annotation.StreamData;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.storage.annotation.*;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
@StreamData
@StorageEntity(name = "${tableName}")
public class ${metricName}Indicator extends ${indicatorClassName} {

<#list fieldsFromSource as sourceField>
    @Setter @Getter @Column(columnName = "${sourceField.columnName}") private ${sourceField.typeName} ${sourceField.fieldName};
</#list>

    @Override public String name() {
        return "${tableName}";
    }

    @Override public String id() {
        return String.valueOf(id);
    }

    @Override public int hashCode() {
        int result = 17;
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
        result = 31 * result + ${sourceField.fieldName};
    </#if>
</#list>
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

        ${metricName}Indicator indicator = (${metricName}Indicator)obj;
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
        if (${sourceField.fieldName} != indicator.${sourceField.fieldName})
    </#if>
</#list>
            return false;
        if (getTimeBucket() != indicator.getTimeBucket())
            return false;

        return true;
    }


    @Override public RemoteData.Builder serialize() {
        RemoteData.Builder remoteBuilder = RemoteData.newBuilder();
<#list serializeFields.stringFields as field>
        remoteBuilder.setDataStrings(${field?index}, ${field.getter}());
</#list>

<#list serializeFields.longFields as field>
        remoteBuilder.setDataLongs(${field?index}, ${field.getter}());
</#list>

<#list serializeFields.doubleFields as field>
        remoteBuilder.setDataDoubles(${field?index}, ${field.getter}());
</#list>

<#list serializeFields.intFields as field>
        remoteBuilder.setDataIntegers(${field?index}, ${field.getter}());
</#list>

        return remoteBuilder;
    }

    @Override public void deserialize(RemoteData remoteData) {
<#list serializeFields.stringFields as field>
        ${field.setter}(remoteData.getDataStrings(${field?index}));
</#list>

<#list serializeFields.longFields as field>
        ${field.setter}(remoteData.getDataLongs(${field?index}));
</#list>

<#list serializeFields.doubleFields as field>
        ${field.setter}(remoteData.getDataDoubles(${field?index}));
</#list>

<#list serializeFields.intFields as field>
        ${field.setter}(remoteData.getDataIntegers(${field?index}));
</#list>
    }

    @Override public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
<#list fieldsFromSource as field>
        map.put("${field.columnName}", ${field.fieldGetter}());
</#list>
<#list persistentFields as field>
        map.put("${field.columnName}", ${field.fieldGetter}());
</#list>
        return map;
    }

    @Override public Indicator newOne(Map<String, Object> dbMap) {
        ${metricName}Indicator indicator = new ${metricName}Indicator();
<#list fieldsFromSource as field>
        indicator.${field.fieldSetter}((${field.typeName})dbMap.get("${field.columnName}"));
</#list>
<#list persistentFields as field>
        indicator.${field.fieldSetter}((${field.typeName})dbMap.get("${field.columnName}"));
</#list>
        return indicator;
    }
}
