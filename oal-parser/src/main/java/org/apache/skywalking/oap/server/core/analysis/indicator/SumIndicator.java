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

package org.apache.skywalking.oap.server.core.analysis.indicator;

import lombok.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.annotation.*;
import org.apache.skywalking.oap.server.core.storage.annotation.Column;

/**
 * @author peng-yongsheng
 */
@IndicatorOperator
public abstract class SumIndicator extends Indicator {

    protected static final String VALUE = "value";

    @Getter @Setter @Column(columnName = VALUE) private long value;

    @Entrance
    public final void combine(@ConstOne long count) {
        this.value += count;
    }

    @Override public final void combine(Indicator indicator) {
        SumIndicator sumIndicator = (SumIndicator)indicator;
        combine(sumIndicator.value);
    }

    @Override public void calculate() {
    }
}
