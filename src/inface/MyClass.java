package inface;

public class MyClass implements MyInterface {

	@Override
	public void showName() {
		// TODO Auto-generated method stub
		System.out.println(count);
//		count++; count默认是final的，不能修改
		System.out.println(name); //String变量本身就是final的
//		name = "ss"; 其引用也无法修改，String的修改就指修改引用
	}
	
	public static void main(String[] args) {
		MyClass myClz = new MyClass();
		myClz.showName();
	}

}
