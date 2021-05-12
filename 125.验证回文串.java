/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            int leftIndex = getAlphabetIndex(s.charAt(left));
            if (leftIndex == -1) {
                left++;
                continue;
            }

            int rightIndex = getAlphabetIndex(s.charAt(right));
            if (rightIndex == -1) {
                right--;
                continue;
            }

            if (leftIndex == rightIndex) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    private int getAlphabetIndex(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch;
        }

        if (ch >= 'A' && ch <= 'Z') {
            return 'a' + (ch - 'A');
        }

        if (ch >= '0' && ch <= '9') {
            return ch;
        }

        return -1;
    }
}
// @lc code=end

