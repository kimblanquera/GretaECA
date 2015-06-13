import java.util.concurrent.locks.*;

import Bean.Speech;


public class Process {

	private final Lock procLock = new ReentrantLock();
	private Speech s;
	
	public Process(){}
	
	public Process(Speech sp) {
		
		s = sp;
		
	}
	
	public Speech getSp() {
		
		return s;
		
	}
	
	public void setSp(Speech x) {
		
		this.s = x;
		
	}
	
	public void Process() {
		
		procLock.lock();
		try {
			
			Long time = (long)(Math.random() * 10000);
			System.out.println("\n" + Thread.currentThread().getName() + " is running");
			Thread.sleep(time);
			
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			System.out.println("\nProcess has finished.");
			procLock.unlock();
		
		}
		
	}
}
