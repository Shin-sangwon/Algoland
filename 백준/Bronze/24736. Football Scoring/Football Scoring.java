import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    static int calc(int arr[]) {
        int ans = 0;

        ans += arr[0] * 6;
        ans += arr[1] * 3;
        ans += arr[2] * 2;
        ans += arr[3] * 1;
        ans += arr[4] * 2;

        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 2; i++) {

            int arr[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            sb.append(calc(arr)+" ");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }

}