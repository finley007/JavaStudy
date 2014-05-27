package exception;

public class ExceptionTest {
	
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test2();
		test3();
	}
	
	//只有Exception是需要强制捕捉和处理的
	private static void test1() throws Exception{
		throw new Exception();
	}
	
	private static void test2(){
		throw new Error();
	}
	private static void test3(){
		throw new RuntimeException();
	}
	

}
