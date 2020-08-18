/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (!compare(nums[i], nums[j])) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        String lagestNumString = "";
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 && nums[i] == 0) {
                lagestNumString = "0";
                break;
            } else {
                lagestNumString += nums[i];
            }
        }
        return lagestNumString;
    }

    public boolean compare(int a, int b) throws NumberFormatException {
        final String num1 = a + "" + b;
        final String num2 = b + "" + a;
        for (int i = 0; i < num1.length() && i < num2.length(); ++i) {
            int aVal = Integer.parseInt(num1.charAt(i) + "");
            int bVal = Integer.parseInt(num2.charAt(i) + "");

            if (aVal > bVal) {
                return true;
            } else if (aVal < bVal) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
}
// @lc code=end

