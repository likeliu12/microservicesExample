package concurrent.lock;

import java.util.Random;

class TestLock implements Runnable {
    private Friend bower;
    private Friend bowee;

    public TestLock(Friend bower, Friend bowee) {
        this.bower = bower;
        this.bowee = bowee;
    }

    public void run() {
        Random random = new Random();
        for (;;) {
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {}
            bowee.bow(bower);
        }
    }
    
    public static void main(String[] args) {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new TestLock(alphonse, gaston)).start();
        new Thread(new TestLock(gaston, alphonse)).start();
    }
}