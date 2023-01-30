import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static boolean[] prime;

    private static ArrayList<Integer> converter(int now, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        int start = (k == 0) ? 1 : 0;
        for (int i = start; i <= 9; i++) {
            StringBuilder sb = new StringBuilder();
            switch (k) {
                case 0:
                    sb.append(i).append(String.valueOf(now).substring(1, 4));
                    break;
                case 1:
                    sb.append(now / 1000).append(i).append(String.valueOf(now).substring(2, 4));
                    break;
                case 2:
                    sb.append(now / 100).append(i).append(String.valueOf(now).charAt(3));
                    break;
                default:
                    sb.append(String.valueOf(now).substring(0, 3)).append(i);
                    break;
            }
            int convertingNumber = Integer.parseInt(sb.toString());
            if (!prime[convertingNumber]) al.add(convertingNumber);
        }
        return al;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue;
        int[] visited;
        prime = new boolean[10000];

        for(int i = 2; i < prime.length; i++) {
            if(prime[i]) continue;
            for(int j = 2 * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        while( n-- > 0) {

            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int target = Integer.parseInt(inputs[1]);

            visited = new int[10000];
            queue = new LinkedList<>();

            queue.add(start);
            visited[start] = 1;

            while(!queue.isEmpty()) {

                if(visited[target] != 0) break;

                int now = queue.poll();

                for(int k = 0; k < 4; k++) {
                    ArrayList<Integer> al = converter(now, k);
                    for(int x : al) {
                        if(visited[x] != 0) continue;
                        visited[x] = visited[now] + 1;
                        queue.add(x);
                    }
                }
            }

            sb.append(visited[target]-1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}