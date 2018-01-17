package bt7;

public class MyThread extends Thread {

	public void run() {
		handing();
	}

	public synchronized static void handing() {
		for (int i = 0; i <= 1; i++) {
			System.out.println(Thread.currentThread().getName() + " la cua Viet Nam");
		}
	}
}
