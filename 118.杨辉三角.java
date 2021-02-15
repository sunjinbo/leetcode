import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 1; i <= numRows; ++i) {
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
        return result;
    }
}
// @lc code=end

