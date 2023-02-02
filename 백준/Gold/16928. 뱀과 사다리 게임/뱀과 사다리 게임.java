import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Node{
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[101];
        int[] map = new int[101];

        for(int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            map[start] = target;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;
        int answer = 0;
        Loop1:
        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.x == 100) {
                answer = node.time;
                break;
            }

            for(int i = 1; i <= 6; i++) {

                int nx = node.x + i;

                if(nx > 100) continue;

                if(map[nx] != 0) {
                    queue.add(new Node(map[nx], node.time + 1));
                    visited[map[nx]] = true;
                    continue;
                }

                if(visited[nx]) continue;

                queue.add(new Node(nx, node.time + 1));
                visited[nx] = true;



            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}