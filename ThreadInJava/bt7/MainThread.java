package bt7;

public class MainThread {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();	
		MyThread t3 = new MyThread();
		t1.setName("Truong Sa");
		t2.setName("Hoang Sa");
		t3.setName("Phu Quoc");
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		System.out.println(t3.getName());
		
		t1.sleep(2000);
		t1.start();
		t2.sleep(2000);
		t2.start();
		t3.sleep(2000);
		t3.start();
		
	}
	
}
