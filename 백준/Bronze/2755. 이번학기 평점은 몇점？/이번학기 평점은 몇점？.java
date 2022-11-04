import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static double calc(String str) {

        if(str.equals("A+")) {
            return 4.3;
        }

        if(str.equals("A0")) {
            return 4.0;
        }

        if(str.equals("A-")) {
            return 3.7;
        }

        if(str.equals("B+")) {
            return 3.3;
        }

        if(str.equals("B0")) {
            return 3.0;
        }

        if(str.equals("B-")) {
            return 2.7;
        }

        if(str.equals("C+")) {
            return 2.3;
        }

        if(str.equals("C0")) {
            return 2;
        }

        if(str.equals("C-")) {
            return 1.7;
        }

        if(str.equals("D+")) {
            return 1.3;
        }

        if(str.equals("D0")) {
            return 1.0;
        }

        if(str.equals("D-")) {
            return 0.7;
        }

        return 0.0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int total = 0;
        double score = 0;

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            //과목 정보는 필요 없으므로
            st.nextToken();

            int tmp = Integer.parseInt(st.nextToken());
            total += tmp;

            score += calc(st.nextToken()) * tmp;

        }

        double answer = score / total;

        bw.write(String.format("%.2f", answer));
        bw.flush();
        bw.close();
        br.close();


    }

}