import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.*;


public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> al = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}
		
		int mvalue = Integer.MIN_VALUE;
		for(int key : map.keySet()) {
			if(map.get(key) > mvalue) {
				mvalue = map.get(key);
			}
		}
		
		for(int key : map.keySet()) {
			if(map.get(key) == mvalue) {
				al.add(key);
			}
		}
		
		
		double average = Arrays
				.stream(arr)
				.average()
				.orElse(0);
		int max = Arrays
				.stream(arr)
				.max()
				.orElse(0);
		int min = Arrays
				.stream(arr)
				.min()
				.orElse(0);
		
		Arrays.sort(arr);
		Collections.sort(al);
		int mode = al.size() == 1? al.get(0) : al.get(1);
		
		bw.write(Math.round(average)+"\n");
		bw.write(arr[n/2]+"\n");
		bw.write(mode+"\n");
		bw.write(max-min+"");
		bw.flush();
		bw.close();
		br.close();
				
		
	}
}