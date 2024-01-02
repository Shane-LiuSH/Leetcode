/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int top;
    public MyStack() {
        
    }
    
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int val = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return val;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return (q1.isEmpty()&&q2.isEmpty());
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

