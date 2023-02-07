import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[] num;
	static int n,m;
	
	private static void recursive(int depth, int start) {
		
		if(depth == m) {
			print();
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			num[depth] = arr[i];
			recursive(depth + 1, i);
		}
		
	}
	
	private static void print() {
		
		for(int i = 0; i < num.length; i++) {
			sb.append(num[i]).append(" ");
		}
		
		sb.append("\n");
		return;
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = Stream.of(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
						  .sorted()
						  .toArray();
		
		num = new int[m];
		recursive(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
