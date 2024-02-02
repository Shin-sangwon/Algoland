import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Node>> graph;
    static final int MAX = (int) 1e9;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost < o.cost ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dist = new int[n+1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));

        }

        Arrays.fill(dist, MAX);
        dijkstra(1);

        System.out.println(dist[n]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int cost = node.cost;
            int index = node.index;

            for(Node n : graph.get(index)) {
                int nextCost = n.cost;
                int nextIndex = n.index;

                if(dist[nextIndex] > dist[node.index] + nextCost) {
                    dist[nextIndex] = dist[node.index] + nextCost;
                    pq.add(new Node(nextIndex, nextCost));
                }
            }
        }
    }
}
