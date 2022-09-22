import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static class Node{
        int country;
        int number;
        int score;

        public Node(int country, int number, int score) {
            this.country = country;
            this.number = number;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        while(n-->0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> o2.score - o1.score);

        HashMap<Integer, Integer> map = new HashMap<>();
        int answerCount = 0;

        for(int i = 0; i < list.size(); i++) {
            if(map.get(list.get(i).country) == null || map.get(list.get(i).country) < 2) {
                sb.append(list.get(i).country + " " + list.get(i).number).append("\n");
                map.put(list.get(i).country, map.getOrDefault(list.get(i).country, 0)+1);
                answerCount++;
            }

            if(answerCount == 3) break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.flush();
        br.close();


    }
}