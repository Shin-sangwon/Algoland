import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int idx;
        int num;
        int cnt;

        public Node(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int answer = -1;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, arr[start], 0));
        visited[start] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.idx == target) {
                answer = node.cnt;
                break;
            }

            for(int i = 1; node.idx + (arr[node.idx] * i) <= n; i++) {
                int tmp = node.idx + arr[node.idx] * i;
                if(visited[tmp]) continue;

                queue.add(new Node(tmp, arr[tmp], node.cnt + 1));
                visited[tmp] = true;
            }

            for(int i = 1; node.idx - (arr[node.idx] * i) >= 1; i++) {
                int tmp = node.idx - arr[node.idx] * i;
                if(visited[tmp]) continue;

                queue.add(new Node(tmp, arr[tmp], node.cnt + 1));
                visited[tmp] = true;
            }
        }

        System.out.println(answer);

    }
}
