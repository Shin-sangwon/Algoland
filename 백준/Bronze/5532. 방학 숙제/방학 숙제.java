import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int calc(int a, int b, int c, int d){
        int ans = 0;

        while(true){
            if(a <= 0 && b <= 0){
                break;
            }
            a -= c;
            b -= d;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Integer.parseInt(br.readLine()) - calc(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())));

    }
}
