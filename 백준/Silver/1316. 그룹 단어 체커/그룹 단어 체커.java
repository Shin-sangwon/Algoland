import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cnt = br.readLine();
		int ans = 0;
		for(int i = 0; i < Integer.parseInt(cnt); i++) {
			String str = br.readLine();
			boolean check = true;
			int arr[] = new int[26];
			arr[(str.charAt(0)-97)]++;
			for(int j = 1; j < str.length(); j++) {
				if(str.charAt(j) != str.charAt(j-1) && arr[str.charAt(j)-97] != 0) {
					check = false;
				}else {
					arr[str.charAt(j)-97]++;
				}
			}
			if(check) ans++;
		}
		System.out.println(ans);
		
	}
}