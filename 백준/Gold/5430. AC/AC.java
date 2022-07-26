import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static String print(int arr[], boolean flag){

        StringBuilder tmpSb = new StringBuilder();

        tmpSb.append("[");

        /*
        case 1 정방향일때
        case 1-1 정방향이면서, 마지막 항목이 0일 때
        case 1-2 정방향이면서, 마지막 항목이 0이 아닐 때
        case 2 역방향일때
        case 2-1 역방향이면서, 마지막 항목이 0일 때
        case 2-2 역방향이면서, 마지막 항목이 0이 아닐 때
         */
        if(flag){
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] < 0) continue;

                tmpSb.append(arr[i] + ",");
            }

            if(arr[arr.length-1] > 0){
                tmpSb.append(arr[arr.length-1]).append("]\n");
            }else{
                tmpSb.replace(tmpSb.length()-1, tmpSb.length(), "]\n");
            }

        }else{
            for(int i = arr.length-1; i >= 1; i--){
                if(arr[i] < 0) continue;

                tmpSb.append(arr[i] + ",");
            }

            if(arr[0] > 0){
                tmpSb.append(arr[0]).append("]\n");
            }else{
                tmpSb.replace(tmpSb.length()-1, tmpSb.length(), "]\n");
            }
        }



        return tmpSb.toString();

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int totalCase = Integer.parseInt(br.readLine());

        Loop1:
        while(totalCase-->0){
            String delim = br.readLine();
            int inputCase = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");

            int arr[] = new int[inputCase];

            //배열 셋팅
            for(int i = 0; i < inputCase; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            //R과 D를 세면서 계산 true일 때 정방향
            boolean rCount = true;
            //1일때 정방향연산, 2일때 역방향연산
            int dCount1 = 0;
            int dCount2 = 0;
            //delim만큼 반복하면서
            //배열이 비어있을 때 D를하면 error
            for(int i = 0; i < delim.length(); i++){
                //R이 들어오면 반대연산
                if(delim.charAt(i) == 'R'){
                    if(rCount){
                        rCount = false;
                        continue;
                    }

                    rCount = true;
                }

                if(delim.charAt(i) == 'D'){
                    //d의 갯수가 input을 넘어가면 에러
                    if(dCount1 + dCount2 > inputCase-1){
                        sb.append("error\n");
                        continue Loop1;
                    }
                    //정방향일때
                    if(rCount){
                        //음수로전환
                        arr[dCount1] = -1;
                        dCount1++;
                        continue;
                    }

                    //역방향 케이스밖에 안남음
                    arr[inputCase-1-dCount2] = -1;
                    dCount2++;
                }
            }

            if(arr.length == 0 || dCount1 + dCount2 == inputCase){
                sb.append("[]\n");
                continue;
            }

            sb.append(print(arr, rCount));


        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
