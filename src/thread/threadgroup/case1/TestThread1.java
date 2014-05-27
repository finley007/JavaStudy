package thread.threadgroup.case1;

public class TestThread1 extends Thread {

	private int i;
	
	TestThread1(ThreadGroup g, String name) {
		super(g, name);
	}
	
	void f() {
		i++; // modify this thread
		System.out.println(getName() + " f()");
	}
	
}
