import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int textLength = text.length;
		int patternLength = pattern.length;
		
		int[] table = new int[patternLength];
		
		for(int i = 1, j = 0; i < patternLength; i++) {
			//i -> 접미사 포인터, j -> 접두사 포인터
			while(j > 0 && pattern[i] != pattern[j]) {
				j = table[j-1];
			}
			
			if(pattern[i] == pattern[j]) {
				table[i] = ++j;
			}else {
				table[i] = 0;
			}
		}
		
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		
		// i : 텍스트 포인터 j : 패턴 포인터
		
		for(int i = 0, j = 0; i < textLength; ++i) {
			
			while(j > 0 && text[i] != pattern[j]) j = table[j-1];
			
			if(text[i] == pattern[j]) {
				if(j == patternLength - 1) {
					cnt++;
					sb.append(i - j + 1).append("\n");
					list.add(i - j);
					j = table[j];
				}else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		

	}

}
