import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] dx = {0, 0, -1, -1, -1, 1, 1, 1};
    static final int[] dy = {-1, 1, -1, 0, 1, -1, 0, 1};
    static int n, m, target, year, food[][], map[][];
    static PriorityQueue<Tree> trees;
    static PriorityQueue<Tree> tmpTrees;
    static Queue<Tree> deadTrees;
    static Queue<Tree> newTrees;
    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;
        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }


        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    private static void spring() {
        
            while(!trees.isEmpty()) {
                Tree tree = trees.poll();

                if (map[tree.r][tree.c] - tree.age < 0) {
                    deadTrees.add(tree);
                    continue;
                }

                map[tree.r][tree.c] -= tree.age;
                int newAge = tree.age + 1;
                tmpTrees.add(new Tree(tree.r, tree.c, newAge));

                if (newAge % 5 == 0) {
                    newTrees.add(new Tree(tree.r, tree.c, newAge));
                }
            }

        trees.addAll(tmpTrees);
        tmpTrees = new PriorityQueue<>();
    }

    private static void summer() {

        while(!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();

            map[tree.r][tree.c] += tree.age / 2;
        }
    }

    private static void autumn() {

        while(!newTrees.isEmpty()) {

            Tree tree = newTrees.poll();

            for(int k = 0; k < 8; k++) {
                int nx = tree.r + dx[k];
                int ny = tree.c + dy[k];

                if(nx < 1 || ny < 1 || nx > n || ny > n) continue;

                trees.add(new Tree(nx, ny, 1));
            }
        }
    }

    private static void winter() {

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                map[i][j] += food[i][j];
            }
        }
    }

    private static void start() {

        while(true) {

            if(year == target) return;
            spring();
            summer();
            autumn();
            winter();
            year++;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        food = new int[n+1][n+1];
        map = new int[n+1][n+1];
        trees = new PriorityQueue<>();
        tmpTrees = new PriorityQueue<>();
        deadTrees = new LinkedList<>();
        newTrees = new LinkedList<>();

        year = 0;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = 5;
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c , age));
        }


        start();

        System.out.println(trees.size());

    }
}
