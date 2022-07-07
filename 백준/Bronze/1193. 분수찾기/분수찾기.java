import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int checker2(int x) {
		int cnt = x - ((checker1(x) * (checker1(x) - 1)) / 2);
		
		return cnt;
	}
	
	static int checker1(int x) {
		int cnt = 1;
		while(true) {
			if(x <= (cnt * (cnt + 1)) / 2){
				return cnt;
			}else {
				cnt++;
			}
		}
	}
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		boolean isEven = checker1(n) % 2 == 0? true : false;
		
		if(isEven) {
			sb.append(checker2(n)).append("/").append(checker1(n) - (checker2(n) - 1));
		}else {
			sb.append(checker1(n) - (checker2(n) - 1)).append("/").append(checker2(n));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}