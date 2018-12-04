package Model;

import java.math.BigInteger;

public class Maths {
    public static BigInteger factorial(int number) {
        BigInteger result = BigInteger.valueOf(1);

        for (int factor = 2; factor <= number; factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }

        return result;
    }

}
