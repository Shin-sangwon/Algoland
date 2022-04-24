import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[3];
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		bw.write(String.valueOf(arr[1]));
		bw.flush(); bw.close();
		
	}
			
}
