import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static int[] arr;
	static int[] num;
	static boolean[] visited;
	static int n,m;
	
	private static void recursive(int depth, int start) {
		
		if(depth == m) {
			set.add(print());
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			
			num[depth] = arr[i];
			recursive(depth + 1, i);
			
		}
		
		
	}
	
	private static String print() {
		
		StringBuilder sb = new StringBuilder();
		
		for(int x : num) {
			sb.append(x + " ");
		}
		sb.append("\n");
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = Stream.of(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)				
						  .sorted()
						  .toArray();
		
		num = new int[m];
		visited = new boolean[n];
		recursive(0, 0);
		
		for(String x : set) sb.append(x);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
