package reflect.proxy;

public class Man implements People {
	
	public Man(String name){
		this.name = name;
	}
	
	private String name;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSex() {
		// TODO Auto-generated method stub
		return 1;
	}

}
