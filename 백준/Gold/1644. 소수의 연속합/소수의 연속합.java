import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1, 4000000

        int target = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체

        boolean prime[] = new boolean[target+1];

        for(int i = 2; i < prime.length; i++) {
            if(prime[i] == true) continue;
            for(int j = i * 2; j < prime.length; j+=i) {
                prime[j] = true;
            }
        }

        ArrayList<Integer> al = new ArrayList<>();

        for(int i = 2; i < prime.length; i++) {
            if(prime[i] == false) al.add(i);
        }

        //투 포인터
        int endIdx = 0;
        int sum = 0;
        int answer = 0;

        for(int startIdx = 0; startIdx < al.size(); startIdx++) {

            while(endIdx < al.size() && sum < target) {
                sum += al.get(endIdx);
                endIdx++;
            }

            if(sum == target) answer++;
            sum -= al.get(startIdx);

        }


        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();

    }
}