import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n,target, answer, arr[];

/*    private static void recur(int cnt, int start, int depth, int[] numbers) {

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

    }*/

    private static void generatedSubSet(int cnt, int sum) {

        if(cnt == n) {
            if(sum == target) {
                answer++;
            }
            return;
        }

        generatedSubSet(cnt + 1, sum + arr[cnt]);
        generatedSubSet(cnt + 1, sum);


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

        generatedSubSet(0, 0);
        answer = (target == 0? answer -=1 : answer);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();

    }


}