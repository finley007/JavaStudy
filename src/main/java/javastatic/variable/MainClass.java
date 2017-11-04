package javastatic.variable;

/**
 * 一个类的实例在gc回收之后的静态成员变量不会被回收
 *
 */
public class MainClass {
	
	private static Variable v = new Variable();
	
	public static void main(String[] args) {
		MainClass clz = new MainClass();
		clz = null;
		System.gc();
	}

}
