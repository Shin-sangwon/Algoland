import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	
	
	static int count(String a, String b) {
		
		int L = 0;
		int O = 0;
		int V = 0;
		int E = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == 'L') L++;
			if(a.charAt(i) == 'O') O++;
			if(a.charAt(i) == 'V') V++;
			if(a.charAt(i) == 'E') E++;
		}
		
		for(int i = 0; i < b.length(); i++) {
			if(b.charAt(i) == 'L') L++;
			if(b.charAt(i) == 'O') O++;
			if(b.charAt(i) == 'V') V++;
			if(b.charAt(i) == 'E') E++;
		}
		
		
		return ((L+O) * (L+V) * (L+E) * (O+V) * (O+E) * (V+E)) % 100;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
		String name = br.readLine();
		
		int cnt = Integer.parseInt(br.readLine());
		
		String arr[] = new String[cnt];
		int score[] = new int[cnt];
		
		for(int i = 0; i < cnt; i++) {
			arr[i] = br.readLine();
			score[i] = count(name, arr[i]);
		}
		
		int max = Integer.MIN_VALUE;
		int maxcount = 0;
		ArrayList<String> checker = new ArrayList<>();
		
		for(int i = 0; i < score.length; i++) {
			if(score[i] > max) max = score[i];
		}
		
		for(int i = 0; i < score.length; i++) {
			if(score[i] == max) maxcount++;
		}
		
		if(maxcount == 1) {
			for(int i = 0; i < arr.length; i++) {
				if(score[i] == max) System.out.println(arr[i]);
			}
		}else {
			for(int i = 0; i < arr.length; i++) {
				if(score[i] == max) checker.add(arr[i]);
			}
			Collections.sort(checker);
			System.out.println(checker.get(0));
		}
				
	}
			
}