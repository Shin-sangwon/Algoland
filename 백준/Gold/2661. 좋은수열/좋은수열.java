import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String answer = "";
    static int n;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        generate(0, "");

        System.out.println(answer);

    }

    private static void generate(int length, String sequence) {

        if(flag) return;

        if(length == n) {
            answer = sequence;
            flag = true;
            return;
        }

        for(int i = 1; i <= 3; i++) {
            String now = sequence + i;
            if(isGood(now)) {
                generate(length + 1, now);
            }
        }

    }

    private static boolean isGood(String sequence) {
        int length = sequence.length();

        for(int i = 1; i <= length / 2; i++) {
            String last = sequence.substring(length - i, length);
            String prev = sequence.substring(length - i * 2, length - i);

            if(last.equals(prev)) return false;
        }

        return true;
    }
}
