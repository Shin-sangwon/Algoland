import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    //상 하 좌 우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int n, m, k, answer;
    static ArrayList<Node>[][] graph;
    static Queue<Node> queue;

    static class Node{
        int x;
        int y;
        int count;
        int direction;
        public Node(int x, int y, int count, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.count = count;
        }
    }

    private static boolean isOnBoundary(int x, int y) {
        return x == 0 || y == 0 || x == n-1 || y == n-1;
    }

    private static void spread() {
        int time = 0;

        while(!queue.isEmpty()) {

            if(time == m) break;
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++) {

                Node node = queue.poll();

                int nx = node.x + dx[node.direction];
                int ny = node.y + dy[node.direction];

                if(isOnBoundary(nx, ny)) {
                    int newCount = node.count /= 2;
                    if(newCount == 0) continue;

                    int newDirection = node.direction % 2 == 0? node.direction + 1 : node.direction - 1;

                    Node newNode = new Node(nx, ny, newCount, newDirection);
                    //queue.add(newNode);
                    graph[node.x][node.y].remove(node);
                    graph[nx][ny].add(newNode);

                    continue;
                }

                Node newNode = new Node(nx, ny, node.count, node.direction);
                graph[node.x][node.y].remove(node);
                graph[nx][ny].add(newNode);

            }

            //중복검사하기

            for(ArrayList<Node>[] x : graph) {
                for(ArrayList<Node> y : x) {
                    if(y.size() == 0) continue;

                    if(y.size() == 1) {
                        queue.add(y.get(0));
                        continue;
                    }

                    y.sort((o1, o2) -> o2.count - o1.count);

                    int nx = y.get(0).x;
                    int ny = y.get(0).y;
                    int direction = y.get(0).direction;
                    int count = y.stream().mapToInt(node -> node.count).sum();

                    graph[nx][ny] = new ArrayList<>();
                    Node newNode = new Node(nx, ny, count, direction);
                    graph[nx][ny].add(newNode);
                    queue.add(newNode);

                }
            }

            time++;

        }

        getAnswer();

    }

    private static void getAnswer() {
        answer = 0;

        while(!queue.isEmpty()) {
            answer += queue.poll().count;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int printIndex = 1;

        while(tc-->0) {

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new ArrayList[n][n];
            queue = new LinkedList<>();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    graph[i][j] = new ArrayList<>();
                }
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken()) - 1;

                Node node = new Node(x, y, count, direction);
                graph[x][y].add(node);
                queue.add(node);
            }

            spread();
            sb.append(String.format("#%d %d\n", printIndex++, answer));
        }

        System.out.println(sb);

    }

}
