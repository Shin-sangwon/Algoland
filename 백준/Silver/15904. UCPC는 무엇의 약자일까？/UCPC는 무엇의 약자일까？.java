import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		boolean check = false;
		int cnt = 0;
		char arr[] = {'U', 'C', 'P', 'C'};
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == arr[cnt]) {
				cnt++;
			}
			if(cnt == 4) {
				check = true;
				cnt = 0;
			}
		}
		if(check) System.out.println("I love UCPC");
		else System.out.println("I hate UCPC");
		
	}
}