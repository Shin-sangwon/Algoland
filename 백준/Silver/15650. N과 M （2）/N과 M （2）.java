import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	static int arr[];
	
	static int n, m;

	static void seq(int x, int y) {
		if(x == m) {
			for(int a : arr) System.out.print(a + " ");
			System.out.println();
		}else {	
			for(int i = y; i <= n; i++) {
				arr[x] = i;
				seq(x+1, i+1);
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
		arr = new int[m];		
		seq(0, 1);
		
	}
			
}