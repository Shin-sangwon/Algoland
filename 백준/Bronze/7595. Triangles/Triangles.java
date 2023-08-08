import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			for(int i = 0; i < n; i++) {
				
				for(int j = 0; j < i+1; j++) {
					
					sb.append("*");
				}
				
				sb.append("\n");
			}
		}

		System.out.println(sb);
		
	}

}