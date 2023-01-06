import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> map = new TreeMap<>();

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            map.put(st.nextToken(), 0);
        }

        while(n --> 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {

                map.merge(st.nextToken(), 1, Integer::sum);

            }

        }

        Map<String, Integer> answer = new TreeMap<>((o1, o2) -> {
            int value = Integer.compare(map.get(o2), map.get(o1));
            return value != 0 ? value : o1.compareTo(o2);
        });

        answer.putAll(map);

        answer.forEach((key, value) -> sb.append(key + " " + value).append("\n"));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();



    }
}