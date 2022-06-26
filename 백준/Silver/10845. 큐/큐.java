import java.util.*;
import java.io.*;

public class Main {
	
	
	
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void push(int x) {
		al.add(0, x);	
	}
	
	static void pop() {
		
		if(al.size() == 0) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(al.get(al.size()-1)).append("\n");
		al.remove(al.size()-1);
	}
	
	static void size() {
		if(al.size() == 0) {
			sb.append(0).append("\n");
			return;
		}
		
		sb.append(al.size()).append("\n");
	}
	
	static void empty() {
		
		if(al.size() == 0) {
			sb.append(1).append("\n");
			return;
		}
		
		sb.append(0).append("\n");
	}
	
	static void front() {
		
		if(al.size() == 0) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(al.get(al.size()-1)).append("\n");
		
	}
	
	static void back() {
		
		if(al.size() == 0) {
			sb.append(-1).append("\n");
			return;
		}
		
		sb.append(al.get(0)).append("\n");
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()){
				case "push": push(Integer.parseInt(st.nextToken())); break;
				case "pop": pop(); break;
				case "size": size(); break;
				case "empty": empty(); break;
				case "front": front(); break;
				case "back": back(); break;
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}