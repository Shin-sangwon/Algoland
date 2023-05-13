import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Integer> numbers;

    private static void dfs(int n, int cnt) {

        if(cnt == 10) {
            return;
        }

        numbers.add(n);

        for(int i = 0; i < 10; i++) {
            if(n % 10 > i) {
                dfs((n * 10) + i, cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();

        if(n > 1022) {
            System.out.println(-1);
            return;
        }

        if(n == 1022) {
            System.out.println("9876543210");
            return;
        }

        for(int i = 0; i < 10; i++) {
            dfs(i, 1);
        }

        Collections.sort(numbers);

        System.out.println(numbers.get(n));



        
    }
}