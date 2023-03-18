import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    private static boolean calc(int[] arr) {

        return Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            sb.append(String.format("Scenario #%d:\n", i));
            sb.append(calc(arr)? "yes\n\n" : "no\n\n");
        }

        System.out.println(sb);
    }
}
