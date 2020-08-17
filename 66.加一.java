import sun.security.util.ArrayUtil;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int carryBit = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            int add = digits[i] + carryBit;
            if (add / 10 == 1) {
                carryBit = 1;
                digits[i] = 0;
            } else {
                carryBit = 0;
                digits[i] = add;
                break;
            }
        }

        if (carryBit > 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; ++i) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
// @lc code=end

