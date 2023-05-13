import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int r, c, m, answer, fisherman;
    //static ArrayList<Fish> fishes;
    static Fish[][] fishes;
    static PriorityQueue<Fish> fishQueue;
    static final int[]
        dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};


    static class Fish {

        int r;
        int c;
        int s;
        int d;
        int z;

        public Fish(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        public static Fish of(int r, int c, int s, int d, int z) {
            return new Fish(r, c, s, d, z);
        }

    }

    private static void moveFishes() {

        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {

                if (fishes[i][j] == null) {
                    continue;
                }

                Fish fish = fishes[i][j];
                int tmpSpeed = (fish.d == 1 || fish.d == 2) ? (fish.s % ((r - 1) * 2))
                    : (fish.s % ((c - 1) * 2));
                int fishR = fish.r;
                int fishC = fish.c;
                int fishD = fish.d;

                for (int k = 0; k < tmpSpeed; k++) {
                    int nextR = fishR + dx[fishD - 1];
                    int nextC = fishC + dy[fishD - 1];

                    if (nextR < 1 || nextR > r || nextC < 1 || nextC > c) {
                        // 방향을 반대로 바꿔준다
                        fishD = reverseDirection(fishD);
                        nextR = fishR + dx[fishD - 1];
                        nextC = fishC + dy[fishD - 1];
                    }

                    fishR = nextR;
                    fishC = nextC;
                }

                fish.r = fishR;
                fish.c = fishC;
                fish.d = fishD;

                fishQueue.add(fish);
            }
        }

        mapping();
    }

    private static void mapping() {

        Fish[][] copyMap = new Fish[r+1][c+1];

        while(!fishQueue.isEmpty()) {
            Fish fish = fishQueue.poll();

            if(copyMap[fish.r][fish.c] != null) continue;

            copyMap[fish.r][fish.c] = fish;
        }

        fishes = copyMap;
    }

    private static int reverseDirection(int direction) {
        if (direction == 1) {
            return 2;
        } else if (direction == 2) {
            return 1;
        } else if (direction == 3) {
            return 4;
        } else if (direction == 4) {
            return 3;
        }
        return direction;
    }

//    private static void eating() {
//
//        for (int i = 1; i < r + 1; i++) {
//            for (int j = 1; j < c + 1; j++) {
//
//                if (fishes[i][j].size() > 1) {
//                    Collections.sort(fishes[i][j], (o1, o2) -> o2.z - o1.z);
//                    Fish fish = fishes[i][j].get(0);
//                    fishes[i][j] = new ArrayList<>();
//                    fishes[i][j].add(fish);
//                    continue;
//                }
//            }
//        }
//
//    }

    private static void fishing() {

        for (int i = 1; i < r + 1; i++) {
            if (fishes[i][fisherman] != null) {
                answer += fishes[i][fisherman].z;
                fishes[i][fisherman] = null;
                return;
            }
        }
    }

    private static void move() {

        while (++fisherman <= c) {
            fishing();
            moveFishes();
            //eating();
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //fishes = new ArrayList<>();
        fishes = new Fish[r + 1][c + 1];
        fishQueue = new PriorityQueue<>(((o1, o2) -> o2.z - o1.z));
        answer = 0;
        fisherman = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            fishes[r][c] = Fish.of(r, c, s, d, z);

        }

        move();

        System.out.println(answer);
    }
}