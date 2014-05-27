package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Item {
	
	public static void main(String[] args) {
		Item a = new Item("b",1);
		Item b = new Item("b",1);
		Set<Item> set = new HashSet<Item>();
		set.add(a);
		set.add(b);
		set.add(null);
		System.out.println(set.size());
		for(Iterator<Item> itor = set.iterator();itor.hasNext();){
			System.out.println(itor.next().toString());
		}
	}
	
	private String _name;
	private int _num;
	
	public Item(String name,int num){
		this._name = name;
		this._num = num;
	}

	public int hashCode(){
		System.out.println(this._num);
		return this._num;
	}
	
	public boolean equals(Object obj){
		System.out.println("equals");
		return this.getName().equals(((Item)obj).getName());
	}

	public String getName() {
		return _name;
	}
	
	public String toString(){
		return this._name + "_" + this._num;
	}
}
