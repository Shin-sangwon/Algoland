import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Node>[][] map;
    static HashSet<Node> revisit;

    static class Node{
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        /*
       1. al에 좌표 입력받기
       2. dfs를 돌면서 queue로 불 켜주기
       3. 이동 가능한범위 움직이기
       4. 다시 방문할 수 있는 곳을 따로 저장하기 (메소드를 만들지 않으므로 visited를 재정의 하기가 힘듦)
         */
        revisit = new HashSet<>();
        arr = new int[n][n];
        visited = new boolean[n][n];
        map = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[x][y].add(new Node(a, b));
        }

        // 1,1 에서 출발 -> 나는 0, 0에서 출발
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        arr[0][0] = 1;
        int answer = 1;

        while(!queue.isEmpty()) {
            //노드 뽑아오기
            Node node = queue.poll();

            for(Node tmp : map[node.x][node.y]) {
                //불이 꺼져있다면
                if(arr[tmp.x][tmp.y] == 0) {
                    //불 켜주기
                    answer++;
                    //갈 수 있다고 표시
                    arr[tmp.x][tmp.y] = 1;
                    //System.out.printf("%d, %d에서 %d, %d의 스위치를 킴\n", node.x, node.y, tmp.x, tmp.y);
                    //불 킨곳이 revisit에 들어있다면 도달 할 수도 있으므로 다시 넣어주기
                    if(revisit.contains(tmp)) queue.add(tmp);

                }


            }

            for(int k = 0; k < 4; k++) {

                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                //좌표상 갈 수 없으면 넘기기
                if((nx < 0 || ny < 0 || nx >= n || ny >= n) || visited[nx][ny]) continue;

                //갈 수 있는 곳이지만, 불이 꺼져있다면
                if(arr[nx][ny] == 0) {
                    revisit.add(new Node(nx, ny));
                    continue;
                }

                //갈 수 있다면
                if(arr[nx][ny] == 1) {
                    queue.add(new Node(nx, ny));
                    //System.out.printf("%d, %d에서 %d, %d로 이동함\n", node.x, node.y, nx, ny);
                    visited[nx][ny] = true;
                }


            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}