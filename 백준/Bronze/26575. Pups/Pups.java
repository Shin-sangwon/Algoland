import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            double answer = Stream.of(br.readLine()
                                        .split(" "))
                                  .mapToDouble(Double::parseDouble)
                                  .reduce(1, (a, b) -> a * b);

            sb.append(String.format("$%.2f\n", answer));
        }

        System.out.println(sb);

    }
}
