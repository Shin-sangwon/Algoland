import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    protected static int calc(String tmp) {

        int arr[] = Stream.of(tmp.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        if(arr.length == 3) {

            if(arr[0] == 1 && arr[1] == 0) {
                return 10 + arr[2];
            }

            return 10 + arr[0];

        }

        if(arr.length == 4) {
            return 20;
        }

        return arr[0] + arr[1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(calc(br.readLine())+"");
        bw.flush();
        bw.close();
        br.close();

    }

}