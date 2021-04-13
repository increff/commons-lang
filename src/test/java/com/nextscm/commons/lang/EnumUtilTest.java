/*
 * Copyright (c) 2021. Increff
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.nextscm.commons.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnumUtilTest {

    @Test
    public void testIn() {
        TestEnum[] arrayOfEnums = new TestEnum[2];
        arrayOfEnums[0] = TestEnum.ENUM1;
        arrayOfEnums[1] = TestEnum.ENUM2;

        assertTrue(EnumUtil.in(TestEnum.ENUM1, arrayOfEnums));
        assertTrue(EnumUtil.in(TestEnum.ENUM2, arrayOfEnums));
        assertFalse(EnumUtil.in(TestEnum.ENUM3, arrayOfEnums));
    }

    public enum TestEnum {
        ENUM1,
        ENUM2,
        ENUM3;
    }

}
