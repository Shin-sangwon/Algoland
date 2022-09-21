import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {

    static class Node{
        int score;
        int num;

        public Node(int score, int num) {
            this.score = score;
            this.num = num;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Node> list = new ArrayList<>();

        for(int i = 1; i <= 8; i++) {
            list.add(new Node(Integer.parseInt(br.readLine()), i));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.score - o1.score;
            }
        });

        int ans = 0;
        int ansArr[] = new int[5];

        for(int i = 0; i < 5; i++) {
            ans += list.get(i).score;
            ansArr[i] = list.get(i).num;
        }

        Arrays.sort(ansArr);

        StringBuilder sb = new StringBuilder();
        sb.append(ans+"\n");

        for(int i = 0; i < 5; i++) {
            sb.append(ansArr[i] + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


   }
}