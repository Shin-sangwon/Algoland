import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;
		
		int index = 1;
		int TC = 10;
		
		while(TC-->0) {
			
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			stack = new Stack<>();
			int answer = 1;
			
			for(int i = 0; i < n; i++) {
				
				char now = str.charAt(i);
				
				if(now == '{' || now == '(' || now == '[' || now == '<') {
					stack.push(now);
					continue;
				}
				
				if(now == '}') {
					if(stack.peek() == '{') {
						stack.pop();
						continue;
					}
					answer = 0;
					break;
				}
				
				if(now == ')') {
					if(stack.peek() == '(') {
						stack.pop();
						continue;
					}
					answer = 0;
					break;
				}
				
				if(now == ']') {
					if(stack.peek() == '[') {
						stack.pop();
						continue;
					}
					answer = 0;
					break;
				}
				
				if(now == '>') {
					if(stack.peek() == '<') {
						stack.pop();
						continue;
					}
					answer = 0;
					break;
				}
				
			}
			
			sb.append(String.format("#%d %d\n", index++, answer));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
