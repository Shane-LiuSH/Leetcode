class MyCircularQueue {
    int[] q;
    int size, font, rear;
    public MyCircularQueue(int k) {
        font = 0;
        rear = -1;
        size = 0;
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(size == q.length){
            return false;
        }
        rear = (rear + 1) % q.length;
        q[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        font = (font + 1) % q.length;
        size--;
        return true;
    }
    
    public int Front()  { 
        if(isEmpty() == true){
            return -1;
        }
        return q[font];
    }
    
    public int Rear() {
        if(isEmpty() == true){
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
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */