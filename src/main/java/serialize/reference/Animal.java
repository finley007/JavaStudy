package serialize.reference;

import java.io.Serializable;

public class Animal implements Serializable {

	String name;
	House preferredHouse;
	
	Animal(String nm, House h) {
		name = nm;
		preferredHouse = h;
	}
	
	public String toString() {
		return name + "[" + super.toString() +
		"], " + preferredHouse + "\n";
	}
}
