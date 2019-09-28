package ichen.demo.stack;

import java.util.Random;

public class ArrayStack {
    private char[] arr = new char[5];
    private int index;

    public synchronized void push(char c) {
        if (isFull()) {
            return;
        }
        arr[index] = c;
        index++;
    }

    public synchronized char pop() {
        if (isEmpty()) {
            return ' ';//空格表示没有数据
        }
        index--;
        char c = arr[index];
        return c;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == 5;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        Producer p = new Producer(stack);
        Consumer c = new Consumer(stack);
        c.start();
        p.start();
    }
}

class Producer extends Thread {
    private ArrayStack stack;

    public Producer(ArrayStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {

        while (true) {
            char c = (char) ('a' + new Random().nextInt(26));
            synchronized (stack) {
                while (stack.isFull()) {
                    try {
                        stack.wait();
                    } catch (InterruptedException e) {
                    }
                }
                stack.push(c);
                System.out.println("<------" + c);
                stack.notifyAll();
            }
        }
    }
}

class Consumer extends Thread {
    private ArrayStack stack;

    public Consumer(ArrayStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (stack) {
                while (stack.isEmpty()) {
                    try {
                        stack.wait();
                    } catch (InterruptedException e) {
                    }
                }
                char c = stack.pop();
                System.out.println("--> " + c);
                stack.notifyAll();
            }
        }
    }
}
