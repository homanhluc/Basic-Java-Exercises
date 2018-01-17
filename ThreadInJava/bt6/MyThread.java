package bt6;

public class MyThread extends Thread {

	public void run() {
		for (int i = 0; i <= 2; i++) {
			System.out.println(Thread.currentThread().getName() + " la cua Viet Nam");
		}
	}
}
