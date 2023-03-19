import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        String idx = br.readLine();
        String check = br.readLine();

        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(idx.charAt(i) != check.charAt(i)) answer++;
        }
        System.out.println(answer);
    }
}
