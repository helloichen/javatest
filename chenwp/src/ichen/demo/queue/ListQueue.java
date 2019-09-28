package ichen.demo.queue;

import java.util.ArrayList;

public class ListQueue {
    private ArrayList<Object> listQueue;
    private int capacity;

    public ListQueue(int capacity) {
        this.capacity = capacity;
        this.listQueue=new ArrayList<>(capacity);
    }

    public ListQueue() {
        this(10);
    }

    //入列
    public synchronized boolean offer(Object obj){
        int length=listQueue.size();
        if (length==capacity){
            return false;
        }
        return listQueue.add(obj);
    }

    //出列
    public synchronized Object poll(){
        int length=listQueue.size();
        if (length==0){
            return null;
        }
        return listQueue.remove(0);
    }

    @Override
    public String toString() {
        return listQueue.toString();
    }
}
class TestListQueue{
    public static void main(String[] args) {
        ListQueue queue=new ListQueue(4);
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
        queue.offer("e");
        queue.offer("f");
        queue.offer("g");
        System.out.println(queue);
    }
}
