import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static final int MAX_VALUE = (int) 1e9;

    static boolean visited[];
    static int dist[], path[] ,n, m;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{

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
                    path[next.index] = now;
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        path = new int[n+1];
        Arrays.fill(dist, MAX_VALUE);
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

        st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        Stack<Integer> stack = new Stack<>();

        int cur = to;

        while(cur != 0) {
            stack.push(cur);
            cur = path[cur];
        }

        sb.append(dist[to]+"\n").append(stack.size()+"\n");

        while(!stack.isEmpty()) sb.append(stack.pop() + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }

}