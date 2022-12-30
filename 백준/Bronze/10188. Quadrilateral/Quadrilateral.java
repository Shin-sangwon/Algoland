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
            int arr[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int i = 0; i < arr[1]; i++) {
                for(int j = 0; j < arr[0]; j++) {
                    sb.append("X");
                }
                sb.append("\n");
            }

            sb.append("\n");


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}