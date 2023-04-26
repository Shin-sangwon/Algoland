import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) / 2;
        String target = br.readLine();

        String index1 = target.substring(0, n);
        String index2 = target.substring(n, n * 2);

        System.out.println(index1.equals(index2) ? "Yes" : "No");
    }
}
