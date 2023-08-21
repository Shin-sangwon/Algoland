import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[] arr = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long target = Long.parseLong(br.readLine());

        long ans = 0;

        for(int i = 0; i < n; i++) {
            long tmp = 0;
            for(int j = i; j < n; j++) {
                tmp += arr[j];

                if(tmp <= target) continue;
                else {
                    ans += (n - j);
                    break;
                }
            }
        }

        System.out.println(ans);

    }
}