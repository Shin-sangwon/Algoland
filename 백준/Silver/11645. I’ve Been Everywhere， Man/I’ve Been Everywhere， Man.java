import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int totalCase = Integer.parseInt(br.readLine());

        while(totalCase-->0) {

            int wordCount = Integer.parseInt(br.readLine());
            HashSet<String> set = new HashSet<>();

            for(int i = 0; i < wordCount; i++) {
                set.add(br.readLine());
            }

            sb.append(set.size()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}