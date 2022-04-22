import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	static int arr[];
	static boolean checker[];
	static int n;
	static int m;
	
	static void seq(int x) {
		if(x == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!checker[i]) {
				arr[x] = i;
				checker[i] = true;
				seq(x+1);
				checker[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());		
		arr = new int[10];
		checker = new boolean[10];
		seq(0);
		
	}
			
}