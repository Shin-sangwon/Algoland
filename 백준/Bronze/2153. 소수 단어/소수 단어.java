import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int answer = 0;

        // 'A' == 65 , 'a' = 97

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                answer += str.charAt(i) - 38;
                continue;
            }

            answer += str.charAt(i) - 96;
        }

        boolean flag = false;

        for(int i = 2; i < answer; i++) {
            if(answer % i == 0) {
                flag = true;
                break;
            }
        }

        if(answer == 2) flag = false;

        bw.write(flag? "It is not a prime word." : "It is a prime word.");
        bw.flush();
        bw.close();
        br.close();



    }
}