import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static String addCharacter(int n) {

        if(n == 0) return "D";
        if(n == 1) return "S";
        if(n == 2) return "L";
        return "R";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        //방문 처리
        StringBuilder[] arr;
        Queue<String> queue;
        boolean[] visited;

        while(n-->0) {
            //init settings
            st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String target = st.nextToken();
            visited = new boolean[10000];
            arr = new StringBuilder[10000];
            queue = new LinkedList<>();

            //inputs
            queue.add(start);
            visited[Integer.parseInt(start)] = true;
            //출발지점 string 생성
            arr[Integer.parseInt(start)] = new StringBuilder();

            while(!queue.isEmpty()) {
                //탈출조건
                if(visited[Integer.parseInt(target)]) break;
                //큐에서 뽑아오기
                String tmp = queue.poll();
                int tmpInt = Integer.parseInt(tmp);
                int[] dfs = {(2 * tmpInt) % 10000, tmpInt == 0? 9999 : tmpInt - 1, (tmpInt % 1000) * 10 + tmpInt / 1000, (tmpInt % 10) * 1000 + tmpInt / 10};

                for(int k = 0; k < 4; k++) {
                    //방문했을 시 넘어가기
                    if(visited[dfs[k] % 10000]) continue;
                    //할당
                    arr[dfs[k] % 10000] = new StringBuilder().append(arr[Integer.parseInt(tmp)]).append(addCharacter(k));
                    //방문 함
                    visited[dfs[k] % 10000] = true;
                    //큐에 넣어주기
                    queue.add(String.valueOf(dfs[k]));

                }

                //할당 해제하기
                arr[Integer.parseInt(tmp)] = null;

            }

            ans.append(arr[Integer.parseInt(target)].toString()).append("\n");

        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}