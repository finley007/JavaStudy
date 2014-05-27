package thread.domain;

public class ThreadDomain extends Thread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
		System.out.println("out of domain");
	}
	
	private static void test(){
		ThreadDomain domain = new ThreadDomain();
		domain.start();
		domain = null;
	}
	
	public void run(){
		while(true){
			System.out.println("run");
		}
	}

}
