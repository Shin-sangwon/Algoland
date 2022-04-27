import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int scoreA = 0;
		int scoreB = 0;
		int arrA[] = new int[10];
		int arrB[] = new int[10];
		char score[] = new char[10];
		char ans = 'D';
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < arrA.length; i++) {
			arrA[i] = Integer.parseInt(st1.nextToken());
			arrB[i] = Integer.parseInt(st2.nextToken());
			if(arrA[i] > arrB[i]) {
				scoreA += 3;
				score[i] = 'A';
			}else if(arrA[i] < arrB[i]) {
				scoreB += 3;
				score[i] = 'B';
			}else {
				scoreA += 1;
				scoreB += 1;
				score[i] = 'D';
			}
		}
		
		bw.write(scoreA + " " + scoreB + '\n');
		if(scoreA > scoreB) {
			bw.write("A");
		}else if(scoreA < scoreB) {
			bw.write("B");
		}else {
			for(int i = 9; i >= 0; i--) {
				if(score[i] != 'D') {
					ans = score[i];
					break;
				}
			}
			bw.write(ans);
		}
		
		bw.flush();
		bw.close();	
	}
}