import java.util.*;
import java.io.*;

public class Main {
	
	public static String method(String x) {
		
		int tmp = 0;
		
		for(int i = 0; i < x.length(); i++) {
			tmp += Character.getNumericValue(x.charAt(i));
		}
		
		
		return String.valueOf(tmp);
	}
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String tmp = br.readLine();
		int cnt = 0;
		
		while(tmp.length() != 1) {
			cnt++;
			tmp = method(tmp);
		}
			
		bw.write(cnt+""+'\n');
		bw.write(Integer.parseInt(tmp) % 3 == 0? "YES":"NO");
		bw.flush();
		bw.close();
		
	}

}