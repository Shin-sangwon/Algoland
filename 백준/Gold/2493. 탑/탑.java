import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		int value;
		int index;
		
		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] answer = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(new Node(arr[0], 1));
		
		Loop1:
		for(int i = 1; i < n; i++) {	
			
			// 레이저 신호 받을 때 까지 돌리기
			if(stack.peek().value < arr[i]) {
				
				while(!stack.isEmpty()) {
					
					if(stack.peek().value >= arr[i]) {
						answer[i] = stack.peek().index;
						stack.push(new Node(arr[i], i+1));
						continue Loop1;
					}
					
					stack.pop();
				}
				
				if(stack.size() == 0) {
					stack.push(new Node(arr[i], i+1));
					continue Loop1;
				}
			
			}
			
			answer[i] = stack.peek().index;
			stack.push(new Node(arr[i], i+1));
			
			
			
		}
		
		for(int x : answer) sb.append(x + " ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
