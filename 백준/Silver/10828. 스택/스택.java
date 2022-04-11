import java.io.*;
import java.util.*;

public class Main {
	
	static int stack[];
	static int pos = 0;
	
	static void push(int x) {
		stack[pos++] = x;
	}
	
	static void pop(){
		if(pos == 0) System.out.println(-1);
		else {
			System.out.println(stack[pos-1]);
			stack[pos-1] = 0;
			pos--;
		}
	}
	
	static void size() {
		System.out.println(pos);
		
	}
	
	static void empty() {
		if(pos==0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	static void top() {
		if(pos==0){
			System.out.println(-1);
		}else {
			System.out.println(stack[pos-1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		stack = new int[10004];
		int cnt = Integer.parseInt(br.readLine());
		while(cnt != 0) {
			cnt--;
			String tmp1 = br.readLine();
			StringTokenizer st = new StringTokenizer(tmp1, " ");
			String tmp2 = st.nextToken();
			switch(tmp2){
				case "pop" : 
					pop();
					break;
				case "size" : 
					size();
					break;
				case "empty" : 
					empty();
					break;
				case "top" : 
					top();
					break;
				case "push" : 
					push(Integer.parseInt(st.nextToken()));
					break;
			}
		}
		
	}

}