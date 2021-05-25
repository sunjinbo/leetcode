import java.util.Stack;

/*
 * @lc app=leetcode.cn id=682 lang=java
 *
 * [682] 棒球比赛
 */

// @lc code=start
class Solution {
    public int calPoints(String[] ops) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < ops.length; ++i) {
            switch (ops[i]) {
                case "C": // 前一次得分无效，将其从记录中移除
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "D": // 表示本回合新获得的得分是前一次得分的两倍
                    if (!stack.isEmpty()) {
                        int last = Integer.parseInt(stack.peek());
                        stack.push(Integer.toString(last * 2));
                    }
                    break;
                case "+":
                    if (stack.size() >= 2) {
                        int num1 = Integer.parseInt(stack.pop());
                        int num2 = Integer.parseInt(stack.pop());

                        stack.push(Integer.toString(num2));
                        stack.push(Integer.toString(num1));
                        stack.push(Integer.toString(num1 + num2));
                    }
                    break;
                default: // 数字
                    stack.push(ops[i]);
                    break;
            }
        }

        int score = 0;
        while (!stack.isEmpty()) {
            score += Integer.parseInt(stack.pop());
        }

        return score;
    }
}
// @lc code=end

