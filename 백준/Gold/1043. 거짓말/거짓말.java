import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	
	static int n,m, arr[];
	static ArrayList<int[]> al;
	
	private static int find(int x) {
		
		if(arr[x] == x) return x;
		
		return arr[x] = find(arr[x]);
	}
	
	private static void union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return;
		
		arr[yRoot] = xRoot;
		
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		// 파티에 참가한 사람들의 수 + 1 (index => 1부터 시작하기 위해 n+1)
		arr = new int[n+1];
		//파티에 참가한 사람들 기록할 배열
		al = new ArrayList<>();
		
		//루트 자기 자신으로 지정하기
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		
		st = new StringTokenizer(br.readLine());
		//진실을 알고 있는 사람 수
		int truth = Integer.parseInt(st.nextToken());
		//진실을 알고 있는 사람이 없다면, 모든 파티에서 거짓말 가능
		if(truth == 0) {
			System.out.print(m);
			return;
		}
		
		//사람이 있다면, 진실을 알고 있는 사람 리스트 만들기
		int[] truthList = new int[truth];
		//
		for(int i = 0; i < truth; i++) {
			truthList[i] = Integer.parseInt(st.nextToken());
		}
		//파티별로 인원들의 관계 union 해주기위해서 반복문 돌기
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			//파티에 오는 사람의 수
			int num = Integer.parseInt(st.nextToken());
			//사람이 한명이라면, 관계를 맺을 필요 없이 바로 al에 추가하기
			if(num == 1) {
				al.add(new int[] {Integer.parseInt(st.nextToken())});
				continue;
			}
			//사람이 여러명이라면, 가장 번호가 낮은 사람을 기준으로 union하기
			int[] tmp = new int[num];
			//union target
			int target = -1;
			for(int j = 0; j < num; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
				//첫 번째 사람을 target으로 만들기
				if(j == 0) {
					target = tmp[j];
					continue;
				}
				//첫 번째 사람이 아니라면, 관계 맺어주기
				union(target, tmp[j]);
			}
			//파티에 온 사람들 al에 추가하기
			al.add(tmp);
		}
		//정답 변수 만들기
		int answer = 0;
		Loop1:
		//파티에 온 사람들을 기록한 리스트를 돌면서
		for(int[] array : al) {
			//한 파티에 온 사람들별로
			for(int x : array) {
				// 한 사람의 루트 뽑아내기
				int tmp = find(x);
				// 진실을 알고있는 사람의 배열을 돌면서, 같은 집합에 속해있따면 넘어가기
				for(int i = 0; i < truthList.length; i++) {
					if(find(truthList[i]) == tmp) continue Loop1; 
				}
			}
			//배열 전부 돌았는데도, 아니라면 정답 올려주기
			answer++;
		}
		
		System.out.println(answer);
		
	}

}
