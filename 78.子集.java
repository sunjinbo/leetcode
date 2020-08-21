import java.awt.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());
    
        for (int num : nums) {
          List<List<Integer>> newSubsets = new ArrayList();
          for (List<Integer> curr : output) {
            List<Integer> subset = new ArrayList<Integer>();
            subset.addAll(curr);
            subset.add(num);
            newSubsets.add(subset);
          }

          output.addAll(newSubsets);
        }
        return output;
    }
}
// @lc code=end

