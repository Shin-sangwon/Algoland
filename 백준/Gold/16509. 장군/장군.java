import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static Node target;
    static final int n = 10, m = 9;

    static final int[] dx = {-3, -3, -2, -2, 2, 2, 3, 3};
    static final int[] dy = {-2, 2, -3, 3, -3, 3, -2, 2};
    static final Node[][] move = {
        {new Node(-1, 0), new Node(-1, -1), new Node(-1, 0)},
        {new Node(-1, 0), new Node(-1, 1), new Node(-1, 1)},
        {new Node(0, -1), new Node(-1, -1), new Node(-1, -1)},
        {new Node(0, 1), new Node(-1, 1), new Node(-1, 1)},
        {new Node(0, -1), new Node(1, -1), new Node(1, -1)},
        {new Node(0, 1), new Node(1, 1), new Node(1, 1)},
        {new Node(1, 0), new Node(1, -1), new Node(1, -1)},
        {new Node(1, 0), new Node(1, 1), new Node(1, 1)}
    };


static class Node {

    int x;
    int y;
    int length;

    Node(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

    private static int bfs(int startX, int startY) {
        Node start = new Node(startX, startY, 0);
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        visited[startX][startY] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            Loop1:
            for(int k = 0; k < 8; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= 10 || ny >= 9) continue;

                if(visited[nx][ny]) continue;

                int moveX = node.x;
                int moveY = node.y;
                for(int i = 0; i < 2; i++) {
                    moveX += move[k][i].x;
                    moveY += move[k][i].y;

                    if(moveX == target.x && moveY == target.y) continue Loop1;
                }

                if(nx == target.x && ny == target.y) {
                    return node.length + 1;
                }

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, node.length + 1));
            }
        }


        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int targetX = Integer.parseInt(st.nextToken());
        int targetY = Integer.parseInt(st.nextToken());

        target = new Node(targetX, targetY);

        int answer = bfs(startX, startY);

        System.out.println(answer);
    }
}