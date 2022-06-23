import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        char arr[];

        while(cnt-- != 0){
            int hp = Integer.parseInt(br.readLine());
            arr = br.readLine().toCharArray();
            for(int i = 0; i < arr.length; i++){
                if(hp <= 0){
                    hp = 0;
                    break;
                }
                if(arr[i] == 'c') hp++;
                else hp--;
            }
            if(hp <= 0) al.add(0);
            else al.add(hp);
        }
        int n = 1;
        for(int x : al) System.out.printf("Data Set %d:\n%d\n\n", n++, x);

    }
}
