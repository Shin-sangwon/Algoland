import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] rank;
    private static int find(int x) {
        if(arr[x] == x) return x;
        return find(arr[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return false;

        if(rank[x] < rank[y]) {
            arr[x] = y;
        }else if(rank[x] > rank[y]) {
            arr[y] = x;
        } else {
            arr[y] = x;
            rank[x]++;
        }

        return true;

    }

    private static boolean checker(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        rank = new int[n+1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }

        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //0 union, 1 find
            if(flag == 0) {
                union(a, b);
                continue;
            }

            sb.append(checker(a,b)?"YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}