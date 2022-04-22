import java.util.*;
import java.io.*;

public class Main {
	
	static int num(int x) {
		int a = 0;
		
		while(x != 0) {
			x /= 10;
			a++;
		}
		
		return a;
	}
		
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt-- != 0) {
			int tmp = Integer.parseInt(br.readLine());
			int target = num(tmp);
			
			if(tmp == ((tmp * tmp) % (int)(Math.pow(10, target)))){
				bw.write("YES");
				bw.newLine();
			}else {
				bw.write("NO");
				bw.newLine();
			}
		}
		
		bw.flush();
		bw.close();
	}
}