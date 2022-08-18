import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x : scoville) {
            pq.add(x);
        }

        while(true) {
            //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없을 때
            if(pq.size() == 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
            //모든 음식의 스코빌 지수가 k 이상이 됐을 때
            if(pq.peek() >= K) {
                break;
            }

            //스코빌 지수가 낮은 음식 섞기
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        
        return answer;
    }
}