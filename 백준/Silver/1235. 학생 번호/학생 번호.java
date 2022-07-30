import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class Main {

    private static int solution(String[] arr) {
        int ans = 0;
        int size = arr[0].length();
        while(true){
            HashSet<String> set = new HashSet<>();

            for(int i = 0; i < arr.length; i++){
                set.add(arr[i].substring(size-1-ans));
            }

            if(set.size() == arr.length){
                break;
            }

            ans++;
        }


        return ans + 1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        String arr[] = new String[n];


        for(int i = 0; i < n ; i++){
            arr[i] = br.readLine();
        }

        bw.write(solution(arr)+"");
        bw.flush();
        bw.close();
        br.close();

    }


}