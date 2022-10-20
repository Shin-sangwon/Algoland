import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static final int MAX_VALUE = (int) 1e9;
    static int answer = Integer.MIN_VALUE;
    static int dist[], n ,m, x;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }


        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }

    static void dijkstra(int from) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(from, 0));
        dist[from] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int distance = node.distance;
            int now = node.index;

            if(dist[now] < distance) continue;

            for(Node next : graph[now]) {
                if(dist[next.index] > distance + next.distance) {
                    dist[next.index] = distance + next.distance;
                    pq.add(new Node(next.index, distance + next.distance));
                }
            }

        }
    }

    static void init() {
        dist = new int[n+1];
        Arrays.fill(dist, MAX_VALUE);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        for(int i = 1; i <= n; i++) {

            if(i == x) continue;

            int tmp = 0;

            init();
            dijkstra(i);
            tmp += dist[x];
            init();
            dijkstra(x);
            tmp += dist[i];

            if(tmp > answer) answer = tmp;

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();





    }

}