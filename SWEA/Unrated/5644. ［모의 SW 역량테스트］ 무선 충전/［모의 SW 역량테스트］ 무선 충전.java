import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/*
 * 충전 되는 범위의 map을 따로 만들자.
 * 그런데, 겹치는 부분이 있다면? -> 가장 큰거부터 배치 vs 가장 큰걸 나눠썼을 때 를 비교하기
 * 겹치는 부분은 어떻게 표시? -> 최대 2개만 있으면 되는데 .... . . . . . . . .
 *
 */

public class Solution{

    //이동하지 않음, 상, 우, 하, 좌
    static final int dx[] = {0, -1, 0, 1, 0};
    static final int dy[] = {0, 0, 1, 0, -1};
    static int m, a, chargingA, chargingB ,moveA[], moveB[];
    static boolean[][] visited;
    static List<Node>[][] map;


    static class Node implements Comparable<Node>{
        int x;
        int y;
        int c;
        int p;
        int time;
        int batteryName;

        public Node(int x, int y, int c, int p, int time,int batteryName) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
            this.time = time;
            this.batteryName = batteryName;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return o.p - this.p == 0? o.batteryName - this.batteryName : o.p - this.p;
        }


    }

    private static void mapping(Node[] batteries) {

        //할당해주기
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < batteries.length; i++) {

            visited = new boolean[10][10];
            Queue<Node> queue = new LinkedList<>();
            queue.add(batteries[i]);
            visited[batteries[i].x][batteries[i].y] = true;
            map[batteries[i].x][batteries[i].y].add(batteries[i]);

            while(!queue.isEmpty()) {

                Node node = queue.poll();

                for(int k = 1; k < 5; k++) {
                    int nx = node.x + dx[k];
                    int ny = node.y + dy[k];

                    if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10) continue;

                    if(visited[nx][ny]) continue;

                    if(node.time == node.c) continue;

                    visited[nx][ny] = true;
                    map[nx][ny].add(node);
                    queue.add(new Node(nx, ny, node.c, node.p, node.time + 1 , node.batteryName));

                }
            }

        }

    }

    private static void moving() {

        Node aNode = new Node(0, 0);
        Node bNode = new Node(9, 9);
        calc(aNode, bNode);
        //System.out.println("0번쨰 -> A : " + chargingA + " B : " + chargingB);
        for(int i = 0; i < m; i++) {

            //한번 움직이기
            aNode.x += dx[moveA[i]];
            aNode.y += dy[moveA[i]];
            bNode.x += dx[moveB[i]];
            bNode.y += dy[moveB[i]];
            //움직이고 계산하기
            calc(aNode, bNode);
            //System.out.println(i + 1 + "번째-> A : " + chargingA + " B : " + chargingB);
        }
    }

    private static void calc(Node aNode, Node bNode) {
        //한 지역에 2개 이상은 못온다
        //충전지역이 아니면 넘기기
        if(map[aNode.x][aNode.y].size() == 0 && map[bNode.x][bNode.y].size() == 0) return;
        //아니라면, 하나씩 계산해보기
        //먼저, 하나의 배터리 구역인데
        if(map[aNode.x][aNode.y].size() == 1 && map[bNode.x][bNode.y].size() == 1) {

            List<Node> al1 = map[aNode.x][aNode.y];
            List<Node> al2 = map[bNode.x][bNode.y];
            //두개의 배터리가 같다면
            if(al1.get(0).batteryName == al2.get(0).batteryName) {
                chargingA += (al1.get(0).p)/2;
                chargingB += (al2.get(0).p)/2;
                return;
            }

            //두개의 배터리가 다르므로
            chargingA += (al1.get(0).p);
            chargingB += (al2.get(0).p);

            return;
        }

        //둘 다 두개의 배터리 구역인데
        if(map[aNode.x][aNode.y].size() >= 2 && map[bNode.x][bNode.y].size() >= 2) {
            List<Node> al1 = map[aNode.x][aNode.y];
            List<Node> al2 = map[bNode.x][bNode.y];
            Collections.sort(al1);
            Collections.sort(al2);
            //제일 큰 배터리가 겹친다면
            if(al1.get(0).batteryName == al2.get(0).batteryName) {

                //제일 큰 배터리가 겹치고, b의 두번 째 배터리가 더 크다면
                if(al2.get(1).p > al1.get(1).p) {
                    chargingA += (al1.get(0).p);
                    chargingB += (al2.get(1).p);
                    return;
                }

                //그 반대라면
                chargingA += (al1.get(1).p);
                chargingB += (al2.get(0).p);
                return;
            }
            //다르다면
            chargingA += (al1.get(0).p);
            chargingB += (al2.get(0).p);

            return;
        }

        // 1 - 2 or 2 - 1

        if(map[aNode.x][aNode.y].size() == 1 && map[bNode.x][bNode.y].size() >= 2) {

            List<Node> al1 = map[aNode.x][aNode.y];
            List<Node> al2 = map[bNode.x][bNode.y];
            Collections.sort(al2);
            //제일 큰 배터리가 겹친다면
            if(al1.get(0).batteryName == al2.get(0).batteryName) {
                chargingA += (al1.get(0).p);
                chargingB += (al2.get(1).p);
                return;
            }
            //다르다면
            chargingA += (al1.get(0).p);
            chargingB += (al2.get(0).p);
            return;
        }

        if(map[aNode.x][aNode.y].size() >= 2 && map[bNode.x][bNode.y].size() == 1) {
            List<Node> al1 = map[aNode.x][aNode.y];
            List<Node> al2 = map[bNode.x][bNode.y];
            Collections.sort(al1);
            //제일 큰 배터리가 겹친다면
            if(al1.get(0).batteryName == al2.get(0).batteryName) {
                chargingA += (al1.get(1).p);
                chargingB += (al2.get(0).p);
                return;
            }
            //다르다면
            chargingA += (al1.get(0).p);
            chargingB += (al2.get(0).p);
            return;
        }

        //나머지는 다른 경우만 남았으므로 처리해주면 됨

        if(map[aNode.x][aNode.y].size() != 0) {
            List<Node> al1 = map[aNode.x][aNode.y];
            Collections.sort(al1);

            chargingA += (al1.get(0).p);
        }

        if(map[bNode.x][bNode.y].size() != 0) {
            List<Node> al1 = map[bNode.x][bNode.y];
            Collections.sort(al1);

            chargingB += (al1.get(0).p);
        }


    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int printIndex = 1;

        while(tc-->0) {

            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken()); // 총 이동시간
            a = Integer.parseInt(st.nextToken()); // 배터리 충전기 수

            moveA = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            moveB = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Node[] batteries = new Node[a];

            for(int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken()) - 1; //input에서는 1부터 시작이므로
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                batteries[i] = new Node(x, y, c, p, 0, i);
            }

            map = new ArrayList[10][10];
            chargingA = 0;
            chargingB = 0;

            mapping(batteries);

            moving();

            sb.append(String.format("#%d %d\n", printIndex++, chargingA + chargingB));
        }

        System.out.println(sb);

    }

}