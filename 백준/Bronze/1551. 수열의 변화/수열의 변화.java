import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static String print(ArrayList<Integer> al) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < al.size(); i++) {
            if(i == al.size() - 1) {
                sb.append(al.get(i));
                break;
            }

            sb.append(al.get(i)+",");
        }



        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), ",");

        while(st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        while(k-->0) {
            al2 = new ArrayList<>();
            for(int i = 1; i < al.size(); i++) {
                al2.add(al.get(i) - al.get(i-1));
            }

            al = new ArrayList<>(al2);
            

            al2.clear();

        }

        bw.write(print(al));
        bw.flush();
        bw.close();
        br.close();

    }
}