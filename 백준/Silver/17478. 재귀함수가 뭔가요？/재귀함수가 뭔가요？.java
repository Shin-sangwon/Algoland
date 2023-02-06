import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int n;
	static final String FIRST = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static final String SECOND = "\"재귀함수가 뭔가요?\"\n";
	static final String THIRD =  "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static final String FORTH = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static final String FIFTH = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static final String ANSWER = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static final String END = "라고 답변하였지.\n";
	static final String[] ARR = {SECOND, THIRD, FORTH, FIFTH};
	static final String INDEX = "____";
	
	private static void recursive(int x) {
		//탈출 조건
		if(x == n) {	
			addIndex(x); sb.append(ARR[0]);
			addIndex(x); sb.append(ANSWER);
			addIndex(x); sb.append(END);
			return;		
		}
		
		for(int i = 0; i < 4; i++) {
			addIndex(x);
			sb.append(ARR[i]);
		}
		
		recursive(x+1);
		
		addIndex(x); sb.append(END);
		
		
		
	}
	
	private static void addIndex(int x) {
		
		for(int i = 0; i < x; i++) {
			sb.append(INDEX);
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		sb.append(FIRST);
		
		recursive(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
