import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.max

val dx = intArrayOf(0, 1, 0, -1);
val dy = intArrayOf(1, 0, -1, 0);
lateinit var map: Array<IntArray>;
lateinit var visited: Array<BooleanArray>;
var n = 0;
var m = 0;
var answer = 0;
var totalLength = 0;

data class Node(val x: Int, val y: Int, val length: Int);

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    var st = StringTokenizer(br.readLine());

    n = st.nextToken().toInt();
    m = st.nextToken().toInt();

    map = Array(n) { IntArray(m) };

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine());
        for(j in 0 until m) {
            map[i][j] = st.nextToken().toInt();
        }
    }

    for (i in 0 until n / 2 + 1) {
        for (j in 0 until m) {

            if (map[i][j] == 0) continue;

            search(i, j);
        }
    }

    print(answer);

}

fun search(startX: Int, startY: Int) {
    val start = map[startX][startY];
    visited = Array(n) { BooleanArray(m) };
    visited[startX][startY] = true;

    val startNode = Node(startX, startY, 0);

    val queue: Queue<Node> = LinkedList();

    queue.add(startNode);

    while (!queue.isEmpty()) {
        val node = queue.poll();

        when {
            node.length > totalLength -> {
                answer = start + map[node.x][node.y]
                totalLength = node.length;
            };
            node.length == totalLength -> answer = max(answer, start + map[node.x][node.y]);
        }

        for (k in 0 until 4) {
            val nx = node.x + dx[k];
            val ny = node.y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (visited[nx][ny]) continue;

            if (map[nx][ny] == 0) continue;

            visited[nx][ny] = true;
            queue.add(Node(nx, ny, node.length + 1));
        }
    }

}