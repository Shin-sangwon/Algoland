import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    // 한 줄에 각각 코직의 키, 코치가 요구한 키, 한 번 때릴 때마다 늘어나는 혹의 길이를 나타내는 세 정수 k, w, m (1 <= k <= 200, 1 <= w, m <= 10 ^ 9)가 주어집니다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(k >= w) {
            bw.write("0");
        }else {
            int ans = 0;

            while(true) {
                ans++;
                k += m;

                if(k >= w) break;

            }

            bw.write(ans+"");
        }

        bw.flush();
        bw.close();
        br.close();



    }
}