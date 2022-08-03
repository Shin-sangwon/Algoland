import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int arr[];
    static ArrayList<Long> al;
    static void combi(int[] arr, boolean[] visited, int start, int n, int r){
        //조합이 완성되었다면
        if(r == 0){
            multiPly(arr, visited, n);
            return;
        }

        for(int i = start; i < n; i++){
            visited[i] = true;
            combi(arr, visited, i  + 1, n , r - 1);
            visited[i] = false;
        }

    }
    static long solution(long m, int arr[]){

        long ans = 0L;
        // i는 조합 nCr 중 r
        for(int i = 1; i <= arr.length; i++){
            //r마다 조합을 계속해서 뽑아야 하므로, visited와 al을 계속해서 새로 할당
            boolean visited[] = new boolean[arr.length];
            al = new ArrayList<>();
            //조합 뽑아내서 al에 넣기
            combi(arr, visited, 0, arr.length, i);
            // + - + - + - + - + - + - 의 순서로 결과값을 더해야하므로
            // 짝수번째라면 빼줘야함. (교집합 빼기)
            if( i % 2 == 0 ) {
                for(int k = 0; k < al.size(); k++){
                    ans -= (m / al.get(k));
                }
            }else{
                //홀수번째라면 더해줘야함
                for(int k = 0; k < al.size(); k++){
                    ans += (m / al.get(k));
                }
            }
        }

        return ans;


    }

    static void multiPly(int[] arr, boolean[] visited, int n) {
        //교집합을 구해야 하므로 곱해야 하니까 초기 값 1로 설정
        long tmp = 1;
        for (int i = 0; i < n; i++) {
            //조합으로 뽑힌 수라면, 곱해주기
            if (visited[i]) {
                tmp *= arr[i];
            }
        }
        //static al에 반환
        al.add(tmp);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(m, arr)+"");
        bw.flush();
        bw.close();
        br.close();


    }
}
