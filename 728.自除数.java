import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();

        for (int i = left; i <= right; ++i) {
            if (isSelfDividingNumbers(i)) {
                ret.add(i);
            }
        }

        return ret;
    }

    public boolean isSelfDividingNumbers(int number) {
        String numberString = number + "";

        for (int i = 0; i < numberString.length(); ++i) {
            int digit = numberString.charAt(i) - '0';
            if (digit == 0 || number % digit != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

