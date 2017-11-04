package thread.concurrent.staticmthd;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

/**
 *	测试并发状况下对static方法调用的性能
 *	一个在多线程中调用静态方法
 *  另一个创建过个实例，分别调用成员方法
 */
public class ConcurrentStaticMethodTest {
	
	private static PrintWriter writer;

	public static void main(String[] args) {
		String filePath = "F:\\aa.txt";
		try {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int threadNum = 50;
		for(int i = 0;i < threadNum;i++){
			Thread thrd = new Thread(new Runnable(){
				public void run(){
//					ConcurrentStaticMethodTest test = new ConcurrentStaticMethodTest();
//					test.printThreadInfoIns(Thread.currentThread().getName());
					ConcurrentStaticMethodTest.printThreadInfo(Thread.currentThread().getName());
				}
			});
			thrd.setName("Thread" + (i + 1));
			thrd.start();
		}
		
	}
	
	private static void printThreadInfo(String threadNo){
		int count = 10000;
		while(count -- > 0){
			writer.println(threadNo + "---" + count + "---" + (new Date()).getTime());
			writer.flush();
			System.out.println(threadNo + "---" + count + "---" + (new Date()).getTime());
		}
	}
	
	private void printThreadInfoIns(String threadNo){
		int count = 10000;
		while(count -- > 0){
			writer.println(threadNo + "---" + count + "---" + (new Date()).getTime());
			writer.flush();
			System.out.println(threadNo + "---" + count + "---" + (new Date()).getTime());
		}
	}
}
