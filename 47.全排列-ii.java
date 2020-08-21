import java.util.Deque;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) return result;

        Arrays.sort(nums); // 排序以便后续的剪枝

        Deque<Integer> path = new ArrayDeque<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, 0, path, used, result);
        return result;
    }

    public void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == nums.length) {
            // 将path添加到result中
            List<Integer> p = new ArrayList<>(path);
            result.add(p);
        } else {
            for (int i = 0; i < nums.length; ++i) {

                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue; // 用于剪枝
                }

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

