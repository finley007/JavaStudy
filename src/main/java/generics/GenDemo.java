package generics;

public class GenDemo {
	
	public static void main(String[] args) {
		Gen<Integer> intOb = new Gen<Integer>(88);
		intOb.showType();
		int i = intOb.getOb();
		System.out.println("value=" + i);
		System.out.println("-------------------------");
		
		GenNormal intOb1 = new GenNormal(88);
		intOb.showType();
		i = (Integer)intOb.getOb();
		System.out.println("value=" + i);
		System.out.println("-------------------------");
		
		Gen<String> strOb = new Gen<String>("Hello Gen!");
		strOb.showType();
		String s = strOb.getOb();
		System.out.println("value=" + s);
		System.out.println("-------------------------");
		
		GenNormal strOb1 = new GenNormal("Hello Gen!");
		strOb.showType();
		s = (String)strOb1.getOb();
		System.out.println("value=" + s);
		System.out.println("-------------------------");
	}
}
