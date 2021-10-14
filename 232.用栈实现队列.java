/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    public MyQueue() {

    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int peek = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return peek;
    }
    
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int peek = s2.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return peek;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

