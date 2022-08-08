import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int totalCase = Integer.parseInt(br.readLine());

        while(totalCase-->0){
            st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int arr[] = new int[3];
            for(int i = 0; i < 3; i++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp > max) max = tmp;
                if(tmp < min) min = tmp;
                arr[i] = tmp;
            }

            if((arr[0] == max && arr[2] == min) || (arr[0] == min && arr[2] == max)){
                sb.append("Ordered\n");
                continue;
            }

            sb.append("Unordered\n");
        }
        bw.write("Gnomes:\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
