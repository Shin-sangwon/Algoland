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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 낮에 a만큼 올라가고 밤에 b만큼 미끄러짐, v 나무막대를 올라갈 것임
		// 정상에 도달한다면 미끄러지지 않음
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		//정점에 도달하면 미끄러지지 않으므로, 나누어 떨어지면 그대로 아니면 하루를 더 더해줘야 함
		int ans = (v-b) % (a-b) == 0? (v-b) / (a-b) : (v-b) / (a-b) + 1;
		
		bw.write(ans+"");
		bw.flush();
		bw.close();
		
	}
}