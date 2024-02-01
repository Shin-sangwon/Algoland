import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static class Basket {

        int[] length;

        public Basket(int len) {
            this.length = new int[len];
            for(int i = 0; i < len; i++) {
                length[i] = i;
            }
        }

        public void moveRight() {

            if(length[length.length - 1] < n) {
                Arrays.setAll(length, i -> length[i] + 1);
            }

        }

        public void moveLeft() {
            if(length[0] > 0) {
                Arrays.setAll(length, i -> length[i] - 1);
            }
        }

        public int getLeft() {
            return length[0];
        }

        public int getRight() {
            return length[length.length - 1];
        }

        public boolean contains(int target) {
            return Arrays.stream(length)
                         .anyMatch(x -> x == target);
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int tc = Integer.parseInt(br.readLine());
        int answer = 0;

        Basket basket = new Basket(m);
        for(int i = 0; i < tc; i++) {
            int target = Integer.parseInt(br.readLine()) - 1;

            while(!basket.contains(target)) {
                answer++;

                if(basket.getLeft() > target) {
                    basket.moveLeft();
                }else {
                    basket.moveRight();
                }
            }
        }

        System.out.print(answer);
    }
}
