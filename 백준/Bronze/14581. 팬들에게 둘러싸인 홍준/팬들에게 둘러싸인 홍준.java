import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = ":fan:";
		String tmp = ":" + br.readLine() + ":";
		
		bw.write(str+str+str+'\n');
		bw.write(str+tmp+str+'\n');
		bw.write(str+str+str);
		bw.flush();
		bw.close();
		
	}
}