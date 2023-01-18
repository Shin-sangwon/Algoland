import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int NINE = 9;
    private static int calcLen(int n) {
        int length = 0;

        while(n != 0) {
            length += 1;
            n /= 10;
        }

        return length;
    }

    private static long calc(int n, int length) {
        long answer = 0;

        if(length == 1) {
            return n;
        }

        answer += (Math.abs(n - Math.pow(10, length-1)) + 1) * length--;

        while(length > 0) {

            answer += (int) (NINE * Math.pow(10, length-1)) * length;
            length--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int length = calcLen(n);

        long answer = calc(n, length);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}