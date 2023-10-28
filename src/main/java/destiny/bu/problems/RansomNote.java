package destiny.bu.problems;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {
    public boolean canConstructApproachTwo(String ransomNote, String magazine) {
        HashMap<Character, Long> charCountMap = (HashMap<Character, Long>) magazine.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (char character : ransomNote.toCharArray()) {
            if (!charCountMap.containsKey(character) || charCountMap.get(character) == 0) {
                return false;
            } else {
                charCountMap.put(character, charCountMap.get(character) - 1);
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> chars = magazine.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toList());

        for (int i = 0; i < ransomNote.length(); i++) {
            if (chars.isEmpty()) {
                return false;
            }
            if (chars.contains(ransomNote.charAt(i))) {
                chars.remove(Character.valueOf(ransomNote.charAt(i)));
            } else {
                return false;
            }
        }
        return true;
    }
}
