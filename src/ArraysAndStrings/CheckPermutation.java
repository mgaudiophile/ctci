package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static void main(String[] args) {

        String one = "tools";
        String two = "olgos";

        System.out.println("checkPermutation(" + one + ", " + two + ") = " + checkPermutation(one, two));
    }

    private static boolean checkPermutation(String one, String two) {

        if (one.length() != two.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        // build a hash map
        for (char ch : one.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        // decrement the map values
        for (char ch : two.toCharArray()) {
            if (!map.containsKey(ch))
                return false;

            map.replace(ch, map.get(ch) - 1);

            if (map.get(ch) == 0)
                map.remove(ch);
        }

        return map.size() == 0;
    }
}
