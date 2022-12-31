import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void calc(String str, StringBuilder sb) {

        if(str.equals("CU")) {
            sb.append("see you");
            return;
        }

        if(str.equals(":-)")) {
            sb.append("I’m happy");
            return;
        }

        if(str.equals(":-(")) {
            sb.append("I’m unhappy");
            return;
        }

        if(str.equals(";-)")) {
            sb.append("wink");
            return;
        }

        if(str.equals(":-P")) {
            sb.append("stick out my tongue");
            return;
        }

        if(str.equals("(~.~)")) {
            sb.append("sleepy");
            return;
        }

        if(str.equals("TA")) {
            sb.append("totally awesome");
            return;
        }

        if(str.equals("CCC")) {
            sb.append("Canadian Computing Competition");
            return;
        }

        if(str.equals("CUZ")) {
            sb.append("because");
            return;
        }

        if(str.equals("TY")) {
            sb.append("thank-you");
            return;
        }

        if(str.equals("YW")) {
            sb.append("you're welcome");
            return;
        }

        if(str.equals("TTYL")) {
            sb.append("talk to you later");
            return;
        }

        sb.append(str);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine()) != null) {
            calc(str, sb);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}