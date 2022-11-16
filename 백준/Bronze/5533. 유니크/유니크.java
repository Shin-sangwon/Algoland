import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.stream.Stream;


public class Main {

    static class Score{
        int first;
        int second;
        int third;

        public Score(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Score> al = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int arr[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            al.add(new Score(arr[0], arr[1], arr[2]));
        }

        for(int i = 0; i < n; i++) {
            int first = al.get(i).first;
            int second = al.get(i).second;
            int third = al.get(i).third;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                int target1 = al.get(j).first;
                int target2 = al.get(j).second;
                int target3 = al.get(j).third;

                if(target1 == first) first = 0;
                if(target2 == second) second = 0;
                if(target3 == third) third = 0;
            }

            sb.append(first+second+third + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}