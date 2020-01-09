package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/* Implement an algorithm to determine if a string
has all unique characters. What if you cannot use
additional data structures?
 */
public class IsUnique {
    public static void main(String[] args) {

        String t1 = "abcdeffghi";
        String t2 = "abcdefghij";

        System.out.println("isUnique("+t1+") = " + isUnique(t1));
        System.out.println("isUnique("+t2+") = " + isUnique(t2));

        System.out.println("isUnique_noDS("+t1+") = " + isUnique_noDS(t1));
        System.out.println("isUnique_noDS("+t2+") = " + isUnique_noDS(t2));
    }

    // Uses data structure
    private static boolean isUnique(String s) {

        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;
    }

    private static boolean isUnique_noDS(String s) {

        int[] bvec = new int[128];
        for (char ch : s.toCharArray()) {
            int i = ch;
            int mask =  (1 << i);
            if (bvec[i] == 1)
                return false;
            bvec[i] = 1;
        }

        return true;
    }
}
