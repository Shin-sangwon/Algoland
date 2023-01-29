import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] dx = {1, -1};
        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int start = Integer.parseInt(br.readLine()) - 1;

        boolean[] visited = new boolean[n];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int now = queue.poll();

            for(int k = 0; k < 2; k++) {

                int nx = now + (arr[now] * dx[k]);

                if(nx < 0 || nx >= n || visited[nx]) continue;

                visited[nx] = true;
                queue.add(nx);

            }

        }

        int answer = 0;
        for(boolean x : visited) {
            if(x) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();



    }
}