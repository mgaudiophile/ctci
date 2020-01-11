package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/* Given a string, write a function to check if it is a
permutation of a palindrome. A palindrome is a word or
phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need
to be limited to just dictionary words. */
public class PalindromePermutation {

    public static void main(String[] args) {

        String in = "Tact Coa";
        String in2 = "rcecraa";

        System.out.println("palindromPerm(in) = " + palindromePerm(in));
        System.out.println("palindromPerm(in2) = " + palindromePerm(in2));

        System.out.println("bitVecSoln(in) = " + bitVecSoln(in));
        System.out.println("bitVecSoln(in2) = " + bitVecSoln(in2));
    }

    private static boolean palindromePerm(String in) {

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : in.toCharArray()) {
            if (ch != ' ') {
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }

        int odds = 0;
        for (int v : map.values()) {
            if (v % 2 == 1)
                ++odds;
            if (odds > 1)
                return false;
        }

        return true;
    }

    private static boolean bitVecSoln(String in) {
        //book assumes we have only a-z
        int bv = 0;
        for (char c : in.toCharArray()) {
            if (c != ' ') {
                c = Character.toLowerCase(c);
                int i = c;
                int mask = (1 << i);

                // toggle
                if ((bv & mask) > 0) {
                    bv &= ~mask;    //flip to 0
                } else {
                    bv |= mask;
                }
            }
        }

        int bitSet = (bv & (bv - 1));

        return bv == 0 || bitSet == 0;
    }
}
