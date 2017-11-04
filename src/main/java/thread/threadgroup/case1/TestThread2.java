package thread.threadgroup.case1;

public class TestThread2 extends TestThread1 {

	TestThread2(ThreadGroup g, String name) {
		super(g, name);
		start();
	}
	
	public void run() {
		ThreadGroup g = getThreadGroup().getParent().getParent();
		g.list();
		Thread[] gAll = new Thread[g.activeCount()];
		g.enumerate(gAll);
		for(int i = 0; i < gAll.length; i++) {
			gAll[i].setPriority(Thread.MIN_PRIORITY);
			((TestThread1)gAll[i]).f();
		}
		g.list();
	}
		
}
