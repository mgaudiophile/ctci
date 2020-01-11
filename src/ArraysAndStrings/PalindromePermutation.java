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
}
