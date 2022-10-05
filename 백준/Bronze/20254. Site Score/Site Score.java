import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    static final int ARR[] = {56, 24, 14, 6};

    public static int sum(int input[]) {
        int answer = 0;

        for(int i = 0; i < 4; i++) {
            answer += ARR[i] * input[i];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input[] = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int answer = sum(input);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}