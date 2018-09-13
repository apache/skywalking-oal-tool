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
<#if (fieldsFromSource?size>0) >
import lombok.*;
</#if>
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
import org.apache.skywalking.oap.server.core.Const;
        <#break>
    </#if>
</#list>
import org.apache.skywalking.oap.server.core.alarm.AlarmMeta;
import org.apache.skywalking.oap.server.core.alarm.AlarmSupported;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.annotation.IndicatorType;
import org.apache.skywalking.oap.server.core.remote.annotation.StreamData;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.storage.annotation.*;
import org.apache.skywalking.oap.server.core.storage.StorageBuilder;
import org.apache.skywalking.oap.server.core.source.Scope;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
@IndicatorType
@StreamData
@StorageEntity(name = "${tableName}", builder = ${metricName}Indicator.Builder.class)
public class ${metricName}Indicator extends ${indicatorClassName} implements AlarmSupported {

<#list fieldsFromSource as sourceField>
    @Setter @Getter @Column(columnName = "${sourceField.columnName}") <#if sourceField.isID()>@IDColumn</#if> private ${sourceField.typeName} ${sourceField.fieldName};
</#list>

    @Override public String id() {
        String splitJointId = String.valueOf(getTimeBucket());
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
        <#if sourceField.getTypeName() == "String">
        splitJointId += Const.ID_SPLIT + ${sourceField.fieldName};
        <#else>
        splitJointId += Const.ID_SPLIT + String.valueOf(${sourceField.fieldName});
        </#if>
    </#if>
</#list>
        return splitJointId;
    }

    @Override public int hashCode() {
        int result = 17;
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
        <#if sourceField.getTypeName() == "String">
        result = 31 * result + ${sourceField.fieldName}.hashCode();
        <#else>
        result += Const.ID_SPLIT + ${sourceField.fieldName};
        </#if>
    </#if>
</#list>
        result = 31 * result + (int)getTimeBucket();
        return result;
    }


    @Override public int remoteHashCode() {
        int result = 17;
<#list fieldsFromSource as sourceField>
    <#if sourceField.isID()>
        <#if sourceField.getTypeName() == "String">
        result = 31 * result + ${sourceField.fieldName}.hashCode();
        <#else>
        result += Const.ID_SPLIT + ${sourceField.fieldName};
        </#if>
    </#if>
</#list>
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
            return false;
    </#if>
</#list>

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
<#list serializeFields.intLongValuePairListFields as field>
        ${field.getter}().forEach(element -> remoteBuilder.addDataIntLongPairList(element.serialize()));
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

<#list serializeFields.intLongValuePairListFields as field>
        setDetailGroup(new ArrayList<>(30));
        remoteData.getDataIntLongPairListList().forEach(element -> {
            getDetailGroup().add(new IntKeyLongValue(element.getKey(), element.getValue()));
        });
</#list>

    }

    @Override public AlarmMeta getAlarmMeta() {
        return new AlarmMeta("${varName}", Scope.${sourceName}<#if (fieldsFromSource?size>0) ><#list fieldsFromSource as field><#if field.isID()>, ${field.fieldName}</#if></#list></#if>);
    }

    @Override
    public Indicator toHour() {
        ${metricName}Indicator indicator = new ${metricName}Indicator();
        indicator.setTimeBucket(toTimeBucketInHour());
<#list fieldsFromSource as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
<#list persistentFields as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
        return indicator;
    }

    @Override
    public Indicator toDay() {
        ${metricName}Indicator indicator = new ${metricName}Indicator();
        indicator.setTimeBucket(toTimeBucketInDay());
<#list fieldsFromSource as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
<#list persistentFields as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
        return indicator;
    }

    @Override
    public Indicator toMonth() {
        ${metricName}Indicator indicator = new ${metricName}Indicator();
        indicator.setTimeBucket(toTimeBucketInMonth());
<#list fieldsFromSource as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
<#list persistentFields as field>
        indicator.${field.fieldSetter}(this.${field.fieldGetter}());
</#list>
        return indicator;
    }

    public static class Builder implements StorageBuilder<${metricName}Indicator> {

        @Override public Map<String, Object> data2Map(${metricName}Indicator storageData) {
            Map<String, Object> map = new HashMap<>();
    <#list fieldsFromSource as field>
            map.put("${field.columnName}", storageData.${field.fieldGetter}());
    </#list>
    <#list persistentFields as field>
            map.put("${field.columnName}", storageData.${field.fieldGetter}());
    </#list>
            return map;
        }

        @Override public ${metricName}Indicator map2Data(Map<String, Object> dbMap) {
            ${metricName}Indicator indicator = new ${metricName}Indicator();
    <#list fieldsFromSource as field>
        <#if field.typeName == "long" || field.typeName == "int" || field.typeName == "double" || field.typeName == "float">
            indicator.${field.fieldSetter}(((Number)dbMap.get("${field.columnName}")).${field.typeName}Value());
        <#else>
            indicator.${field.fieldSetter}((${field.typeName})dbMap.get("${field.columnName}"));
        </#if>
    </#list>
    <#list persistentFields as field>
        <#if field.typeName == "long" || field.typeName == "int" || field.typeName == "double" || field.typeName == "float">
            indicator.${field.fieldSetter}(((Number)dbMap.get("${field.columnName}")).${field.typeName}Value());
        <#else>
            indicator.${field.fieldSetter}((${field.typeName})dbMap.get("${field.columnName}"));
        </#if>
    </#list>
            return indicator;
        }
    }
}
