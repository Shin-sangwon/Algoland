import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static String calc(int a, int b){

        if(a == 0 || b == 0) return "neither";

        if(a > b && a % b == 0) {
            return "multiple";
        }

        if(a < b && b % a == 0) {
            return "factor";
        }

        return "neither";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) {
                System.out.println(sb);
                break;
            }
            sb.append(calc(a, b)).append("\n");

        }
    }
}
