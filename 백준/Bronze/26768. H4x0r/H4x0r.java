import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static char replace(char tmp) {

        if(tmp == 'a') {
            return '4';
        }

        if(tmp == 'e') {
            return '3';
        }

        if(tmp == 'i') {
            return '1';
        }

        if(tmp == 'o') {
            return '0';
        }

        return '5';

    }

    public static boolean checker(char tmp) {

        if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 's') return true;

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if(checker(tmp)) {
                sb.append(replace(tmp));
                continue;
            }

            sb.append(tmp);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}