package reflect.proxy;

public class Woman implements People {
	
	private String name;
	
	public Woman(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getSex() {
		// TODO Auto-generated method stub
		return 1;
	}

}
