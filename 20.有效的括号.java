import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            Character ch = s.charAt(i);
            if (!stack.isEmpty() 
                && pairs.containsKey(ch)
                && pairs.get(ch) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

