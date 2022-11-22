import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    public static int calc(HashSet<String> set, String type) {

        if(type.equals("Y")) {
            return set.size();
        }

        if(type.equals("F")) {
            return set.size() / 2;
        }

        return set.size() / 3;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        HashSet<String> set = new HashSet<>();

        while(n-->0) {
            set.add(br.readLine());
        }

        int answer = calc(set, type);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }

}