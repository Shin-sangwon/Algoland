import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Double> stack = new Stack<>();
        // 피연산자의 개수
        int n = Integer.parseInt(br.readLine());

        String expresion = br.readLine();
        char idx = 'A';
        Double index[] = new Double[n];

        for(int i = 0; i < n; i++) {
            index[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < expresion.length(); i++) {
            if(Character.isAlphabetic(expresion.charAt(i))) {
                stack.push(index[expresion.charAt(i) - idx]);
                continue;
            }

            Double tmp2 = stack.pop();
            Double tmp1 = stack.pop();

            if(expresion.charAt(i) == '+') {
                stack.push(tmp1 + tmp2);
                continue;
            }

            if(expresion.charAt(i) == '-') {
                stack.push(tmp1 - tmp2);
                continue;
            }

            if(expresion.charAt(i) == '*') {
                stack.push(tmp1 * tmp2);
                continue;
            }

            if(expresion.charAt(i) == '/') {
                stack.push(tmp1 / tmp2);
                continue;
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
        br.close();

    }

}