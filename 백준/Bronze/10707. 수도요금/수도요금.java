import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int max = Integer.parseInt(br.readLine());
		int yy = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		int price1 = x * p;
		int price2;
		if(p >= max) {
			price2 = y + (p-max) * yy;
		}else {
			price2 = y;
		}
				
		
		bw.write(price1 < price2? price1+" " : price2+" ");
		bw.flush();
		bw.close();
		br.close();
		
	}
}