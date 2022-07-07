import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Loop1:
		while(true) {
			//input
			String tmp = br.readLine();
			
			//종료조건
			if(tmp.equals(".")) break;
			
			//stack 선언
			Stack<Character> stack = new Stack<>();
			
			// ( [은 stack에 push하기
			for(int i = 0; i < tmp.length(); i++) {
				if(tmp.charAt(i) == '(' || tmp.charAt(i) == '[') {
					stack.push(tmp.charAt(i));
				}
				// ) 입력 처리
				if(tmp.charAt(i) == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						sb.append("no\n");
						continue Loop1;
					}
					stack.pop();
				}
				// ] 입력 처리
				if(tmp.charAt(i) == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						sb.append("no\n");
						continue Loop1;
					}
					stack.pop();
				}
			}
			
			sb.append(stack.isEmpty()? "yes\n" : "no\n");
			
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}