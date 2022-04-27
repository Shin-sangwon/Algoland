import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		
		int arr[] = new int[cnt];
		
		for(int i = 0; i < cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int x : arr) bw.write(x + "" + '\n');
		
		bw.flush();
		bw.close();
	}
}