package bt10;

public class TheThread extends Thread {

	private int min, max;
	@SuppressWarnings("unused")
	private String threadName;
	public static boolean kt = true;
	public TheThread(String name, int min, int max) {
		this.min = min;
		this.max = max;
		this.threadName = name;

	}
	public void run() {
		handling();
	}
	public void handling() {
		for (int i = min; i < max; i++) {
			if (kt == true) {
				if (TheMain.Mang.get(i).equals(TheMain.kq) == kt) {
					TheMain.vitri = i;
					kt = false;
					break;
				}
			} else {
				break;
			}
		}
	}
}
