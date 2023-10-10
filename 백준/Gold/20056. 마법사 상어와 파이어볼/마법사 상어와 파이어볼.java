import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static class Fireball {

        int r; // 행
        int c; // 열
        int m; // 질량
        int s; // 속력
        int d; // 방향

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public Fireball(int[] arr) {
            this.r = arr[0];
            this.c = arr[1];
            this.m = arr[2];
            this.s = arr[3];
            this.d = arr[4];
        }
    }
    static int n, m, k;
    static ArrayList<Fireball>[][] map;
    static ArrayList<Fireball> ballList;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException{

        init();

        for(int i = 0; i < k; i++) {
            move();
            divide();
        }

        System.out.print(getAnswer());

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ballList = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int[] ballInfo = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Fireball fireball = new Fireball(ballInfo);
            ballList.add(fireball);
        }
    }

    private static void move() {
        map = new ArrayList[n+1][n+1];

        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < n+1; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (Fireball fireball : ballList) {
            int r = fireball.r;
            int c = fireball.c;
            int d = fireball.d;
            int s = fireball.s;

            int nx = r + (dx[d] * (s % n));
            int ny = c + (dy[d] * (s % n));

            if (nx < 1) nx += n;
            if (ny < 1) ny += n;
            if (nx > n) nx -= n;
            if (ny > n) ny -= n;

            fireball.r = nx;
            fireball.c = ny;

            map[nx][ny].add(fireball);
        }
    }

    private static void divide() {

        ArrayList<Fireball> tmpBallList = new ArrayList<>();

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {

                if(map[i][j].size() > 1) {

                    int num = map[i][j].size();
                    int[] direction = findDirection(map[i][j]);

                    int totalM = 0;
                    int totalS = 0;

                    for(int k = 0; k < num; k++) {
                        totalM += map[i][j].get(k).m;
                        totalS += map[i][j].get(k).s;
                    }

                    int newM = totalM / 5;
                    if(newM == 0) continue;
                    int newS = totalS / num;

                    for(int l = 0; l < 4; l++) {
                        tmpBallList.add(new Fireball(i, j, newM, newS, direction[l]));
                    }


                }else if(map[i][j].size() == 1){
                    tmpBallList.add(map[i][j].get(0));
                }
            }
        }

        ballList = tmpBallList;

    }


    private static int[] findDirection(ArrayList<Fireball> mapList) {

        int[] even ={0, 2, 4, 6};
        int[] odd = {1, 3, 5, 7};

        if(isEven(mapList) || isOdd(mapList)) return even;

        return odd;

    }

    private static boolean isOdd(ArrayList<Fireball> mapList) {

        for (Fireball fireball : mapList) {
            if (fireball.d % 2 == 0) return false;
        }
        return true;
    }

    private static boolean isEven(ArrayList<Fireball> mapList) {
        for (Fireball fireball : mapList) {
            if (fireball.d % 2 == 1) return false;
        }
        return true;
    }

    private static int getAnswer() {

        int answer = 0;
        for(Fireball fireball : ballList) {
            answer += fireball.m;
        }

        return answer;
    }

}
