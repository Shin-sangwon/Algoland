import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ans = 0;
		
		int target = Integer.parseInt(br.readLine());
		
		while(target != 0) {
			ans += Math.pow(target % 10, 5);
			target /= 10;
		}
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
				
	}
}