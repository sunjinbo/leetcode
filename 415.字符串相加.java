/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringStack num1Stack = new StringStack(num1);
        StringStack num2Stack = new StringStack(num2);
        StringQueue queue = new StringQueue();

        int carray = 0;
        while (num1Stack.isNotEmpty() || num2Stack.isNotEmpty()) {
            int n1 = 0;
            if (num1Stack.isNotEmpty()) {
                try {
                    n1 = convertToNumber(num1Stack.pop());
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            int n2 = 0;
            if (num2Stack.isNotEmpty()) {
                try {
                    n2 = convertToNumber(num2Stack.pop());
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            int sum = n1 + n2 + carray;
            if (sum >= 10) {
                sum = sum % 10;
                carray = 1;
            } else {
                carray = 0;
            }

            queue.push(sum);
        }

        if (carray > 0) {
            queue.push(carray);
        }

        return queue.toString();
    }

    public int convertToNumber(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        return 0;
    }

    public class StringStack {
        private int cursor;
        private String stringStack;

        public StringStack(String str) {
            stringStack = str;
            cursor = stringStack.length() - 1;
        }

        public boolean isEmpty() {
            return cursor < 0;
        }

        public boolean isNotEmpty() {
            return !isEmpty();
        }

        public char pop() {
            if (isNotEmpty()) {
                return stringStack.charAt(cursor--);
            }
            return 'a';
        }
    }

    public class StringQueue {
        private StringBuilder sb;

        public StringQueue() {
            sb = new StringBuilder();
        }

        public void push(int num) {
            sb.insert(0, num);
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }
}
// @lc code=end

