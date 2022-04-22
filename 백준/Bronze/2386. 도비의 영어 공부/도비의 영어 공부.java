import java.util.*;
import java.io.*;

public class Main {
	
		
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String target = st.nextToken();
			if(target.equals("#")) break;
			int tmp = 0;
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				for(int i = 0; i < str.length(); i++) {
					if(target.equals(str.substring(i, i+1).toLowerCase())) tmp++;
				}
			}
			
			System.out.println(target + " " + tmp);
		}
	}
}