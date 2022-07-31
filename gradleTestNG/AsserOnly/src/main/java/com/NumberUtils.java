package com;

public class NumberUtils {
    public static int revertTwoNumbers(int number) {
        final char[] chars = String.valueOf(number).toCharArray();
        final String first = String.valueOf(chars[0]);
        final String second = String.valueOf(chars[1]);
        final String newNumberStr = second + first;
        return Integer.parseInt(newNumberStr);
    }
}