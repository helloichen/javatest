package zzy.test.thread;

public class TestThread2 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        Thread t1=new Thread(ticket,"t1");
        Thread t2=new Thread(ticket,"t2");
        Thread t3=new Thread(ticket,"t3");
        t1.start();
        t2.start();
        t3.start();

    }
}
