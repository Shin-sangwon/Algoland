import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static HashSet<Integer> set;
	
	static void add(int x) {
		if(!set.contains(x)) set.add(x);
		
	}
	
	static void remove(int x) {
		if(set.contains(x)) set.remove(x);
	}
	
	static String check(int x) {
		if(set.contains(x)) return "1\n";
		else return "0\n";
		
	}
	
	static void toggle(int x) {
		if(set.contains(x)) set.remove(x);
		else set.add(x);
	}
	
	static void all() {
		set = new HashSet<>(20);
		for(int i = 1; i <= 20; i++) set.add(i);
	}
	
	static void empty() {
		set = new HashSet<>(20);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		set = new HashSet<>(20);
		
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			switch(tmp) {
			case "add" : add(Integer.parseInt(st.nextToken())); break;
			case "remove": remove(Integer.parseInt(st.nextToken())); break;
			case "check" : sb.append(check(Integer.parseInt(st.nextToken()))); break;
			case "toggle": toggle(Integer.parseInt(st.nextToken())); break;
			case "all": all(); break;
			case "empty" : empty(); break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}