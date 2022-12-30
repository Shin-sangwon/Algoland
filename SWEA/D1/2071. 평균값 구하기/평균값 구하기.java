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

        int n = Integer.parseInt(br.readLine());
        int idx = 1;

        while(n-->0) {

            double answer = Stream.of(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(-1);

            long roundedAnswer = Math.round(answer);
            sb.append("#").append(idx++).append(" " + roundedAnswer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
