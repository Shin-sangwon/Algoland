import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    final static int[] dx = {1, 0, -1, 0};
    final static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[] numbers;
    static List<Node> princessList;
    static boolean[][] visited;
    static boolean[][] princess;
    static int answer;
    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Node of(int number) {
            return new Node(number / 5, number % 5);
        }
    }

    private static void mapping() {

        princess = new boolean[5][5];

        princessList
            .forEach(node -> princess[node.x][node.y] = true);

    }
    private static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[5][5];
        mapping();

        Node start = princessList.get(0);
        visited[start.x][start.y] = true;
        queue.add(start);

        int cnt = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                if(visited[nx][ny]) continue;

                if(!princess[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new Node(nx, ny));
                cnt++;
            }
        }

        return cnt == 7;

    }

    private static void combination(int cnt, int start) {

        if (cnt == 7) {

            princessList = Arrays.stream(numbers)
                                 .mapToObj(Node::of)
                                 .collect(Collectors.toList());

            int yCnt = (int) princessList.stream()
                                         .filter(node -> map[node.x][node.y] == 'Y')
                                         .count();

            if(yCnt >= 4) return;

            boolean isConnected = bfs();

            if(isConnected) answer++;

            return;
        }

        for (int i = start; i < 25; i++) {
            numbers[cnt] = i;
            combination(cnt + 1, i + 1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        numbers = new int[7];
        answer = 0;

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine()
                       .toCharArray();
        }

        combination(0, 0);

        System.out.println(answer);

    }
}