package javastatic.variable;

public class Variable {
	
	public void finalize(){
		System.out.println("Finalize variable");
	}
	
	public static void main(String[] args) {
		Variable v = new Variable();
		v = null;
//		System.gc();
		try {
			Thread.currentThread().sleep(1000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
