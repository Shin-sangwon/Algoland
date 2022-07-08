import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static final long TARGET = 1234567891;
	static final long FACTOR = 31;
	
	static long power(int charTmp, int i) {
		
		long num = charTmp;
		
		if(i == 0) return charTmp;
		
		while(i-- != 0) {
			num *= FACTOR;
			num %= TARGET;
		}
		
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//97
		int n = Integer.parseInt(br.readLine());
		String tmp = br.readLine();
		long ans = 0;
		
		for(int i = 0; i < n; i++) {
			int charTmp = tmp.charAt(i) - 96;
			ans += power(charTmp, i);
			
		}
		
		bw.write((ans % TARGET)+"");
		bw.flush();
		bw.close();
		
		
	}
}