package generics;

public class GenNormal {

	private Object ob;
	
	public GenNormal(Object ob){
		this.ob = ob;
	}
	
	public Object getOb(){
		return ob;
	}
	
	public void setOb(Object ob){
		this.ob = ob;
	}
	
	public void showType(){
		System.out.println("T的实际类型是：" + ob.getClass().getName());
	}
	
}
