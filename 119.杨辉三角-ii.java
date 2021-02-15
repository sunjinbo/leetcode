/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 1; i <= rowIndex + 1; ++i) {
            List<Integer> res = new ArrayList();

            if (i > 1) {
                List<Integer> lastRes = new ArrayList();
                lastRes.add(0);
                lastRes.addAll(result.get(result.size() - 1));
                lastRes.add(0);
                for (int j = 0; j < lastRes.size() - 1; ++j) {
                    res.add(lastRes.get(j) + lastRes.get(j + 1));
                }
            } else {
                res.add(1);
            }

            result.add(res);
        }
        return result.get(result.size() - 1);
    }
}
// @lc code=end

