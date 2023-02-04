import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점, 간선
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
           map.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {

           st = new StringTokenizer(br.readLine());

           int start = Integer.parseInt(st.nextToken());
           int target = Integer.parseInt(st.nextToken());

           map.get(start).add(target);
           map.get(target).add(start);
        }

        Queue<Integer> queue;
        int answer = 0;

        for(int i = 1; i <= n; i++) {

           if(visited[i]) continue;
           queue = new LinkedList<>();
           queue.add(i);
           answer++;

           while(!queue.isEmpty()) {
              int now = queue.poll();
              ArrayList<Integer> al = map.get(now);

              for(int x : al) {
                 if(visited[x]) continue;
                 queue.add(x);
                 visited[x] = true;
              }
           }

           }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}