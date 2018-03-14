package chapter20;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2018/3/13
 */
public class ReentrantLockSample {
    private Lock lock = new ReentrantLock();

    private AtomicInteger index;
    public void test(){
        lock.lock();

        while (!index.compareAndSet(1,1));
    }

/***********************不可重入锁*************************/

    private boolean isLocked = false;

    public synchronized void unEntrantlock() throws InterruptedException {
        Thread test = Thread.currentThread();
        while (isLocked){
            wait();
        }
        isLocked = true;
    }

    public  synchronized void unEntrantunlock(){
        isLocked = false;
        notify();
    }

/************************可重入锁******************************/
    private volatile Thread lockBy = null;

    private volatile int count;

    public synchronized void reentrantlock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked&&thread != lockBy){
            wait();
        }
        isLocked = true;
        lockBy = thread;
        count++;
    }

    public synchronized void reentrantUnlock(){
        Thread thread = Thread.currentThread();
        while (isLocked&&thread==lockBy){
            notify();
            isLocked = false;
            lockBy = null;
        }
    }

}
