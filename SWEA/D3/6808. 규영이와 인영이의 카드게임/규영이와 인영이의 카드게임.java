import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] numbers, young, kyu;
	static boolean[] isSelected;
	static int scoreA, scoreB;
	
	private static void permutation(int cnt) {
		
		if(cnt == 9) {
			
			calc();
		}
		
		
		for(int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = young[i];
			isSelected[i] = true;
			permutation(cnt + 1);
			isSelected[i] = false;
		}
		
	}
	
	private static void calc() {
		
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < 9; i++) {
			if(kyu[i] > numbers[i]) {
				a += kyu[i] + numbers[i];
				continue;
			}
			
			if(numbers[i] > kyu[i]) {
				b += kyu[i] + numbers[i];
				
			}
		}
		
		if(a > b) {
			scoreA++;
			return;
		}
		
		scoreB++;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int printIndex = 1;
		
		while(tc--> 0) {
			
			boolean[] inputs = new boolean[19];
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				int now = Integer.parseInt(st.nextToken());
				inputs[now] = true;
			}
			
			
			kyu = new int[9];
			young = new int[9];
			int kyuIndex = 0;
			int youngIndex = 0;
			for(int i = 1; i <= 18; i++) {
				
				if(inputs[i]) {
					kyu[kyuIndex++] = i;
					continue;
				}
				
				young[youngIndex++] = i;
				
			}
			
			
			numbers = new int[9];
			isSelected = new boolean[9];
			
			scoreA = 0;
			scoreB = 0;
			
			permutation(0);
			
			sb.append(String.format("#%d %d %d\n", printIndex++, scoreA, scoreB));
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	

}
