import java.util.List;

/*
 * @lc app=leetcode.cn id=476 lang=java
 *
 * [476] 数字的补数
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        List<Integer> bits = new ArrayList();

        while (num / 2 != 0) {
            bits.add(num % 2);
            num = num / 2;
        }

        bits.add(num % 2);

        int result = 0;
        int bit = 1;
        for (int i = 0; i < bits.size(); ++i) {
            bit = (int)Math.pow(2, i);
            if (bits.get(i) == 0) {
                result = result + bit;
            }
        }

        return result;
    }
}
// @lc code=end

