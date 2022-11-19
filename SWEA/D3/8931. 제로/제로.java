import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


class Solution{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
	
		Stack<Integer> stack;
		int testCase = Integer.parseInt(br.readLine());
		int idx = 1;
		
		while(testCase-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			stack = new Stack<>();
			
			while(n -- > 0) {
				int tmp = Integer.parseInt(br.readLine());
				
				if(tmp == 0) {
					stack.pop();
					continue;
				}
				
				stack.push(tmp);
			}
			
			int ans = 0;
			for(int x : stack) {
				ans += x;
			}
			
			sb.append(String.format("#%d %d\n", idx++, ans));
		
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
