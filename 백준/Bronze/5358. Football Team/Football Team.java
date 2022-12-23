import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String tmp;
        while((tmp = br.readLine()) != null) {
            
            
            for(int i = 0; i < tmp.length(); i++) {
                if(tmp.charAt(i) == 'i') {
                    sb.append("e");
                    continue;
                }

                if(tmp.charAt(i) == 'e') {
                    sb.append("i");
                    continue;
                }

                if(tmp.charAt(i) == 'I') {
                    sb.append("E");
                    continue;
                }

                if(tmp.charAt(i) == 'E') {
                    sb.append("I");
                    continue;
                }


                sb.append(tmp.charAt(i));
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}