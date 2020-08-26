import java.util.Deque;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }

        Deque<String> path = new ArrayDeque<>();
        backtracking(s, 0, len, path, ans);
        return ans;
    }

    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> ans) {
        if (start == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; ++i) {
            if (!checkPalindrome(s, start, i)) {
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, ans);
            path.removeLast();
        }
    }

    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

