package com.imos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExcelUtilsTest {

    @Test
    void validStringIndexToIntegerIndex() {
        Assertions.assertEquals(1, ExcelUtils.getColumnIndex("A"));
        Assertions.assertEquals(26, ExcelUtils.getColumnIndex("Z"));
        Assertions.assertEquals(27, ExcelUtils.getColumnIndex("AA"));
        Assertions.assertEquals(28, ExcelUtils.getColumnIndex("AB"));
        Assertions.assertEquals(702, ExcelUtils.getColumnIndex("ZZ"));
        Assertions.assertEquals(703, ExcelUtils.getColumnIndex("AAA"));
        Assertions.assertEquals(704, ExcelUtils.getColumnIndex("AAB"));
    }

    @Test
    void validIntegerIndexToStringIndex() {
        Assertions.assertEquals("A", ExcelUtils.getColumnIndex(1));
        Assertions.assertEquals("Z", ExcelUtils.getColumnIndex(26));
        Assertions.assertEquals("AA", ExcelUtils.getColumnIndex(27));
        Assertions.assertEquals("AB", ExcelUtils.getColumnIndex(28));
        Assertions.assertEquals("ZZ", ExcelUtils.getColumnIndex(702));
        Assertions.assertEquals("AAA", ExcelUtils.getColumnIndex(703));
        Assertions.assertEquals("AAB", ExcelUtils.getColumnIndex(704));
    }
}
