import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int arr[], n, m, start;

        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = arr[0];
        m = arr[1];
        start = arr[2];

        for(int i = 0; i < n+1; i++) graph.add(new ArrayList<Integer>());
        int[] visited = new int[n+1];
        while(m-->0) {
            st = new StringTokenizer(br.readLine());

            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            //무방향 간선이므로
            graph.get(tmp1).add(tmp2);
            graph.get(tmp2).add(tmp1);
        }
        //인접 정점은 오름차순으로 방문
        for(int i = 1; i < n+1; i++) Collections.sort(graph.get(i), Collections.reverseOrder());

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = idx++;

        while(!q.isEmpty()) {

            int tmp = q.poll();

            for(int x : graph.get(tmp)) {
                if(visited[x] == 0) {
                    q.add(x);
                    visited[x] = idx++;
                }
            }
        }

        for(int i = 1; i <= n; i++) sb.append(visited[i]+"\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}