package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer


data class Node(val x: Int, val y: Int);


val dx: IntArray = intArrayOf(1, 0, -1, 0)
val dy: IntArray = intArrayOf(0, 1, 0, -1)

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>

var n = 0;
var m = 0;
var answer = 0;

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val tc = br.readLine().toInt();

    repeat(tc) {

        val st = StringTokenizer(br.readLine());
        n = st.nextToken().toInt();
        m = st.nextToken().toInt();

        map = Array(n) { CharArray(m) };
        visited = Array(n) {BooleanArray(m)};
        answer = 0;

        var idx = 0;
        repeat(n) {
            map[idx++] = br.readLine().toCharArray();
        }

        for(i in 0 until n) {
            for(j in 0 until m) {

                if(map[i][j] == '.') continue;

                if(visited[i][j]) continue;

                bfs(i, j);
            }
        }

        sb.append("$answer\n");
    }

    print(sb);

}

fun bfs(x: Int, y: Int) {

    val queue:Queue<Node> = LinkedList();

    queue.add(Node(x, y));

    while(queue.isNotEmpty()) {
        val node = queue.poll();

        for(k in 0..3) {
            val nx = node.x + dx[k];
            val ny = node.y + dy[k];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny] == '.') continue;

            visited[nx][ny] = true;
            queue.add(Node(nx, ny));
        }
    }

    answer++;
}