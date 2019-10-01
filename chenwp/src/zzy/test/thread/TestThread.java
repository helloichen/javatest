package zzy.test.thread;

public class TestThread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    System.out.println(currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
