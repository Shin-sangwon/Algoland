import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {

    static char calc(int sum) {

        if(sum == 0) {
            return 'D';
        }

        if(sum == 1) {
            return 'C';
        }

        if(sum == 2) {
            return 'B';
        }

        if(sum == 3) {
            return 'A';
        }

        if(sum == 4) {
            return 'E';
        }

        return 'Z';
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 3; i++) {
            int sum = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(x -> x == 1)
                    .sum();

            sb.append(calc(sum));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}