import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = Integer.parseInt(br.readLine());

        List<Integer> arr =
                Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int count = (int) arr.stream().filter(x -> x == answer).count();

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();


    }
}