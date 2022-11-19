import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


class Solution{
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> al = new ArrayList<>();
		//setting
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				al.add(i * j);
			}
		}
		int testCase = Integer.parseInt(br.readLine());
		int idx = 1;
		
		while(testCase-- > 0) {
			
			boolean tmp = al.contains(Integer.parseInt(br.readLine()));
			sb.append(String.format("#%d %s\n", idx++, tmp?"Yes":"No"));
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
