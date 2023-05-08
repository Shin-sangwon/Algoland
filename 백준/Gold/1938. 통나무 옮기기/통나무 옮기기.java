

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static final int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
    static final int[] dy = {0, 1, 0, -1, 1, -1 ,1 ,-1};

    static int n;
    static char[][] map;
    static boolean[][][] visited;
    static Node start, target;
    static ArrayList<Node> startArea, targetArea;

    static class Node{
        int x;
        int y;
        int time;
        int status; // 0 -> 가로, 1 -> 세로

        // bfs용 생성자
        public Node(int x, int y, int time, int status) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.status = status;
        }

        // 단순 좌표용 생성자
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 초기 기둥 상태를 위한 생성자
        public Node(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", time=" + time + ", status=" + status + "]";
        }


    }

    /*
     * 초기 노드 상태 정해주기
     *
     * 기둥은 총 3칸이지만, 가운데의 1칸만을 가지고 탐색할거임. 따라서 이 기둥이 세로상태인지 가로상태인지를 판별하고 가운데 값을 좌표로 하는 start, target 만들기
     */
    private static void defineNode() {


        if((startArea.get(0).x == startArea.get(1).x) && (startArea.get(1).x) == startArea.get(2).x) {

            start = new Node(startArea.get(1).x , startArea.get(1).y, 0, 0);
        } else {

            start = new Node(startArea.get(1).x , startArea.get(1).y, 0, 1);
        }

        if((targetArea.get(0).x == targetArea.get(1).x) && (targetArea.get(1).x) == targetArea.get(2).x) {

            target = new Node(targetArea.get(1).x , targetArea.get(1).y, 0, 0);
        } else {

            target = new Node(targetArea.get(1).x , targetArea.get(1).y, 0, 1);
        }
    }

    // 회전 가능한지 여부
    private static boolean canRotate(int x, int y) {
        // 회전이 가능하려면, 가로 기둥이건 세로 기둥이건 중심이 테두리에 있으면 안됨
        if(!(x >= 1 && y >= 1 && x <= n-1 && y <= n-1)) return false;

        // 8방향을 다 보면서, 1이 있으면 회전이 불가능함
        for(int k = 0; k < 8; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) return false;

            if(map[nx][ny] =='1') return false;
        }

        return true;
    }

    // 움직일 수 있는지 여부
    private static boolean canMove(int x, int y, int status) {

        // 0 -> 가로, 1 -> 세로

        if(status == 0) {

            // 가로로 놓여진 기둥의 중심은 가로축 테두리 전까지만 움직일 수 있음
            if(x < 0 || x >= n || y < 1 || y >= n - 1) return false;

            // x값 같고 y값만 다를거임

            if(map[x][y-1] == '1' || map[x][y] == '1' || map[x][y+1] == '1') return false;

        } else {

            // 세로로 놓여진 기둥의 중심은 세로축 테두리 전까지만 움직일 수 있음
            if(x < 1 || x >= n - 1 || y < 0 || y >= n) return false;

            //x값 다르고 y값만 같을거임

            if(map[x-1][y] == '1' || map[x][y] == '1' || map[x+1][y] == '1') return false;
        }

        return true;

    }

    private static int move() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        // 회전 상태에 따라 방문처리를 다르게 하기 위해 3차원배열로 선언
        visited = new boolean[n][n][2];

        visited[start.x][start.y][start.status] = true;


        while(!queue.isEmpty()) {

            Node node = queue.poll();
            int newStatus = (node.status == 1? 0 : 1);
            // 회전 가능한 기둥이라면, 시간 1초 더해서 회전시키기
            if(canRotate(node.x, node.y) && !visited[node.x][node.y][newStatus]) {
                queue.add(new Node(node.x, node.y, node.time + 1 ,newStatus));
                visited[node.x][node.y][newStatus] = true;
            }

            for(int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                // 도착지의 중심과 일치하면서, 방향이 같다면 정답 리턴하기
                if(target.x == nx && target.y == ny && node.status == target.status) {
                    return node.time + 1;
                }

                if(!canMove(nx, ny, node.status)) continue;

                if(visited[nx][ny][node.status]) continue;

                visited[nx][ny][node.status] = true;

                queue.add(new Node(nx, ny, node.time + 1,node.status));


            }
        }

        // 정답이 없으므로 0을 리턴하기
        return 0;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        // 중심 좌표와 기둥의 상태를 정하기 위한 리스트 선언
        startArea = new ArrayList<>();
        targetArea = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'B') startArea.add(new Node(i, j));

                if(map[i][j] == 'E') targetArea.add(new Node(i, j));
            }
        }

        // 초기기둥과 타겟 기둥 정의하기
        defineNode();

        int answer = move();

        System.out.println(answer);
    }
}
