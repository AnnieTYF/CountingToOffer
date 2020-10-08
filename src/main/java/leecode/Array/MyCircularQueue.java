package leecode.Array;

public class MyCircularQueue {
    private int[] arr;
    private int size; //当前队列中元素个数，核心
    private int front;
    private int rear;
    /** 初始化 */
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.size = 0;
        this.front = 0; //删除的位置
        this.rear = 0;//插入的位置
    }
    /** 插入元素*/
    public boolean enQueue(int value) {
        if (size == arr.length) {
            return false;
        }
        arr[rear] = value;
        size ++;
        rear = (rear == arr.length - 1)? 0 : rear + 1;
        return true;
    }
    /** 删除元素*/
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        front = (front == arr.length - 1) ? 0 : front + 1;
        size--;
        return true;
    }
    /** 获取首元素*/
    public int Front() {
        if (size == 0) {
            return -1;
        }
        return arr[front];
    }
    /** 获取尾元素 */
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return rear == 0 ? arr[arr.length - 1] : arr[rear - 1];
    }
    /** 判空*/
    public boolean isEmpty() {
        return size == 0;
    }
    /** 判断是否满*/
    public boolean isFull() {
        return size == arr.length;
    }
}
