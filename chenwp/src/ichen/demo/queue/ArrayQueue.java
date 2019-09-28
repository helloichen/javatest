package ichen.demo.queue;

public class ArrayQueue {
    Object[] a; //对象数组，队列最多存储a.length个对象
    int front;  //队首下标
    int rear;   //队尾下标
    int head = 0;
    int tail = 0;

    public ArrayQueue() {
        this(10); //调用其他构造方法
    }

    public ArrayQueue(int size) {
        a = new Object[size];
        front = 0;
        rear = 0;
    }

    /**
     * 将一个对象追加到队列尾部
     *
     * @param obj 对象
     * @return 队列满时返回false, 否则返回true
     */
    public synchronized boolean offer(Object obj) {
        if (tail - head >= 4) {
            return false;
        }
        a[rear] = obj;
        tail++;
        rear = (rear + 1) % a.length;
        return true;
    }

    /**
     * 队列头部的第一个对象出队
     *
     * @return 出队的对象，队列空时返回null
     */
    public synchronized Object poll() {
        if (tail - head <= 0) {
            return null;
        }
        Object obj = a[front];
        head++;
        front = (front + 1) % a.length;
        return obj;
    }


}
class TestArrayQueue{
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(4);
        System.out.println(q.offer("张三"));
        System.out.println(q.offer("李斯"));
        System.out.println(q.offer("赵五"));
        System.out.println(q.offer("王一"));
        System.out.println(q.poll());
        System.out.println(q.offer("王二"));//无法入队列，队列满
        for (int i = 0; i < 4; i++) {
            System.out.println(q.poll());
        }
    }
}
