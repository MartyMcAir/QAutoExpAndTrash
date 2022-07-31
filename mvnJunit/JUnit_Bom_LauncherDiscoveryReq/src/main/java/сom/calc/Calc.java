package сom.calc;

public class Calc {
    public static int sum(int a, int b) {
        long factorial = parseBinary("ABCDEFG".toCharArray(), 50);
        long manipulation = manipulation(factorial, 6);
        System.out.println("one result: " + manipulation);
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static long parseBinary(char[] chars, int numbers) {
        int res = 0;
        for (int j = 0; j < numbers; j++) {
            for (int i = 0; i < chars.length; ++i) {
                res *= 2;
                if (chars[i] == '1') {
                    res += 1;
                }
            }
            res += j;
        }

        return res;
    }

    public static int recursion(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + recursion(n / 10);
        }
    }


    public static int fibonacci(int n) {
        if (n == 1)
            n = 1;
        else
            n = n + fibonacci(--n);
        return n;
    }

    public static long manipulation(long factorial, int z) {
        long i = factorial + z;
        return i - 2;
    }

    public static int factorial(int n) {
        if (n == 0)
            n = 1;
        else
            n = n * factorial(--n);
        return n;
    }
}
