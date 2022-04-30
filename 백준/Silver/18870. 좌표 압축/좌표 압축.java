import java.util.*;
import java.io.*;

public class Main {
	
	
	static int binarySearch(ArrayList<Integer> arr, int target, int start, int end) {
		if(start > end) return 0;
		int mid = (start + end) / 2;
		
		if(arr.get(mid) == target) {
			return mid;
		}else if(arr.get(mid) > target){
			return binarySearch(arr, target, start, mid-1);
		}else {
			return binarySearch(arr, target, mid+1, end);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		int arr[] = new int[cnt];
		int tmp[] = new int[cnt];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i] = temp;
			tmp[i] = temp;
			
		}
		Arrays.sort(tmp);
		ArrayList<Integer> al = new ArrayList<>();
		al.add(tmp[0]);
		for(int i = 1; i < arr.length; i++) {
			if(tmp[i-1] != tmp[i]) {
				al.add(tmp[i]);
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			bw.write(binarySearch(al, arr[i], 0, al.size()-1)+" ");
		}
		
		bw.flush();
		bw.close();
	} 
}