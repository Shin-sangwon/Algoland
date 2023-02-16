import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static StringBuilder sb;
	static int[] arr;
	static boolean[] visited;
	static int n;
	
	private static void perm(int cnt, int flag) { // 선택한 숫자
		
		if(n == cnt) {
			print();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			
			if((flag & (1<<i)) != 0) continue;
			arr[cnt] = i + 1;
			perm(cnt + 1, flag | (1 << i));
		}
	}
	
	private static void print() {
		
		for(int x : arr) {
			sb.append(x + " ");
		}
		sb.append("\n");
		return;
	}
	

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		perm(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
	}

}
