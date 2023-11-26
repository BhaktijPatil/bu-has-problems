package destiny.bu.problems.easy;

import java.util.HashMap;

public class IsomorphicStrings {
    /*
    Approach 1: Map Key of S to Value of T
    */

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i])) {
                if (tChars[i] != map.get(sChars[i])) {
                    return false;
                }
            } else if (map.containsValue(tChars[i])) {
                return false;
            } else {
                map.put(sChars[i], tChars[i]);
            }
        }
        return true;
    }

}
