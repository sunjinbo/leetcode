import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            int minus = target - nums[i];
            if (map.containsKey(minus) && i != map.get(minus)) {
                result[0] = i;
                result[1] = map.get(minus);
            }
        }
        return result;
    }
}
<<<<<<< HEAD
// @lc code=end
=======
// @lc code=end

>>>>>>> f0609f68754215ff79eebe30bf266ab68f347c64
