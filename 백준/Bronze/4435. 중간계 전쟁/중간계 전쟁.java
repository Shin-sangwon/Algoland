import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final String GANDALF = "Good triumphs over Evil\n";
        final String SAURON = "Evil eradicates all trace of Good\n";
        final String DRAW = "No victor on this battle field\n";

        final int gandalfScore[] = new int[]{1,2,3,3,4,10};
        final int sauronScore[] = new int[]{1,2,2,2,3,5,10};

        int testCase = Integer.parseInt(br.readLine());
        int idx = 1;
        while(testCase --> 0) {
            int firstTeam = 0;
            int lastTeam = 0;

            int gandalfNum[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sauronNum[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 0; i < 7; i++) {

                if(i == 6) {
                    lastTeam += sauronScore[i] * sauronNum[i];
                    break;
                }
                firstTeam += gandalfScore[i] * gandalfNum[i];
                lastTeam += sauronScore[i] * sauronNum[i];
            }

            sb.append("Battle ").append(idx++).append(": ");
            sb.append(lastTeam == firstTeam? DRAW : firstTeam > lastTeam? GANDALF : SAURON);


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}