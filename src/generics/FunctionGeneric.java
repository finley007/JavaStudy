package generics;

import java.math.BigDecimal;

public class FunctionGeneric {
	
	public static void main(String[] args) {
//		Integer i = FunctionGeneric.getIns("java.lang.String"); 错误，类型不匹配
		String str = FunctionGeneric.getIns("java.lang.String"); //正确
		
	}
	
	
	//<E>为泛型参数，放在返回类型之前，方法会根据返回类型自动进行转换
	private static <E> E getIns(String className){
		try {
			return (E)Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
