import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeMap;


public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        TreeMap<Character, Integer> map;

        int n = Integer.parseInt(br.readLine());
        int idx = 1;
        while(n -- > 0 ) {
            map = new TreeMap<>();

            String tmp = br.readLine();

            for(int i = 0; i < tmp.length(); i++) {
                map.put(tmp.charAt(i), map.getOrDefault(tmp.charAt(i), 0) + 1);

                if(map.get(tmp.charAt(i)) == 2) {
                    map.remove(tmp.charAt(i));
                }
            }

            sb.append(String.format("#%d ", idx++));
            if(map.size() == 0) {
                sb.append("Good").append("\n");
                continue;
            }
            for(Character x : map.keySet()) {
                sb.append(x);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}