import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cute = 0;
        int Ncute = 0;

        while(n-->0) {
            if(Integer.parseInt(br.readLine()) == 0) {
                Ncute++;
                continue;
            }

            cute++;
        }

        bw.write(cute > Ncute? "Junhee is cute!" : "Junhee is not cute!");
        bw.flush();
        bw.close();
        br.close();




   }
}