import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean calc(String str) {

        return str.contains("CD");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while(n-->0) {
            String str = br.readLine();

            boolean exists = calc(str);

            if(!exists) ans++;
        }

        System.out.println(ans);

    }

}
