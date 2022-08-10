import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

class Solution {
    
     static class Node{
        int weight;
        int time;

        public Node(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int ans = 0;
        int target = 0;
        Queue<Integer> startQueue = new LinkedList<>();
        Queue<Node> arriveQueue = new LinkedList<>();

        for(int i = 0; i < truck_weights.length; i++) {
            startQueue.add(truck_weights[i]);
        }
        int totalWeight = 0;

        while(true){
            ans += 1;
            //모두 건넜을 때
            if(target == truck_weights.length) {
                break;
            }
            //다리에 차가 올라갈 수 있을 때 올리기
            if(!startQueue.isEmpty() && startQueue.peek() + totalWeight <= weight){
                totalWeight += startQueue.peek();
                arriveQueue.add(new Node(startQueue.poll(), bridge_length));
            }

            Iterator<Node> ite = arriveQueue.iterator();

            //이미 있는 차 시간 감소
            while(ite.hasNext()) {
                Node node = ite.next();
                node.time -= 1;

                if(node.time == 0) {
                    totalWeight -= node.weight;
                    ite.remove();
                    target++;
                }
            }

        }

        return ans;
    }
}