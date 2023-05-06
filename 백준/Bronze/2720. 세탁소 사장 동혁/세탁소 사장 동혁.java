import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    static int[] calc(int target) {

        int[] res = new int[4];

        if(target >= 25) {
            res[0] += target / 25;
            target -= 25 * res[0];
        }

        if(target >= 10) {
            res[1] += target / 10;
            target -= 10 * res[1];
        }

        if(target >= 5) {
            res[2] += target / 5;
            target -= 5 * res[2];
        }

        if(target >= 1) {
            res[3] += target;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {

            int target = Integer.parseInt(br.readLine());

            int[] res = calc(target);

            String answer = Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }
}