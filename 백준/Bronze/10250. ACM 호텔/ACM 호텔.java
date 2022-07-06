import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 층 수, 방 수, 몇 번째 손님인지
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt-->0) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int ans = n % h == 0? (h * 100) + (n / h) : (n % h) * 100 + (n / h)+1;
			bw.write(ans+"\n");
		}
		
		bw.flush();
		bw.close();
		
	}
}