package bt6;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		MyThread t3 = new MyThread();
		t1.setName("Truong Sa");
		t2.setName("Hoang Sa");
		t3.setName("Phu Quoc");
		t1.start();
		Thread.sleep(50);
		t2.start();
		Thread.sleep(100);
		t3.start();
		
	}
	
}
