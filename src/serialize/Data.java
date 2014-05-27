package serialize;

import java.io.Serializable;

public class Data implements Serializable {

	private int i;
	
	Data(int x) { 
		i = x; 
	}
	
	public String toString() {
		return Integer.toString(i);
	}
}
