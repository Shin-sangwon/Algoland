import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static final String TTT = "TTT";
    static final String TTH = "TTH";
    static final String THT = "THT";
    static final String THH = "THH";
    static final String HTT = "HTT";
    static final String HTH = "HTH";
    static final String HHT = "HHT";
    static final String HHH = "HHH";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr[];

        while(n-->0) {
            String tmp = br.readLine();
            arr = new int[8];

            for(int i = 0; i < 38; i++) {
                String str = tmp.substring(i, i+3);
                if(str.equals(TTT)) {
                    arr[0]++;
                    continue;
                }
                if(str.equals(TTH)) {
                    arr[1]++;
                    continue;
                }
                if(str.equals(THT)) {
                    arr[2]++;
                    continue;
                }
                if(str.equals(THH)) {
                    arr[3]++;
                    continue;
                }
                if(str.equals(HTT)) {
                    arr[4]++;
                    continue;
                }
                if(str.equals(HTH)) {
                    arr[5]++;
                    continue;
                }
                if(str.equals(HHT)) {
                    arr[6]++;
                    continue;
                }
                if(str.equals(HHH)) {
                    arr[7]++;
                    continue;
                }


            }

            for(int x : arr) {
                sb.append(x + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}