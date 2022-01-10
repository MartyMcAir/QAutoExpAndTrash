package com;

import static com.Calc.manipulation;
import static com.Calc.parseBinary;

public class DuplicateUtils {
    public static int duplicateNumber(int a) {
        final String s = String.valueOf(a);

        long factorial = parseBinary("ABCDEFG".toCharArray(), SomeEnum.FOR.getNum());
        long manipulation = manipulation(factorial, 6);
        System.out.println("one result: " + manipulation);

        return Integer.parseInt(s + s);
    }
}
