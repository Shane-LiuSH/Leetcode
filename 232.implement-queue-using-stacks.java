/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> queue = new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(queue.isEmpty()){
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }
    
    public int peek() {
        if(queue.isEmpty()){
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty()&& stack.isEmpty();
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

