import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<ArrayList<Integer>> graph;

    static class Node{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 10;
        int printIndex = 1;

        while(tc-->0) {

            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for(int i = 0; i <= 100; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < length/2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(start, 0));
            boolean[] visited = new boolean[101];
            visited[start] = true;
            int answer = start;
            int target = 0;

            while(!queue.isEmpty()) {

                Node node = queue.poll();

                if(node.dist == target) {
                    answer = Math.max(answer, node.num);
                }else if(node.dist > target) {
                    answer = node.num;
                    target++;
                }

                for(int x : graph.get(node.num)) {
                    if(visited[x]) continue;

                    queue.add(new Node(x, node.dist + 1));
                    visited[x] = true;
                }
            }

            sb.append(String.format("#%d %d\n", printIndex++, answer));
        }

        System.out.println(sb);

    }

}

