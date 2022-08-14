import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();

            if(name.equals("#")) break;

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            sb.append(name + " ").append(age > 17 || weight >= 80? "Senior" : "Junior").append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
