import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {

    static int calc(char arr[], String str) {

        int answer = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != arr[i]) {
                break;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char arr[] = new char[26];
        int index = 97;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (char) index++;
        }

        int n = Integer.parseInt(br.readLine());
		int idx = 1;
        
        while(n-->0) {

            String tmp = br.readLine();
			sb.append("#" + idx++ + " ");
            sb.append(calc(arr, tmp) + "\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}