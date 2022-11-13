// Given two integers representing the Numerator and Denominator of a fraction, return the fraction 
// in string format. If the fractional part is repeating, enclose the repeating part in parentheses.

// Examples: 

// Input: Numerator = 1, Denominator = 2
// Output: "0.5"
// 1/2 = 0.5 with no repeating part.

// Input: Numerator = 50, Denominator = 22
// Output: "2.(27)"
// 50/22 = 2.27272727... Since fractional part (27) 
// is repeating, it is enclosed in parentheses.

import java.util.*;

public class SimpleFraction {
    public static String calculateFraction(int num, int den) {
        if (num == 0)
            return "0";
        if (den == 0)
            return "";

        StringBuilder result = new StringBuilder();
        if ((num < 0) ^ (den < 0))
            result.append("-");

        num = Math.abs(num);
        den = Math.abs(den);

        long quo = num / den;
        long rem = num % den * 10;

        result.append(
                String.valueOf(quo));
        if (rem == 0)
            return result
                    .toString();
        result.append(".");
        Map<Long, Integer> m = new HashMap<>();

        while (rem != 0) {

            if (m.containsKey(rem)) {
                int index = m.get(rem);
                String part1 = result.substring(0, index);
                String part2 = "(" + result.substring(index, result.length()) + ")";
                return part1 + part2;
            }

            m.put(rem, result.length());
            quo = rem / den;
            result.append(String.valueOf(quo));

            rem = (rem % den) * 10;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int num = 113;
        int den = 56;

        String resString1 = calculateFraction(num, den);

        num = -1;
        den = 2;

        String resString2 = calculateFraction(num, den);

        System.out.println(resString1);
        System.out.println(resString2);
    }
}
