import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class Truck {

        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //트럭의 수, 다리의 길이, 다리의 최대하중
        int n,w,l;
        int answer = 0;
        int truckAmount = 0;
        int totalWeight = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Truck> waitingTruck = new LinkedList<>();
        Queue<Truck> arrivedTruck = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            waitingTruck.add(new Truck(weight, w));
        }

        //단위 시간 마다 일어나는 일
        while(true) {

            answer++;

            //탈출 조건
            if(waitingTruck.isEmpty() && arrivedTruck.isEmpty()) break;

            //올릴 수 있으면 올리기

            if(!waitingTruck.isEmpty() && truckAmount < w && totalWeight + waitingTruck.peek().weight <= l) {
                totalWeight += waitingTruck.peek().weight;
                truckAmount += 1;
                arrivedTruck.add(waitingTruck.poll());

            }

            //진행중인 차의 시간 뺴주기

            Iterator<Truck> ite = arrivedTruck.iterator();

            while(ite.hasNext()) {
                Truck truck = ite.next();
                truck.time -= 1;

                //도착했으면 내리기

                if(truck.time == 0) {
                    totalWeight -= arrivedTruck.peek().weight;
                    truckAmount -= 1;
                    ite.remove();
                }
            }


        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }

}