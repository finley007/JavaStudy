package reflect.bean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;


public class IntrospectorTest {
	
	public static void main(String[] args) {
		try {
			Bean bean = new Bean("NiYajuan", 29);
			BeanInfo beaninfo = Introspector.getBeanInfo(Bean.class); 
			PropertyDescriptor[] porpertyDescriptors = beaninfo.getPropertyDescriptors();
			for(PropertyDescriptor pd : porpertyDescriptors) {
				Method getMethod = pd.getReadMethod(); 
				if (!"class".equals(pd.getName()))
					System.out.println(pd.getName() + "=" + getMethod.invoke(bean));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static class Bean {
		
		private String name;
		private int age;

		public Bean(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	
	}

}
