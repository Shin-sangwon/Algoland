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
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static int short_d[];

    static class Node implements Comparable<Node> {

        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if(this.distance < other.distance) {
                return -1;
            }
            return 1;
        }

    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        short_d[start] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if(short_d[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = short_d[now] + graph.get(now).get(i).distance;

                if(cost < short_d[graph.get(now).get(i).index]) {
                    short_d[graph.get(now).get(i).index] = cost;
                    pq.add(new Node(graph.get(now).get(i).index, cost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        short_d = new int[n+1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        while(m-->0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


/*            try {
                if(graph.get(a).get(b).distance > c) {
                    graph.get(a).get(b).distance = c;
                }
            }catch (IndexOutOfBoundsException e) {
                graph.get(a).add(new Node(b,c));
            }*/

            graph.get(a).add(new Node(b,c));

        }

        Arrays.fill(short_d, MAX_VALUE);

        dijkstra(start);

        for(int i = 1; i <= n; i++) {
            if(short_d[i] == MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }

            sb.append(short_d[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }
}