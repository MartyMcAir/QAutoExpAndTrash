package com;

public class StringCharCodeUtils {
    public static int getCharCodeFromFirstLetter(String str) {
        final char[] chars = str.toCharArray();
        return chars[0];
    }
}
