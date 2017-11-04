package exception;

public class ExceptionTest {
	
	public static void main(String[] args) {
		try {
			test1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		test2();
		test3();
	}
	
	//å�ªæœ‰Exceptionæ˜¯éœ€è¦�å¼ºåˆ¶æ�•æ�‰å’Œå¤„ç�†çš„
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
