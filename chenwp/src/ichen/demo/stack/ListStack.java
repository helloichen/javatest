package ichen.demo.stack;

import java.util.ArrayList;

public class ListStack {
    private ArrayList<Object> listStack;
    private int capacity;

    public ListStack(int capacity) {
        this.capacity=capacity;
        this.listStack = new ArrayList<>(capacity);
    }

    public ListStack() {
        this(10);
    }

    //压栈
    public synchronized boolean push(Object obj) {
        int length = listStack.size();
        if (length == capacity) {
            return false;
        }
        return listStack.add(obj);
    }

    //弹栈
    public synchronized Object pop() {
        int length = listStack.size();
        if (length == 0) {
            return null;
        }
        return listStack.remove(length - 1);
    }

    @Override
    public String toString() {
        return listStack.toString();
    }
}
class TestListStack{
    public static void main(String[] args) {
        ListStack stack=new ListStack(3);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        stack.push("d");
        stack.push("e");
        System.out.println(stack);
    }
}
