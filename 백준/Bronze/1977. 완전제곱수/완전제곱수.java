import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int ans = 0;
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i = 1; i <= 100; i++) {
			if((i * i) >= a && (i * i) <= b) {
				al.add(i);
			}
			
			if((i * i) > b) {
				break;
			}
		}
		
		if(al.size() == 0) {
			System.out.println(-1);
		}else {
			for(int x : al) ans += x * x;
			System.out.println(ans);
			System.out.println(al.get(0) * al.get(0));
		}
	}
}