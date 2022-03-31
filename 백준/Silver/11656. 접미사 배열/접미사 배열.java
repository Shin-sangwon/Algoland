import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String str = br.readLine();
		ArrayList<String> al = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			al.add(str.substring(i, str.length()));
		}
		Collections.sort(al);
		for(String x : al) System.out.println(x);
	}
}