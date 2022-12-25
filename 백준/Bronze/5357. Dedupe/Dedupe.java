import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n --> 0) {
            sb.setLength(0);
            char arr[] = br.readLine().toCharArray();

            sb.append(arr[0]);

            for(int i = 1; i < arr.length; i++) {
                if(arr[i] == sb.charAt(sb.length()-1)) {
                    continue;
                }

                sb.append(arr[i]);
            }

            answer.append(sb.toString()).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}