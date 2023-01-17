import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    static HashMap<String, Double> index = new HashMap<>();

    static void init() {
        index.put("A+", 4.5);
        index.put("A0", 4.0);
        index.put("B+", 3.5);
        index.put("B0", 3.0);
        index.put("C+", 2.5);
        index.put("C0", 2.0);
        index.put("D+", 1.5);
        index.put("D0", 1.0);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 20;
        double score = 0;
        double num = 0;

        init();
        while(n --> 0) {
            String[] tmp = br.readLine().split(" ");

            if(tmp[2].equals("P")) continue;

            if(tmp[2].equals("F")) {
                num += Double.parseDouble(tmp[1]);
                continue;
            }

            num += Double.parseDouble(tmp[1]);
            score += Double.parseDouble(tmp[1]) * index.get(tmp[2]);
        }

        bw.write(String.format("%.6f", score / num));
        bw.flush();
        bw.close();
        br.close();
    }


}