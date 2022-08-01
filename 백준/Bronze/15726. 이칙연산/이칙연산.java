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
        StringTokenizer st = new StringTokenizer(br.readLine());


        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());


        int ans = (int)Math.max(a * b / c, a / b * c);

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
