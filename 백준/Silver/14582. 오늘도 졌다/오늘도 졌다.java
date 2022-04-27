import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean checker = false;
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int homeTeam = 0;
		int awayTeam = 0;
		
		for(int i = 0; i < 9; i++) {
			homeTeam += Integer.parseInt(st1.nextToken());
			if(homeTeam > awayTeam) checker = true;
			awayTeam += Integer.parseInt(st2.nextToken());
		}
		
		System.out.println(checker? "Yes" : "No");
	}

}