package bt9;

import java.util.ArrayList;

public class TheMain {

	@SuppressWarnings("rawtypes")
	public static ArrayList Arl = new ArrayList();
	public static void main(String[] args) throws InterruptedException {
		TheThread t1 = new TheThread(0,1000);
		TheThread t2 = new TheThread(1000,2000);
		TheThread t3 = new TheThread(2000,3000);
		TheThread t4 = new TheThread(3000,4000);
		TheThread t5 = new TheThread(4000,5000);
		
		t1.start();
		t1.join();
		
		t2.start();
		t2.join();
		
		t3.start();
		t3.join();
		
		t4.start();
		t4.join();
		
		t5.start();
		t5.join();
		System.out.println(Arl);
		
	}

}
