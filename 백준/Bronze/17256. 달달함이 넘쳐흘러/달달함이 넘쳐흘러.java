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

        int a[] = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int c[] = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int b[] = new int[3];

        b[0] = c[0] - a[2];
        b[1] = c[1] / a[1];
        b[2] = c[2] - a[0];

        for(int x : b) {
            bw.write(x + " ");
        }

        bw.flush();
        bw.close();
        br.close();


    }

}