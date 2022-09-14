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

        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);

        for(int i = 1; i < 30; i++) {
            al.add(al.get(i-1) * 2);
        }

        al.add(1);

        bw.write(al.contains(Integer.parseInt(br.readLine()))? "1": "0");
        bw.flush();
        bw.close();
        br.close();




        






    }
}