import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            st = new StringTokenizer(br.readLine());

            String tmp = st.nextToken();

            if(tmp.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            if(tmp.equals("pop")) {

                if(q.isEmpty()) {
                    sb.append(-1 + "\n");
                    continue;
                }

                sb.append(q.poll() + "\n");
                continue;

            }

            if(tmp.equals("size")) {
                sb.append(q.size() + "\n");
                continue;
            }

            if(tmp.equals("empty")) {

                if(q.isEmpty()) {
                    sb.append(1 + "\n");
                    continue;
                }

                sb.append(0 + "\n");
                continue;

            }

            if(tmp.equals("front")) {

                if(q.isEmpty()) {
                    sb.append(-1 + "\n");
                    continue;
                }

                sb.append(q.getFirst() + "\n");
                continue;
            }

            if(tmp.equals("back")) {

                if(q.isEmpty()) {
                    sb.append(-1 + "\n");
                    continue;
                }

                sb.append(q.getLast() + "\n");
                continue;
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}