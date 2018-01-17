package bt9;


public class TheThread extends Thread {

	private int mi,ma;
	
	public TheThread(int min, int max) {
		this.mi = min;
		this.ma = max;
	}
	@Override
	public void run() {
		handling();
	}
	@SuppressWarnings("unchecked")
	public synchronized void handling(){
	
		for(int i = mi ;i < ma; i++){
			if(Prime.CalPrime(i)==true && i!=0){
				TheMain.Arl.add(i);
			}
		} 
	}
}
