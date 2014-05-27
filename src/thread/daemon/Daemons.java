package thread.daemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Daemons {
	public static void main(String[] args) {
		Thread d = new Daemon();
		System.out.println("d.isDaemon() = " + d.isDaemon());
		// Allow the daemon threads to finish
		// their startup processes:
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Waiting for CR");
		try {
			stdin.readLine();
		} catch(IOException e) {}
		}
}
