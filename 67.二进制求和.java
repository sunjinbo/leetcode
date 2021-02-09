import java.util.Stack;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();

        for (int i = 0; i < a.length(); ++i) {
            aStack.push(a.charAt(i));
        }

        for (int i = 0; i < b.length(); ++i) {
            bStack.push(b.charAt(i));
        }

        Stack<Character> result = new Stack<>();
        boolean carry = false;
        while (!(aStack.isEmpty() && bStack.isEmpty())) {
            Character aBit = aStack.isEmpty() ? '0' : aStack.pop();
            Character bBit = bStack.isEmpty() ? '0' : bStack.pop();

            if (aBit == '1' && bBit == '1') {
                if (carry) {
                    result.push('1');
                } else {
                    result.push('0');
                }
                carry = true;
            } else if (aBit == '0' && bBit == '0') {
                if (carry) {
                    result.push('1');
                } else {
                    result.push('0');
                }
                carry = false;
            } else {
                if (carry) {
                    result.push('0');
                    carry = true;
                } else {
                    result.push('1');
                    carry = false;
                }
            }
        }

        if (carry) {
            result.push('1');
        }

        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.toString();
    }
}
// @lc code=end

