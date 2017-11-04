package thread.daemon;

public class DaemonSpawn extends Thread {

	public DaemonSpawn(int i) {
		System.out.println("DaemonSpawn " + i + " started");
		start();
	}
	
	public void run() {
		while(true)
		yield();
	}
}
