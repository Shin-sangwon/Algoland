import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Node{
        long x;
        int time;

        public Node(long x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static long calc(long x) {

        StringBuilder tmp = new StringBuilder(String.valueOf(x * 10));
        tmp.setCharAt(tmp.length()-1, '1');

        return Long.parseLong(tmp.toString());
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start , 0));
        int answer = -1;

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.x == target) {
                answer = node.time + 1;
                break;
            }

            if(node.x * 2 <= target) queue.add(new Node(node.x * 2, node.time + 1));
            if(calc(node.x) <= target) queue.add(new Node(calc(node.x), node.time + 1));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}