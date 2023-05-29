import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean calc(int n) {

        String str = String.valueOf(n-1);

        return str.contains("50");
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i = 1; i <= n; i++) {

            cnt++;

            if(calc(i)) cnt++;
        }

        System.out.println(cnt);
    }
}
