import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> freMap;
    Map<Integer, Stack<Integer>> numMap;
    int MaxFre;
    public FreqStack() {
        MaxFre  = 0;
        freMap = new HashMap<Integer, Integer>();
        numMap = new HashMap<Integer,Stack<Integer>>();
    }
    
    public void push(int val) {
        freMap.put(val, freMap.getOrDefault(val, 0) + 1);
        int fre = freMap.get(val);
        numMap.computeIfAbsent(fre, v-> new Stack<>()).push(val);
        MaxFre = Math.max(MaxFre, fre);
    }
    
    public int pop() {
        int num = numMap.get(MaxFre).pop();
        freMap.put(num, freMap.get(num) - 1);
        if(numMap.get(MaxFre).size() == 0){
            MaxFre--;
        }
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */