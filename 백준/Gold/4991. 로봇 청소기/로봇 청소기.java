import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0 ,1, 0, -1};

    static class Node{
        int x;
        int y;
        int bit;
        int time;

        public Node(int x, int y, int bit, int time) {
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;



        while(true) {
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            char[][] map = new char[n][m];
            Queue<Node> queue = new LinkedList<>();
            int dirt = 0;
            char tmp = 'a';

            for(int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < m; j++) {
                    if(map[i][j] =='o') {
                        queue.add(new Node(i, j, 0, 0));
                    }

                    if(map[i][j] == '*') {
                        map[i][j] = tmp++;
                        dirt++;

                    }
                }
            }
            int answer = -1;
            boolean[][][] visited = new boolean[n][m][1 << dirt];
            Node start = queue.peek();
            visited[start.x][start.y][0] = true;
            while(!queue.isEmpty()) {

                Node node = queue.poll();
                if(node.bit == (1 << dirt) - 1) {
                    answer = node.time;
                    break;
                }

                for(int k = 0; k < 4; k++) {
                    int nx = dx[k] + node.x;
                    int ny = dy[k] + node.y;

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                    if(visited[nx][ny][node.bit]) continue;

                    if(map[nx][ny] == '*') continue;

                    if(map[nx][ny] == 'x') continue;
                    if((map[nx][ny] >= 'a' && map[nx][ny] <= 'j') && (node.bit | (1 << map[nx][ny] - 97)) == node.bit) continue;

                    if((map[nx][ny] >= 'a' && map[nx][ny] <= 'j')) {
                        int bit = node.bit | (1 << map[nx][ny] - 97);
                        queue.add(new Node(nx, ny, bit, node.time + 1));
                        visited[nx][ny][bit] = true;
                    }

                        queue.add(new Node(nx, ny, node.bit, node.time + 1));
                        visited[nx][ny][node.bit] = true;

                }
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);

    }
}
