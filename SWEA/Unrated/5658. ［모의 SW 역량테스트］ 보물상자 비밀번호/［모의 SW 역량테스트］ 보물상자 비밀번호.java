import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    static int n, k;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int printIndex = 1;

        while(tc-->0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            Queue<String> queue = new LinkedList<>();
            TreeSet<Integer> answer = new TreeSet<>(Collections.reverseOrder());

            StringBuilder tmp = new StringBuilder();

            String[] tokens = br.readLine().split("");

            for(String x : tokens) queue.add(x);

            int index = n / 4;

            for(int i = 0; i < n + index; i++) {

                tmp.append(queue.peek());
                queue.add(queue.poll());

                if(tmp.length() == index) {
                    answer.add(Integer.parseInt(tmp.toString(), 16));
                    tmp.deleteCharAt(0);
                }

            }

            ArrayList<Integer> al = new ArrayList<>(answer);
            sb.append(String.format("#%d %d\n", printIndex++, al.get(k-1)));

        }

        System.out.println(sb);

    }

}

