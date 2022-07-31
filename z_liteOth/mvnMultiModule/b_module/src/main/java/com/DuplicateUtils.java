package com;

public class DuplicateUtils {
    public static int duplicateNumber(int a) {
        final String s = String.valueOf(a);
        return Integer.parseInt(s + s);
    }
}
