import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    final static String INDEX[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int calc(String str) {

        if(str.equals(INDEX[0])) {
            return 0;
        }

        if(str.equals(INDEX[1])) {
            return 1;
        }

        if(str.equals(INDEX[2])) {
            return 2;
        }

        if(str.equals(INDEX[3])) {
            return 3;
        }

        if(str.equals(INDEX[4])) {
            return 4;
        }

        if(str.equals(INDEX[5])) {
            return 5;
        }

        if(str.equals(INDEX[6])) {
            return 6;
        }

        if(str.equals(INDEX[7])) {
            return 7;
        }

        if(str.equals(INDEX[8])) {
            return 8;
        }

        if(str.equals(INDEX[9])) {
            return 9;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> al = new ArrayList<>();

        for(int i = n; i <= m; i++) {
            sb = new StringBuilder().append(i);
            int tmpInt = Integer.parseInt(sb.reverse().toString());
            sb.setLength(0);
            while(tmpInt != 0) {

                if(i % 10 == 0) {
                    sb.append(INDEX[tmpInt % 10]);
                    sb.append(" ");
                    sb.append(INDEX[0]);
                    break;
                }

                sb.append(INDEX[tmpInt % 10]);
                sb.append(" ");
                tmpInt /= 10;
            }

            al.add(sb.toString());

        }

        Collections.sort(al);
        sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0 ; i < al.size(); i++) {
            cnt++;
            String tmp[] = al.get(i).split(" ");

            for(String x : tmp) {
                sb.append(calc(x));
            }

            sb.append(" ");

            if(cnt == 10) {
                sb.append("\n");
                cnt = 0;
            }

        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }

}