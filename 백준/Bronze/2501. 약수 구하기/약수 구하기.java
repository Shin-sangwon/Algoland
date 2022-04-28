import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> al = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) al.add(i);
		}
		
		if(al.size() < k) {
			bw.write(0+"");
		}else {
			bw.write(al.get(k-1)+"");
		}
		
		bw.flush();
		bw.close();
		
		
	}
}