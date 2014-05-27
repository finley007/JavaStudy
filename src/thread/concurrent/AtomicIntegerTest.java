package thread.concurrent;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 想测试高并发下i++的非线程安全性，并通过AtomicInteger类加以改进
 */
public class AtomicIntegerTest extends Thread{
	public static int count = 0;
	public static AtomicInteger count1 = new AtomicInteger(0); 
	public static volatile int count2 = 0;
	private static int concurrentNum = 1000;
	private CountDownLatch countDownLatch; 
	private int loopNum = 500;
	
	public static void main(String[] args) {
		Date start = new Date();
		CountDownLatch cdl = new CountDownLatch(concurrentNum);
		for(int i = 0;i < concurrentNum;i++){
			AtomicIntegerTest test = new AtomicIntegerTest();
			test.setCountDownLatch(cdl);
			test.start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println("Time consuming:" + (end.getTime() - start.getTime()));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		while(loopNum -- > 0){
			count ++;
			System.out.println(count);
//			count1.getAndIncrement();
//			System.out.println(count1);
//			count2 ++;
//			System.out.println(count2);
		}
		countDownLatch.countDown();
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
}
