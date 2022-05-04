import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	
	static int arr[][];
	static char tmp1[];
	static char tmp2[];
	
	static void init(int arr[][]) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i == 0) arr[i][j] = 0;
				if(j == 0) arr[i][j] = 0;
			}
		}
		
	}
	
	static void LCS(int arr[][], char tmp1[], char tmp2[]) {
		for(int i = 1; i < tmp1.length; i++) {
			for(int j = 1; j < tmp2.length; j++) {
				if(tmp1[i] == tmp2[j]) {
					arr[i][j] = arr[i-1][j-1] + 1;
				}else {
					arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		tmp1 = new char[str1.length()+1];
		tmp2 = new char[str2.length()+1];
		
		for(int i = 1; i < tmp1.length; i++) {
			tmp1[i] = str1.charAt(i-1);
		}
		
		for(int i = 1; i < tmp2.length; i++) {
			tmp2[i] = str2.charAt(i-1);
		}
		
		arr = new int[tmp1.length][tmp2.length];
			
		init(arr);
		LCS(arr, tmp1, tmp2);
		
		bw.write(arr[tmp1.length-1][tmp2.length-1]+"");
		bw.flush();
		bw.close();
		
	}

}