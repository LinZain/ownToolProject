package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public void singlePool() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            TestThread thread = new TestThread("single" + i);
            singleThreadPool.execute(thread);
        }
    }

    public void fixedPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            TestThread thread = new TestThread("fixed" + i);
            fixedThreadPool.execute(thread);
        }
    }

    public void cachePool() {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            TestThread thread = new TestThread("cache" + i);
            cacheThreadPool.execute(thread);
        }
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
//      pool.singlePool();
//      pool.cachePool();
        pool.fixedPool();
    }
}

class TestThread implements Runnable {
    private String prefix;

    public TestThread(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void run() {
        int i = 0;
        boolean result = true;
        while (result) {
            System.out.println(prefix + "_" + i);
            i++;
            if (i == 20) {
                result = false;
            }
            try {
                Thread.sleep(2000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
