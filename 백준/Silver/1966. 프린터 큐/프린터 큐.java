import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class print{
        int index;
        int priority;

        print(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

    }

    static int searchMax(Queue q) {
        Queue<print> tmpQ = new LinkedList<>(q);
        int max = Integer.MIN_VALUE;

        while (!tmpQ.isEmpty()) {
            print Print = tmpQ.poll();
            if (Print.priority > max) {
                max = Print.priority;
            }
        }

        return max;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();



        int totalcase = Integer.parseInt(br.readLine());

        while(totalcase-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            Queue<print> q = new LinkedList<>();

            // 큐에 삽입할 원소 받기
            st = new StringTokenizer(br.readLine());
            //큐에 삽입
            for(int i = 0; i < n; i++){
                q.add(new print(i, Integer.parseInt(st.nextToken())));
            }
            int order = 1;
            Loop1:
            while(true){
                int max = searchMax(q);
                Loop2:
                while(true){
                    //원하는 문서라면, 반복문 종료
                    if(target == q.peek().index && max == q.peek().priority){
                        break Loop1;
                    }
                    //문서가 뽑혔으면, 뽑아주고 횟수추가
                    if(q.peek().priority == max){
                        q.poll();
                        order++;
                        break Loop2;
                    }else{
                        q.add(q.poll());
                    }

                }

            }

            sb.append(order+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
