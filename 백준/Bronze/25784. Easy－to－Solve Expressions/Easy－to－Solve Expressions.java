import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    static int calc(int arr[]) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if(a + b == c || a + c == b || b + c == a) {
            return 1;
        }

        if(a * b == c || a * c == b || b * c == a) {
            return 2;
        }



        return 3;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();


        bw.write(String.valueOf(calc(arr)));
        bw.flush();
        bw.close();
        br.close();



    }

}