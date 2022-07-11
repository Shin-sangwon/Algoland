import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		
		while(n != 0) {
			if(n >= 3) {
				n -= 3;
				al.add(3);
				
			}else {
				n -= 1;
				al.add(1);
			}
			
			
		}
		
		bw.write(al.size() % 2 == 0? "SK" : "CY");
		bw.flush();
		bw.close();
		
	}
}