package thread.message;

import java.io.IOException;
import java.util.LinkedList;

public class ProdCons {
	
	/*list是整个代码中的同步对象，因此也是
	要wait()和notifyAll()的对象*/
	
	protected LinkedList list = new LinkedList();
	protected int MAX = 10;
	protected boolean done = false; //也是由list的锁保护
	
	/*内部类扮演生产者一方*/
	class Producer extends Thread {
		
		public void run(){
			while(true){
				Object justProduced = getRequestFromNetwork();
				//从网络获取请求，在同步化块之外
				//我们只要模拟从客户端读取
				//如果客户端的用户去个咖啡了，可能要等几个小时
				synchronized(list){
					while (list.size() == MAX) //队满
					try{
						System.out.println("Producer WAITING");
						list.wait(); //限制大小
					}catch (InterruptedException ex){
						System.out.println("Producer INTERRUPTED");
					}
					list.addFirst(justProduced);
					if(done)
						break;
					list.notifyAll(); //必须拥有锁
					System.out.println("Produced 1; List size now " + list.size());
					
				}
			}
		}
		
		Object getRequestFromNetwork(){ //模拟从客户端读取
			try {
				Thread.sleep(10); //模拟读时所花的时间
			}catch(InterruptedException ex){
				System.out.println("Producer Read INTERRUPTED");
			}
			return new Object();
		}
	}

	/*表示Consumer端的内部类*/
	class Consumer extends Thread {
		public void run(){
			while(true){
				Object obj = null;
				int len = 0;
				synchronized (list) {
					while(list.size() == 0){
						try {
							System.out.println("CONSUMER WAITING");
							list.wait(); //必须拥有锁
						}catch(InterruptedException ex){
							System.out.println("CONSUMER INTERRUPTED");
						}
					}
					if(done)
						break;
					obj = list.removeLast();
					list.notifyAll();
					len = list.size();
					System.out.println("List size now " + len);
				}
				process(obj); //在同步化块之外
			}
		}
		
		void process(Object obj){
			//Thread.sleep(nnn) //模拟所花时间
			System.out.println("Consuming object " + obj);
		}
	}
	
	ProdCons(int nP,int nC){
		for(int i=0; i<nP;i++)
			new Producer().start();
		for(int i=0; i<nC;i++)
			new Consumer().start();
	}
	
	public static void main(String[] args) 
		throws IOException, InterruptedException {
		//启动生产者和消费者
		int numProducers = 2;
		int numConsumers = 2;
		ProdCons pc = new ProdCons(numProducers,numConsumers);
		
		//运行，30秒
		Thread.sleep(30 * 1000);
		
		//模拟结束
		synchronized(pc.list){
			pc.done = true;
			pc.list.notifyAll();
		}
	}
}
