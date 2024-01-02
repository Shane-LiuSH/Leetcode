class MyCircularDeque {
    int[] q;
    int font = 0, rear = -1, size = 0;
    public MyCircularDeque(int k) {
        q = new int[k];
    }
    
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        font = (font + q.length - 1) % q.length;
        q[font] = value;
        size++;
        if(size == 1){
            rear = font;
        }
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % q.length;
        q[rear] = value;
        size++;
        return true;       
    }
    
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        font = (font + 1) % q.length;
        size--;
        return true;  
    }
    
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + q.length) % q.length;
        size--;
        return true;        
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return q[font];
    }
    
    public int getRear() {
         if(isEmpty()){
            return -1;
        }
        return q[rear];       
    }
    
    public boolean isEmpty() {
        return (size == 0);
    }
    
    public boolean isFull() {
        return (size == q.length);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */