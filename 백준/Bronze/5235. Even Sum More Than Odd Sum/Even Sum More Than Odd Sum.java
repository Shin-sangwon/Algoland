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
        int n = Integer.parseInt(br.readLine());


        while(n-->0) {
            long ans = 0;

            long even = 0;
            long odd = 0;

            int arr[] = Stream.of(br.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 0; i < arr.length; i++) {
                if(arr[i] % 2 == 0) {
                    even += arr[i];
                    continue;
                }
                odd += arr[i];
            }

            if(even == odd) {
                sb.append("TIE").append("\n");
                continue;
            }

            sb.append(even > odd? "EVEN" : "ODD").append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}