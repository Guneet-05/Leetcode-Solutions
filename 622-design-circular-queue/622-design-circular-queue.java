class MyCircularQueue {
    
    int[] nums;
    int front;
    int rear;
    int size;
    
    public MyCircularQueue(int k) {
        nums = new int[k];
        size = 0;
        front  = 0;
        rear = 0;
    }
    
    public boolean enQueue(int val) {
        if(size == nums.length) {
            return false;
        }
        
        nums[rear] = val;
        rear = (rear + 1) % nums.length;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        
        front = (front + 1) % nums.length;
        size--;
        return true;
    }
    
    public int Front() {
        if(size == 0) {
            return -1;
        }
        
        int x = nums[front];
        return x;
    }
    
    public int Rear() {
        if(size == 0) return -1;
        int x = nums[(rear -1 + nums.length) % nums.length];
        return x;
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == nums.length) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */