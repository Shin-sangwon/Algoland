import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < 5; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if(set.contains(tmp)) {
                set.remove(tmp);
            }else {
                set.add(tmp);
            }
        }

        for(int x : set) {
            System.out.println(x);
        }


    }

}
