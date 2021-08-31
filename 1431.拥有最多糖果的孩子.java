import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int maxCandies = 0;
        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        for (int i = 0; i < candies.length; ++i) {
            ans.add(candies[i] + extraCandies >= maxCandies);
        }

        return ans;
    }
}
// @lc code=end

