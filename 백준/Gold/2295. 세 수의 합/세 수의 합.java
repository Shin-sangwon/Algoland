import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		int arr[] = new int[cnt];
		//초기입력
		for(int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int idx = 0;
		ArrayList<Integer> two = new ArrayList<>();
		//x + y + z = k , x + y + z중 두항을 합한 배열 생성
		//따라서 two[x] + z = k 가 되고, two[x] = k - z;
		//중복이 가능하므로 j 는 i부터
		for(int i = 0; i < cnt; i++) {
			for(int j = i; j < cnt; j++) {
				two.add(arr[i]+arr[j]);
			}
		}
		boolean flag = false;
		Collections.sort(two);
		for(int i = cnt-1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(Collections.binarySearch(two, arr[i]-arr[j]) >= 0) {
					System.out.println(arr[i]);					
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
	} 
}