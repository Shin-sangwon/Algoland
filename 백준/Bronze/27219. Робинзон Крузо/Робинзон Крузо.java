import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            if(i % 5 == 0) {
                sb.delete(sb.length() - 4, sb.length());
                sb.append("V");
                continue;
            }

            sb.append("I");
        }

        System.out.println(sb);

    }
}
