import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int index[] =
                Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxScore = Integer.MIN_VALUE;
        int student = 0;

        while(m-->0) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int score = 0;
            for(int i = 0; i < n; i++) {
                if(st.nextToken().equals("O")) {
                    score += index[i];
                }
            }

            if(score > maxScore) {
                student = num;
                maxScore = score;
                continue;
            }

            if(score == maxScore) {

                if(num < student) {
                    student = num;
                    maxScore = score;
                    continue;
                }
            }
        }

        bw.write("%d %d".formatted(student, maxScore));
        bw.flush();
        bw.close();
        br.close();
    }

}