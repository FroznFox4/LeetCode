package slidingWindow.longestSubstringWithoutRepeatingCharacters3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int mew = Solution.getInstance().lengthOfLongestSubstring(s);
        System.out.println(mew);
    }
}

class Solution {

    private Solution() {
    }

    private static final Solution obj = new Solution();

    public static Solution getInstance() {
        return obj;
    }

//Runtime: 13 ms, faster than 42.82%; Memory Usage: 45.9 MB, less than 31.54%
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}