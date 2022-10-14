import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final int MAX_VALUE = (int) 1e9;

    static long dist[];
    static int n,m;

    static StringBuilder sb;

    static Node[] graph;

    static class Node {
        int start;
        int end;
        int cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

    }

    static boolean bellmanFord() {

        dist[1] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                Node node = graph[j];
                int start = node.start;
                int end = node.end;
                int cost = node.cost;

                if(dist[start] != MAX_VALUE && dist[end] > dist[start] + cost) {

                    if(i == n) {
                        return true;
                    }

                    dist[end] = dist[start] + cost;
                }
            }
        }

/*        for(int i = 0; i < m; i++) {
            Node node = graph[i];
            int start = node.start;
            int end = node.end;
            int cost = node.cost;

            if(dist[start] != MAX_VALUE && dist[end] > dist[start] + cost) {
                return true;
            }
        }*/


        return false;
    }

    static void print(boolean checker) {

        if(checker) {
            sb.append(-1);
            return;
        }

        for(int i = 2; i <= n; i++) {
            sb.append(dist[i] == MAX_VALUE? -1 : dist[i]).append("\n");
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n+1];
        graph = new Node[m];
        Arrays.fill(dist, MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[i] = new Node(start, end, cost);
        }

        boolean checker = bellmanFord();
        print(checker);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}