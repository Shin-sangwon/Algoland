import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		final char push = '+';
		final char pop = '-';
		
		int count = Integer.parseInt(br.readLine());
		int start = 1;
		
		while(count-->0) {
			
			int n = Integer.parseInt(br.readLine());
			
			if(start <= n) {
				for(int i = start; i <= n; i++) {
					stack.push(i);
					sb.append(push+"\n");
				}				
				start = stack.pop() + 1;
				sb.append(pop+"\n");	
				continue;
			}
			
			if(start > n) {
				if(stack.peek() != n) {
					sb = new StringBuilder();
					sb.append("NO");
					break;
				}	
				stack.pop();
				sb.append(pop+"\n");
			}						
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
				
	}
}