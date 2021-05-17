import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (pattern.length() == split.length) {
            HashMap<Character, String> map = new HashMap<>();
            for (int i = 0; i < pattern.length(); ++i) {
                Character ch = Character.valueOf(pattern.charAt(i));
                if (map.containsKey(ch)) {
                    if (!map.get(ch).equals(split[i])) {
                        return false;
                    }
                } else {
                    if (!map.containsValue(split[i])) {
                        map.put(ch, split[i]);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
// @lc code=end

