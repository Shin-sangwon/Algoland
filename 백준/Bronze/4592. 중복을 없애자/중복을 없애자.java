import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true) {
            int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            if(arr[0] == 0) break;

            sb.append(arr[1])
              .append(" ");

            for(int i = 2; i < arr.length; i++) {
                if(arr[i] == arr[i-1]) continue;

                sb.append(arr[i]).append(" ");
            }

            sb.append("$\n");


        }

        System.out.println(sb);
    }
}
