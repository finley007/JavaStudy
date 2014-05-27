package javastatic;

public class SubClass extends BaseClass {

	protected static String className = "SubClass";
	
	protected static void showName(){
		System.out.println(className);
	}
	
	public static void main(String[] args) {
		//静态方法和静态变量都存储于静态池中，在编译的时候就确定了
		//下型构造是在运行时进行的，所以无论静态变量还是静态方法都没有办法overwrite
		//下面的两行代码说明了这个事实
		BaseClass clz = new SubClass();
		clz.showName();
	}
}
