import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.sorted()
				.toArray();
		
		int answer = 0;
		
		for(int i = 0; i < n-1; i++) {
			answer += arr[i];
		}
		
		
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();

	}

}