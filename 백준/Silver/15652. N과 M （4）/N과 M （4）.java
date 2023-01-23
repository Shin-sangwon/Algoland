import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int n,m;
    static int arr[];

    private static void recursive(int now, int depth) {
        if(depth == m) {
            for(int x : arr) sb.append(x + " ");
            sb.append("\n");
            return;
        }

        for(int i = now; i <= n; i++) {
            arr[depth] = i;
            recursive(i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        //n까지 자연수 중에서 m개를 고르기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        recursive(1, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}