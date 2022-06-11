import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		int price = Integer.parseInt(br.readLine());
		
		
		bw.write(sum >= price * 2? sum - (price * 2)+"" : sum+"");
		bw.flush();
		bw.close();
				
	}
}