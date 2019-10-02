package zzy.test.thread;

public class TestNumLetter {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                synchronized (String.class) {
                    for (int i = 1; i <= 52; i++) {
                        System.out.print(i);
                        if (i % 2 == 0) {
                            String.class.notifyAll();
                            try {
                                String.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }.start();
        new Thread() {
            @Override
            public void run() {
                synchronized (String.class) {
                    for (int i = 65; i <= 90; i++) {
                        System.out.print((char) i);
                        String.class.notifyAll();
                        if (i==90) return;
                        try {
                            String.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}
