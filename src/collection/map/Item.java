package collection.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *	测试hashCode和equals方法对HashMap的影响
 */
public class Item {
	
	public static void main(String[] args) {
		Item a = new Item("a",1);
		Item b = new Item("b",1);
		Map<Item,String> map = new HashMap<Item,String>();
		map.put(a, a.toString());
		map.put(b, b.toString());
		map.put(null, null);
		System.out.println(map.size());
		for(Iterator itor = map.entrySet().iterator();itor.hasNext();){
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
		return this._num;
	}
	
	public boolean equals(Object obj){
		return this.getName().equals(((Item)obj).getName());
	}

	public String getName() {
		return _name;
	}
	
	public String toString(){
		return this._name + "_" + this._num;
	}
}
