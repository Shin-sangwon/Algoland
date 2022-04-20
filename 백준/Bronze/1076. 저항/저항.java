import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
			
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input[] = new String[2];
		String value[] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		Long arr[] = {1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L};
				
		String add = "";		
		Long target = 0L;
		
		for(int i = 0; i < 2; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < 10; j++) {
				if(tmp.equals(value[j])) {
					add += j;
				}
			}
		}
		String multifly = br.readLine();
		for(int i = 0; i < 10; i++) {
			if(multifly.equals(value[i])) target = arr[i];
		}
		
		
		System.out.println(Long.parseLong(add) * target);
		
	}
			
}