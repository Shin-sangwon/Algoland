import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static class Node{

        int value;
        int len;

        public Node(int value, int len) {
            this.value = value;
            this.len = len;
        }

    }

    private static int calcLen(int n) {
        int length = 0;

        while(n != 0) {
            length += 1;
            n /= 10;
        }

        return length;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        Node arr[] = new Node[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > max) {
                max = tmp;
            }

            arr[i] = new Node(tmp, calcLen(tmp));

        }

        int maxLength = calcLen(max);

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                // 같은 길이의 숫자면 큰 수가 앞으로
                if(o1.len == o2.len) {
                    return o2.value - o1.value;
                }

                //길이가 다른 숫자라면, 두 숫자를 합쳐서 비교하여 정렬
                String tmp1 = String.valueOf(o1.value) + String.valueOf(o2.value);
                String tmp2 = String.valueOf(o2.value) + String.valueOf(o1.value);

                return (tmp2+tmp1).compareTo(tmp1+tmp2);
            }
        });

        for(Node x : arr) {
            sb.append(x.value);
        }

        bw.write(sb.charAt(0) == '0'? "0" : sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}