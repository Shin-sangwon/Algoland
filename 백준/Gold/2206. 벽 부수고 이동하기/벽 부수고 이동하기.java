import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int n,m;

    static class Node{
        int x;
        int y;
        int time;
        boolean broken;
        public Node(int x, int y, int time, boolean broken) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.broken = broken;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(tmp[j]);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];

        queue.add(new Node(0, 0, 0, false));
        //0 -> 부수지 않고, 1 -> 부수고
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        int answer = -1;
        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.x == n-1 && node.y == m-1) {
                answer = node.time + 1;
                break;
            }
            for(int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(map[nx][ny] == 1 && !node.broken && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.add(new Node(nx, ny, node.time + 1, true));
                    continue;
                }

                if(map[nx][ny] == 0) {
                    if(!node.broken && !visited[nx][ny][0]) {
                        queue.add(new Node(nx, ny, node.time + 1, false));
                        visited[nx][ny][0] = true;
                    }

                    if(node.broken && !visited[nx][ny][1]) {
                        queue.add(new Node(nx, ny, node.time + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(answer);

    }
}