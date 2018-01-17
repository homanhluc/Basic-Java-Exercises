package bt10;

import java.util.ArrayList;
import java.util.Scanner;

public class TheMain {	
	@SuppressWarnings("rawtypes")
	public static ArrayList Mang = new ArrayList();
	public static int kq;
	public static int vitri = -1;
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		//Tạo mảng
		RandomArl.CreateArr();
		System.out.println(Mang);
		Scanner input = new Scanner(System.in);

		System.out.print("Nhập K: ");
		kq= input.nextInt();
		
		TheThread t1 = new TheThread("Left",0,100);
		TheThread t2 = new TheThread("Right",100,200);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		if(vitri==-1){
			System.out.println("Khong tim thay!");
		}else
		System.out.println(vitri);
		
	}
}
