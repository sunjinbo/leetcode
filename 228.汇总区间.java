import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList();
        int startIndex = -1;
        int range = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (startIndex == -1) {
                startIndex = i;
                range = 0;
            } else {
                if (nums[i] - nums[startIndex + range] == 1) {
                    range += 1;
                } else {
                    if (range == 0) {
                        ans.add("" + nums[startIndex]);
                    } else {
                        ans.add(nums[startIndex] + "->" + nums[startIndex + range]);
                    }

                    startIndex = i;
                    range = 0;
                }
            }
        }

        if (startIndex >= 0) {
            if (range == 0) {
                ans.add("" + nums[startIndex]);
            } else {
                ans.add(nums[startIndex] + "->" + nums[startIndex + range]);
            }
        }

        return ans;
    }
}
// @lc code=end

