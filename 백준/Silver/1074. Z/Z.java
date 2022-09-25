import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;


public class Main {

    static int recursive(int n, int r, int c, int counting) {

        // base condition
        if(n == 0) return counting;
        // 사분면 계산을 위해 절반 값 정의
        int index = (int)Math.pow(2, n-1);
        // 사분면 나타 낼 변수
        int quadrant = Integer.MIN_VALUE;
        //1사분면(row가 index보다 작고, column이 index보다 작으므로)
        if(r < index && c < index) {
            quadrant = 1;
        }
        //2사분면(row가 index보다 작고, column이 index보다 크므로)
        if(r < index && c >= index) {
            quadrant = 2;
            //column이 index보다 크므로 값을 빼줘야 다음 계산이 가능
            c -= index;
        }
        //3사분면(row가 index보다 크고, column이 index보다 작으므로)
        if(r >= index && c < index) {
            quadrant = 3;
            //row가 index보다 크므로 값을 빼줘야 다음 계산이 가능
            r -= index;
        }
        //4사분면(row가 index보다 크고, column이 index보다 크므로)
        if(r >= index && c >= index) {
            quadrant = 4;
            //row와 column index보다 크므로 값을 빼줘야 다음 계산이 가능
            r -= index;
            c -= index;
        }
        //사분면에 따라 시작 값이 다르므로 계산
        counting += (quadrant - 1) * (int)Math.pow(index, 2);

        //분할정복
        return recursive(n-1, r, c, counting);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        int answer = recursive(arr[0], arr[1], arr[2], 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }
}