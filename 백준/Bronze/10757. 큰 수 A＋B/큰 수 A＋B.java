import java.util.*;
import java.math.*;
public class Main {
	
	
					
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		
		a = a.add(b);
		System.out.println(a.toString());
	}
}