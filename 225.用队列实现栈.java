import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    Queue<Integer> mDataQueue;
    Queue<Integer> mAssistQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        mDataQueue = new LinkedBlockingQueue<>();
        mAssistQueue = new LinkedBlockingQueue<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        mDataQueue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Integer temp = mDataQueue.poll();
        while (!mDataQueue.isEmpty()) {
            mAssistQueue.offer(temp);
            temp = mDataQueue.poll();
        }

        while (!mAssistQueue.isEmpty()) {
            mDataQueue.offer(mAssistQueue.poll());
        }

        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        Integer temp = pop();
        mDataQueue.offer(temp);
        return temp;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mDataQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

