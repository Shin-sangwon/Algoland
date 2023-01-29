import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        while(!queue.isEmpty()) {

            if(visited[target] != 0) break;
            int now = queue.poll();

            for(int k = 0; k < 3; k++) {

                if(k == 0) {
                    if(now * 2 > 100000 || visited[now * 2] != 0) continue;
                    visited[now * 2] = visited[now];
                    queue.add(now * 2);
                    continue;
                }

                if(k == 1) {
                    if(now - 1 < 0 || visited[now - 1] != 0) continue;
                    visited[now - 1] = visited[now] + 1;
                    queue.add(now - 1);
                    continue;
                }

                if(now + 1 > 100000 || visited[now + 1] != 0) continue;
                visited[now + 1] = visited[now] + 1;
                queue.add(now + 1);

            }


        }

        bw.write(String.valueOf(visited[target] - 1));
        bw.flush();
        bw.close();
        br.close();


    }
}