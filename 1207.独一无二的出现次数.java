import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == map.size();
    }
}
// @lc code=end

