import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
  좌측 상단과 우측 하단 --> x-y가 같은지 여부
  우측 상단과 좌측 하단 --> x+y가 같은지 여부
  행, 열에 같이 있을 수 없음 --> x, y좌표가 같으면 안됨
 */

public class Main {

    static int n,target, answer, arr[];

    private static void recur(int cnt, int start, int depth, int[] numbers) {

        if(cnt == depth) {
            int tmp = 0;
            for(int x : numbers) {
               tmp += x;
            }

            if(tmp == target) answer++;
            return;
        }

        for(int i = start; i < n; i++) {

            numbers[cnt] = arr[i];
            recur(cnt + 1, i + 1, depth, numbers);
        }

    }
     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        answer = 0;

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }



        for(int i = 1; i <= n; i++) {
            int[] numbers = new int[i];
            recur(0, 0, i, numbers);
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();

    }
}