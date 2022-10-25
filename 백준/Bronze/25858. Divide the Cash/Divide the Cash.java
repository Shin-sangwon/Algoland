import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int totalPrize = Integer.parseInt(st.nextToken());

        int totalNum = 0;
        int arr[] = new int[n];


        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            totalNum += tmp;
            arr[i] = tmp;
        }

        totalPrize /= totalNum;

        for(int i = 0; i < n; i++) {
            sb.append(arr[i] * totalPrize).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}