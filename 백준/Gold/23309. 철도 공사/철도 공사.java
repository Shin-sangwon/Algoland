import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] nodes = new Node[1000001];
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int target = Integer.parseInt(st.nextToken());

            switch (command) {
                case "BN":
                    int id1 = Integer.parseInt(st.nextToken());
                    insertAfter(target, id1);
                    break;
                case "BP":
                    int id2 = Integer.parseInt(st.nextToken());
                    insertBefore(target, id2);
                    break;
                case "CN":
                    deleteAfter(target);
                    break;
                default:
                    deleteBefore(target);
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() {
        for (int i = 1; i < arr.length - 1; i++) {
            int id = arr[i];
            Node node = new Node(arr[i - 1], arr[i + 1]);
            nodes[id] = node;
        }

        nodes[arr[0]] = new Node(arr[arr.length - 1], arr[1]);
        nodes[arr[arr.length - 1]] = new Node(arr[arr.length - 2], arr[0]);
    }

    static void insertAfter(int target, int id) {
        int rightNumber = nodes[target].right;

        Node node = new Node(target, rightNumber);
        nodes[id] = node;

        nodes[target].right = id;
        nodes[rightNumber].left = id;

        sb.append(rightNumber).append("\n");
    }

    static void insertBefore(int target, int id) {
        int leftNumber = nodes[target].left;

        Node node = new Node(leftNumber, target);
        nodes[id] = node;

        nodes[leftNumber].right = id;
        nodes[target].left = id;

        sb.append(leftNumber).append("\n");
    }

    static void deleteAfter(int target) {
        int deleteNumber = nodes[target].right;
        int changedNumber = nodes[deleteNumber].right;

        sb.append(deleteNumber).append("\n");

        nodes[target].right = changedNumber;
        nodes[changedNumber].left = target;

        nodes[deleteNumber] = null;
    }

    static void deleteBefore(int target) {
        int deleteNumber = nodes[target].left;
        int changedNumber = nodes[deleteNumber].left;

        sb.append(deleteNumber).append("\n");

        nodes[target].left = changedNumber;
        nodes[changedNumber].right = target;

        nodes[deleteNumber] = null;
    }
}
