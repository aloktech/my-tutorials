package com.imos;

import org.apache.commons.lang3.StringUtils;

public class ExcelUtils {

    public static String getColumnIndex(int columnIndex) {
        StringBuilder builder = new StringBuilder();
        if (columnIndex < 1) {
            return builder.toString();
        }
        while (columnIndex > 0) {
            int remainder = columnIndex % 26;
            int result = remainder == 0 ? 90 : (remainder + 64);
            builder.append((char) result);
            columnIndex = columnIndex / 26;
            if (remainder == 0) {
                if (columnIndex != 1) {
                    builder.append(StringUtils.reverse(getColumnIndex(columnIndex - 1)));
                }
                break;
            }
        }
        return builder.reverse().toString();
    }
    public static int getColumnIndex(String columnIndex) {
        columnIndex = StringUtils.reverse(columnIndex);
        int value = 0;
        int counter = 0;
        for (char ch : columnIndex.toCharArray()) {
            value += Math.pow(26, counter) * (ch - 64);
            counter++;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(getColumnIndex("A"));
        System.out.println(getColumnIndex("AA"));
        System.out.println(getColumnIndex("AB"));
        System.out.println(getColumnIndex("AC"));
    }
}
