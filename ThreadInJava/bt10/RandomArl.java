package bt10;

import java.util.Random;

public class RandomArl {
	@SuppressWarnings("unchecked")
	public static void CreateArr(){
		Random rand = new Random();
		for(int i = 0; i<=200; i++){
			TheMain.Mang.add(rand.nextInt(10000));
		}
	}
}
