package zzy.test;

public class TestThread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 20; i++) {
                    System.out.println(currentThread().getName());
                }
            }
        }.start();

        for (int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
