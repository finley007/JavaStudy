package reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		System.out.println("Begin call " + arg1.getName());
		result = arg1.invoke(target, arg2);
		System.out.println("After call " + arg1.getName());
		return result;
	}

}
