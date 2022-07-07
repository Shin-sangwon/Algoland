import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> al = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			//이미 포함되어 있으면 입력 받지 않음
			if(al.contains(tmp)) continue;
			al.add(tmp);
		}
		br.close();
		// 글자수가 같다면 단어순으로 출력해야 하므로 일단 오름차순 정렬
		Collections.sort(al);
		// 단어길이 순으로 정렬
		al.sort((o1, o2) -> o1.length()-o2.length());
		
		//출력
		for(String x : al) bw.write(x+"\n");
		bw.flush();
		bw.close();
		
	}
}