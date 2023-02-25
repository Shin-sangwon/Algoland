import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    private static void combi(int cnt, int start, int[] arr, int[] number) {

        if(cnt == 6) {
            for(int x : number) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < arr.length; i++) {

            number[cnt] = arr[i];
            combi(cnt + 1, i + 1, arr, number);

        }
    }

     public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        sb = new StringBuilder();
        int[] arr, number;


        while(true) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            number = new int[6];
            for(int i = 0; i < n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combi(0, 0, arr, number);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();



    }
}