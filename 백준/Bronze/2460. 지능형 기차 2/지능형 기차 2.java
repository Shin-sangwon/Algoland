import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int num = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			num -= Integer.parseInt(st.nextToken());
			num += Integer.parseInt(st.nextToken());		 
			if(num > 10000) num = 10000;
			if(num < 0) num = 0;
			max = Math.max(max, num);
		}
		
		
		bw.write(max+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
}