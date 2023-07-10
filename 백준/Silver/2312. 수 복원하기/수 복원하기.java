import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        boolean arr[] = new boolean[100001];
        //에라토스테네스의 체 false가 소수
        for(int i = 2; i <= 100000; i++){
            if(arr[i]) continue;
            for(int j = i * 2; j <= 100000; j += i){
                arr[j] = true;
            }
        }

        int n = Integer.parseInt(br.readLine());

        while(n-->0) {
            int tmp = Integer.parseInt(br.readLine());
            int idx = 2;
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
            if(arr[tmp] == false) {
                System.out.println(tmp + " " + 1);
                continue;
            }

            while(tmp != 1) {
                if(tmp % idx == 0) {
                    map.put(idx, map.getOrDefault(idx, 0)+1);
                    tmp /= idx;
                    continue;
                }

                idx++;
            }


            for(Integer x : map.keySet()) {
                System.out.println(x + " " + map.get(x));
            }

        }

    }

}
