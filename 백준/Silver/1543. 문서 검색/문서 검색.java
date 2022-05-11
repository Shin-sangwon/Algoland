import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		String target = br.readLine();	
		String regex = br.readLine();
		int ans = 0;
		
		target = target.replace(regex, "/");
		
		for(int i = 0; i < target.length(); i++) {
			if(target.substring(i, i+1).equals("/")) ans++;
		}
		
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}

}