import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            int lemon = Integer.parseInt(st.nextToken());

            answer = Math.max(answer, lemon - (n + 1 - i));
        }

        System.out.println(answer);
    }
}
