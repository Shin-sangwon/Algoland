import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

    private static String calc(int a, int b) {

        if(a == 1) {
            if(b == 3) {
                return "A";
            }
        }

        if(a == 2) {
            if(b == 1) {
                return "A";
            }
        }

        if(a == 3) {
            if(b == 2) {
                return "A";
            }
        }

        return "B";

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //가위 1 바위 2 보 3 비기는경우 X
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String answer = calc(a, b);

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
