import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {

    static int idx = 1;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static void dfs(int start) {
        visited[start] = idx++;
        for(int i = 0; i < graph.get(start).size(); i++) {
            int x = graph.get(start).get(i);
            if(visited[x] == 0) dfs(x);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        graph = new ArrayList<>();
        int arr[], n, m, start;

        arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = arr[0];
        m = arr[1];
        start = arr[2];

        for(int i = 0; i < n+1; i++) graph.add(new ArrayList<Integer>());
        visited = new int[n+1];
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

        //방문 순서

        dfs(start);

        for(int i = 1; i <= n; i++) sb.append(visited[i]+"\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}