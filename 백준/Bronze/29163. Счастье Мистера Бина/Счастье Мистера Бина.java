import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int even = (int) Stream.of(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .filter(x -> x % 2 == 0)
                               .count();


        if(even > n - even) {
            System.out.print("Happy");
        }else {
            System.out.print("Sad");
        }

    }

}
