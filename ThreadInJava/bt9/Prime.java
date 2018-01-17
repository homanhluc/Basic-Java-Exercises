package bt9;

public class Prime {
	public static boolean CalPrime(int n){
		int dem=0;
	    if(n==1)
	       dem++;
	    else
	    {
	       for (int i=2; i<=n/2;i++)
	       {
	          if(n%i==0)
	          dem++;
	       }
	    }
	    if (dem==0){
	       return true;
	    }
	    else
	       return false;
	}
}