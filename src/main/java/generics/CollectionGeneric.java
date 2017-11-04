package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CollectionGeneric<T extends Collection> {
	
	private T content;
	
	public CollectionGeneric(T collection) {
		this.content = collection;
	}
	
	public void show(){
		System.out.println("This is " + this.content.getClass().getName());
	}
	
	public static void main(String[] args) {
//		CollectionGeneric<Integer> ins = new CollectionGeneric<Integer>(23); 错误，泛型类必须是Collection接口的实现类
//		CollectionGeneric<LinkedList> ins = new CollectionGeneric<LinkedList>(new ArrayList()); 错误，泛型参数和实际参数类型必须匹配
//		CollectionGeneric<Collection> ins = new CollectionGeneric<ArrayList>(new ArrayList()); 错误，声明必须是一个具体类，除非声明和创建的泛型类型一致
//		CollectionGeneric<List> ins = new CollectionGeneric<ArrayList>(new ArrayList()); 错误，声明必须是一个具体类，除非声明和创建的泛型类型一致
		CollectionGeneric<Collection> ins = new CollectionGeneric<Collection>(new ArrayList()); //正确
		ins.show();
		CollectionGeneric<List> ins1 = new CollectionGeneric<List>(new ArrayList()); //正确
		ins1.show();
		CollectionGeneric<Collection> ins2 = new CollectionGeneric<Collection>(new LinkedList()); //正确
		ins2.show();
		CollectionGeneric<? extends Collection> ins3 = new CollectionGeneric<ArrayList>(new ArrayList()); //正确采用通配符泛型
		ins3.show();
		CollectionGeneric<ArrayList> ins4 = new CollectionGeneric<ArrayList>(new ArrayList());
		ins4.show();
		CollectionGeneric<LinkedList> ins5 = new CollectionGeneric<LinkedList>(new LinkedList());
		ins5.show();
	}

}
