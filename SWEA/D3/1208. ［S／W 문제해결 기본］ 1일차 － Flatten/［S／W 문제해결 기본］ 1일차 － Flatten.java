import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

class Solution{
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int testCase = 10;
		int idx = 1;
		while(testCase-- > 0) {
			int dump = Integer.parseInt(br.readLine());
			int arr[] = Stream.of(br.readLine().split(" "))
					.mapToInt(Integer::parseInt)
					.sorted()
					.toArray();
			
			while(dump-- > 0) {
				arr[0]++;
				arr[arr.length-1]--;
				Arrays.sort(arr);
			}
			
			sb.append(String.format("#%d %d\n",idx++, arr[arr.length-1] - arr[0]));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
