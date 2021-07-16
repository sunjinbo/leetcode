import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap();
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), true);
                boolean multipy = false;
                for (int j = i + 1; j < s.length(); ++j) {
                    if (s.charAt(i) == s.charAt(j)) {
                        multipy = true;
                        break;
                    }
                }
                if (!multipy) {
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

