import java.util.Stack;

class CustomStack {
    int size;
    Stack<Integer> stack = new Stack<>();
    int[] inc;
    public CustomStack(int maxSize) {
        size= maxSize;
        inc = new int[maxSize];
    }
    
    public void push(int x) {
        if(stack.size() < size){
            stack.add(x);
        }
    }
    
    public int pop() {
        if (stack.size() == 0) {
            return -1;
        }
        int i = stack.size() - 1;
        if(i >= 1){
            inc[i - 1] += inc[i];
        }
        int val = stack.pop() + inc[i];
        inc[i] = 0;
        return val;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(stack.size() - 1, k - 1);
        if (i < 0){
            return;
        }
        inc[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */