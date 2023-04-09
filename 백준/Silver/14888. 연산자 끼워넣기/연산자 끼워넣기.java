import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int n, max, min;
    static int[] arr, expression;

    private static void dfs(int num, int cnt) {

        if(cnt == n) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i < 4; i++) {

            if(expression[i] == 0) continue;

            expression[i]--;

            if(i == 0) {
                dfs(num + arr[cnt], cnt + 1);
            }else if(i == 1) {
                dfs(num - arr[cnt], cnt + 1);
            }else if(i == 2) {
                dfs(num * arr[cnt], cnt + 1);
            }else {
                dfs(num / arr[cnt], cnt + 1);
            }

            expression[i]++;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine()
                          .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        expression = Stream.of(br.readLine()
                                 .split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(arr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

}
