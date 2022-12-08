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

        double arr[] = Stream.of(br.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();


        double m = (arr[1] - arr[0]) / 400;

        double answer = 1 / (1 + Math.pow(10, m));

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }

}