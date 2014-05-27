package reflect.proxy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People woman = new Woman("BaiJie");
		Object proxy = ProxyFactory.getProxy(woman);
		woman = (People)proxy;
		System.out.println(woman.getName());
		System.out.println(woman.getSex());
	}

}
