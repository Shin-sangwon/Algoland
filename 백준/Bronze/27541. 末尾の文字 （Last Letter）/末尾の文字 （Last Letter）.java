import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder().append(br.readLine());

        System.out.println(sb.charAt(n-1) == 'G' ? sb.substring(0, n-1) : sb.append('G'));

    }
}
