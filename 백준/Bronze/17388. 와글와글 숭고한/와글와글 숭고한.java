import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void print(int s, int k, int h){

        if(s + k + h >= 100){
            System.out.println("OK");
            return;
        }

        int ans = Math.min(s, Math.min(k, h));

        if(ans == s){
            System.out.println("Soongsil");
            return;
        }

        if(ans == k){
            System.out.println("Korea");
            return;
        }

        if(ans == h){
            System.out.println("Hanyang");
            return;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        print(s,k,h);




    }
}
