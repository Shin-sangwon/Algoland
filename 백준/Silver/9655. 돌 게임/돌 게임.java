import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int total = Integer.parseInt(br.readLine());

		ArrayList<Integer> al = new ArrayList<>();
		
		while(total != 0) {
			if(total >= 3) {
				total -= 3;
				al.add(3);
			}else {
				total -= 1;
				al.add(1);
			}
		}
		
		bw.write(al.size() % 2 == 1? "SK" : "CY");
		bw.flush();
		bw.close();
		
		
	}

}