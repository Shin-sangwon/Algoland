import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INDEX = 6;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            if(x % 2 == 0) {
                x = (x / 2)^ INDEX;
                continue;
            }

            x = (x * 2) ^ INDEX;
        }

        System.out.println(x);
    }
}
