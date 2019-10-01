package zzy.test.thread;

public class Ticket implements Runnable {
    private int num = 1000;
    int count = 0;

    @Override
    public void run() {


        while (num > 0) {
            synchronized (this) {
                if (num > 0) {
                    num--;
                    count++;
                    System.out.println(Thread.currentThread().getName() + "卖出第" + count + "张票");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                }
            }
        }
    }


}
