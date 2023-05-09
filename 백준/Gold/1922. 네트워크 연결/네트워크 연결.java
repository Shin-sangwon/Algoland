import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[] root;
    static int n, m;

    static class Node {

        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static boolean union(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false;
        }

        root[rootY] = rootX;

        return true;
    }

    private static int find(int x) {

        if (root[x] == x) {
            return x;
        }

        return root[x] = find(root[x]);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        root = new int[n+1];
        Node[] nodeList = new Node[m];

        for(int i = 1; i < n+1; i++) {
            root[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodeList[i] = new Node(from, to, weight);
        }

        Arrays.sort(nodeList, (o1, o2) -> o1.weight - o2.weight);

        int count = 0;
        int totalWeight = 0;

        for(Node node : nodeList) {
            if(union(node.from, node.to)) {
                totalWeight += node.weight;
                if(++count == n) break;
            }
        }

        System.out.println(totalWeight);

    }
}