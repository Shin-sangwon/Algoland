import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    static boolean calc(int x, int delim){

        while(x != 0){
            if(x % 10 == delim) return true;

            x /= 10;

        }


        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        boolean arr[] = new boolean[4000001]; arr[0] = true; arr[1] = true;
        //에라토스테네스의 체 false가 소수
        for(int i = 2; i < arr.length; i++){
            if(arr[i]) continue;
            for(int j = i * 2; j < arr.length; j += i){
                arr[j] = true;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int delim = Integer.parseInt(st.nextToken());

        for(int i = a; i <= b; i++){
            if(!arr[i] && calc(i, delim)){
                ans++;
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }


}
