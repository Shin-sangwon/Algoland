import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int[] arr;
	static int[] target;
	
	static void reverse(int a, int b) {
		
		int cnt = b - a + 1;
		
		while(cnt-- != 0) {
			arr[a++] = target[b--];
		}
		
		target = arr.clone();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		arr = new int[21];
		target = new int[21];
		for(int i = 1; i < arr.length; i++) {
			arr[i] = i;
			target[i] = i;
		}
		
		int count = 10;
		
		while(count-- != 0) {
			st = new StringTokenizer(br.readLine(), " ");
			reverse(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}