import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int ans = 91;

        ans += Integer.parseInt(br.readLine());
        ans += Integer.parseInt(br.readLine()) * 3;
        ans += Integer.parseInt(br.readLine());

        System.out.printf("The 1-3-sum is %d", ans);
    }
}
