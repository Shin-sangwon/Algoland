import java.io.*;
import java.util.*;

public class Main {
	
	
	static boolean checker(String str1, String str2) {
		int arr1[] = new int[26];
		int arr2[] = new int[26];
		for(int i = 0; i < str1.length(); i++) {
			arr1[str1.charAt(i) - 97]++;
		}
		for(int i = 0; i < str2.length(); i++) {
			arr2[str2.charAt(i) - 97]++;
		}
		
		if(Arrays.equals(arr1, arr2)) {
			return true;
		}else {
			return false;
		}
		
	}
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//97
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt != 0) {
			cnt--;
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String tmp1 = st.nextToken(); String tmp2 = st.nextToken();
			if(checker(tmp1, tmp2)) {
				System.out.println("Possible");
			}else {
				System.out.println("Impossible");
			}
			
		}
		
	}

}