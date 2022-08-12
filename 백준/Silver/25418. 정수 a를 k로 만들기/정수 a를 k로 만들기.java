import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[1000001];
        boolean visited[] = new boolean[1000001];
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        arr[a] = 1;
        q.add(a);
        int ans = 0;
        while(visited[target] == false) {
            while(!q.isEmpty()) {
                int x = q.poll();

                if(x + 1 <= 1000000 && visited[x+1] == false) {
                    visited[x+1] = true;
                    arr[x+1] = arr[x] + 1;
                    q.add(x+1);
                }

                if(x * 2 <= 1000000 && visited[x * 2] == false) {
                    visited[x * 2] = true;
                    arr[x * 2] = arr[x] + 1;
                    q.add(x * 2);
                }

                if(x == target) {
                    ans = arr[target];
                    break;
                }

            }
        }

        bw.write(ans - 1 +"");
        bw.flush();
        bw.close();
        br.close();

    }
}
