import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int size, n;
	static char arr[], password[];
	static boolean visited[];
	static StringBuilder sb;
	
	private static boolean isVowel(char tmp) {
		
		if(tmp == 'a') return true;
		if(tmp == 'e') return true;
		if(tmp == 'i') return true;
		if(tmp == 'o') return true;
		if(tmp == 'u') return true;
		
		return false;
	}
	
	private static void recursive(int cnt, int start,int a, int b) {
		
		if(cnt == size) {
			
			if(a >= 1 && b >= 2) {
				
				for(char x : password) sb.append(x);
				sb.append("\n");
			}
			
			return;
		}
		
		for(int i = start; i < n; i++) {
			
			password[cnt] = arr[i];
			if(isVowel(password[cnt])) {
				recursive(cnt + 1, i + 1, a + 1 , b);
			}else {
				recursive(cnt + 1, i + 1,a , b + 1);
			}
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		size = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new char[n];
		visited = new boolean[n];
		password = new char[size];
		for(int i = 0; i < n; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		sb = new StringBuilder();
		
		recursive(0, 0, 0, 0);
		
		System.out.println(sb);

	}

}
