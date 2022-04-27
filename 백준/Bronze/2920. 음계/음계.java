import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int asc[] = {1, 2, 3 ,4 ,5 ,6 ,7 ,8};
		int desc[] = {8, 7, 6, 5, 4, 3, 2, 1};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[8];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(Arrays.equals(asc, arr)) {
			bw.write("ascending");
		}else if(Arrays.equals(desc, arr)) {
			bw.write("descending");
		}else {
			bw.write("mixed");
		}
		
		bw.flush();
		bw.close();
					
	}
}