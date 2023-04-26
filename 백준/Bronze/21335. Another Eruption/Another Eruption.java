import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double in = Double.parseDouble(br.readLine());
        double radius = Math.sqrt(in / Math.PI);
        System.out.printf("%.9f", Math.PI * radius * 2);
    }
}
