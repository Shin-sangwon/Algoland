import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class Main {

    static StringBuilder sb;
    static class Node {

        Character data;
        Node left;
        Node right;

        public Node(Character data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public void setRight(Node node) {
            this.right = node;
        }

    }

    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            sb.append(node.data);
            inorder(node.right);
        }
    }

    public static void preorder(Node node) {
        if(node != null) {
            sb.append(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            sb.append(node.data);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Node> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put((char) (i + 65), new Node((char) (i + 65)));
        }

        while(n-- > 0) {
            char arr[] = br.readLine().toCharArray();

            if(arr[2] != '.') map.get(arr[0]).setLeft(map.get(arr[2]));
            if(arr[4] != '.') map.get(arr[0]).setRight(map.get(arr[4]));
        }

        preorder(map.get('A')); sb.append("\n");
        inorder(map.get('A')); sb.append("\n");
        postorder(map.get('A'));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();





    }
}