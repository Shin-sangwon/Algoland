import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());
        int index = 1;
        while(n-->0) {
            int arr[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            double tmp = 0;
            for(int i = 0; i < 8; i++) {
                tmp += arr[i+1];
            }
            sb.append("#" + index++ + " ");
            sb.append(String.format("%.0f", tmp / 8)).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}