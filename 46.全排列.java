import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) return result;

        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, result);
        return result;
    }

    public void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == nums.length) {
            List<Integer> p = new ArrayList<>();
            p.addAll(path);
            result.add(p);
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (used[i]) {
                    continue;
                } else {
                    path.addLast(nums[i]);
                    used[i] = true;
                    dfs(nums, depth + 1, path, used, result);
                    used[i] = false;
                    path.removeLast();
                }
            }
        }
    }
}
// @lc code=end

