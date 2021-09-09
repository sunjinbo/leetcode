import java.util.Stack;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (isAlphabet(arr[i])) {
                stack.push(arr[i]);
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            if (isAlphabet(arr[i])) {
                arr[i] = stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr);
        return sb.toString();
    }

    public boolean isAlphabet(char ch) {
        return ('a' <= ch && 'z' >= ch) || ('A' <= ch && 'Z' >= ch);
    }
}
// @lc code=end

