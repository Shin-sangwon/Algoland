import java.util.*;
import java.io.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		boolean flag = false;
		
		if(br.readLine().toLowerCase().equals("n")) flag = true;
		
		bw.write(flag == true? "Naver D2" : "Naver Whale");
		bw.flush();
		bw.close();
		
	}
}