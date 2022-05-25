import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int first = 1;
		
		
		while(n != first-1) {
		System.out.printf("Hello World, Judge %d!" + '\n', first++);
		}
		
		
	}
}