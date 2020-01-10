package ArraysAndStrings;

import java.util.Arrays;

/* Write a method to replace all spaces in a string with '%20'.
You may assume that the string has sufficient space at the end
to hold the additional characters, and that you are given
the "true" length of the string. (Note: If implementing in Java,
please use a character array so that you can perform this operation in place.) */

public class URLify {
    public static void main(String[] args) {

        String s = "Mr John Smith    ";
        int len = 13;

        char[] ans = urlify(s.toCharArray(), len);

        System.out.println(Arrays.toString(ans));
        System.out.println("ans.length = " + ans.length);
    }

    private static char[] urlify(char[] carr, int len) {

        int i = carr.length-1;
        int j = carr.length-1;

        //scan to last char
        while(i >= 0) {
            if (carr[i] != ' ')
                break;
            --i;
        }

        while(i >= 0) {
            if (carr[i] == ' ') {
                carr[j] = '0';
                carr[j-1] = '2';
                carr[j-2] = '%';
                j -= 3;
            } else {
                carr[j] = carr[i];
                --j;
            }
            --i;
        }

        return carr;
    }
}
