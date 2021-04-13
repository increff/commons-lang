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
