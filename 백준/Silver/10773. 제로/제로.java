import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int totalCase = Integer.parseInt(br.readLine());
        int ans = 0;

        while(totalCase-->0) {
            int tmp = Integer.parseInt(br.readLine());

            if(tmp != 0) {
                stack.push(tmp);
                continue;
            }
            
            stack.pop();
        }

        for(int x : stack) ans += x;

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
