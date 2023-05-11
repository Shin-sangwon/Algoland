import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int index = n * 2 - 1;

        for(int i = 1; i <= index; i++) {

            if(i < n) {

                for(int j = 0; j < n - i; j++) {
                    sb.append(" ");
                }

                for(int k = 0; k < i * 2 - 1; k++) {
                    sb.append("*");
                }

                sb.append("\n");

            }

            if(i > n) {

                for(int j = 0; j < i - n; j++) {
                    sb.append(" ");
                }

                for(int j = 0; j < (index - i + 1) * 2 - 1; j++) {
                    sb.append("*");
                }

                sb.append("\n");
            }

            if(i == n) {
                for(int j = 0; j < index; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }
}