package thread.concurrent.deadlock;

/**
 *	测试线程死锁
 */
public class ShareResource {
	
	private String resourceA = "resourceA";
	private String resourceB = "resourceB";

	/**
	 * A资源没有释放的情况下，去请求B资源
	 */
	public void transaction1(){
		synchronized(this.resourceA){
			System.out.println("Get resource A");
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this.resourceB){
				System.out.println("Get resource B");
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * B资源没有释放的情况下，去请求A资源
	 */
	public void transaction2(){
		synchronized(this.resourceB){
			System.out.println("Get resource B");
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(this.resourceA){
				System.out.println("Get resource A");
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ShareResource resource = new ShareResource();
		Thread thread1 = new Thread(new Run1(resource));
		Thread thread2 = new Thread(new Run2(resource));
		thread1.start();
		thread2.start();
	}
	
	private static class Run1 implements Runnable{
		
		private ShareResource res;
		
		public Run1(ShareResource resource){
			this.res = resource;
		}
		
		public void run(){
			res.transaction1();
			res.transaction2();
		}
	}
	
	private static class Run2 implements Runnable{
		
		private ShareResource res;
		
		public Run2(ShareResource resource){
			this.res = resource;
		}
		
		public void run(){
			res.transaction2();
			res.transaction1();
		}
	}
}
