/*
 * Copyright 2013 Rackspace
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.rackspacecloud.blueflood.rollup;

import com.rackspacecloud.blueflood.types.Metric;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MetricsPersistenceOptimizerFactoryTest {

    @Test
    public void testFactoryGetOptimizer() {
        MetricsPersistenceOptimizer optimizer =
                MetricsPersistenceOptimizerFactory.getOptimizer(Metric.DataType.STRING);

        // we should get a valid optimizer
        assertEquals(false, optimizer == null);
        // we should get a StringMetricsPersistenceOptimizer
        assertEquals(true, optimizer instanceof StringMetricsPersistenceOptimizer);

        optimizer = MetricsPersistenceOptimizerFactory.getOptimizer(Metric.DataType.DOUBLE);

        // we should set a GenericMetricsPersistenceOptimizer
        assertEquals(true, optimizer instanceof GenericMetricsPersistenceOptimizer);
    }
}