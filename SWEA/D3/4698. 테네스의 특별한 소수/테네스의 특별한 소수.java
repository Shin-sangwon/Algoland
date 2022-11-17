import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution{
	
	public static boolean isContain(int i, int D) {
		
		String index = String.valueOf(i);
		String target = String.valueOf(D);
		
		return index.contains(target)? true : false;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean arr[] = new boolean[1000001];
		arr[1] = true;
		for(int i = 2; i < arr.length; i++) {
			if(arr[i]) continue;
			for(int j = i * 2; j < arr.length; j += i) {
				arr[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int totalCase = Integer.parseInt(br.readLine());
		int idx = 1;
		while(totalCase-->0) {
			st = new StringTokenizer(br.readLine());
			final int D = Integer.parseInt(st.nextToken());
			final int A = Integer.parseInt(st.nextToken());
			final int B = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			for(int i = A; i <= B; i++) {
				if(!arr[i] && isContain(i, D)) {
					answer++;
				}
			}
			
			sb.append(String.format("#%d %d\n", idx++, answer));
			
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
