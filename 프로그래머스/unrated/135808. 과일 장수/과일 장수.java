import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        int boxNum = score.length / m;

        Arrays.sort(score);
        
        int index = 0;
        int tmp = 0;
        for(int i = score.length - 1; i >= 0; i--) {
            if(index == boxNum) {
                break;
            }

            tmp++;

            if(tmp == m) {
                tmp = 0;
                answer += score[i] * m;
            }

        }
        return answer;
    }
}