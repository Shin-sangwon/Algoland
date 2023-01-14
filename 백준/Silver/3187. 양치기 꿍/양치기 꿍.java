import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean[][] visited;

    static class Node{
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];
        int sheep = 0;
        int wolves = 0;

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        Queue<Node> queue = new LinkedList<>();
        //빈공간 . , 울타리 #, 늑대 v, 양 k
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < m; j++) {

                if(visited[i][j] || arr[i][j] == '#') continue;

                queue.add(new Node(i, j));
                visited[i][j] = true;
                int tmpWolves = 0;
                int tmpSheep = 0;
                if(arr[i][j] == 'k') tmpSheep++;
                else if(arr[i][j] == 'v') tmpWolves++;

                while(!queue.isEmpty()) {
                    Node node = queue.poll();
                    for(int k = 0; k < 4; k++) {
                        int nx = node.x + dx[k];
                        int ny = node.y + dy[k];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        if(!visited[nx][ny] && arr[nx][ny] != '#') {
                            queue.add(new Node(nx, ny));
                            visited[nx][ny] = true;
                            if(arr[nx][ny] == 'k') tmpSheep++;
                            else if(arr[nx][ny] == 'v') tmpWolves++;
                        }
                    }
                }

                if(tmpSheep <= tmpWolves) {
                    wolves += tmpWolves;
                    continue;
                }

                sheep += tmpSheep;

            }
        }

        bw.write(sheep + " " + wolves);
        bw.flush();
        bw.close();
        br.close();

    }
}