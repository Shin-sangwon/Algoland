import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val dx = intArrayOf(-1, 1, -2, 2, -2, 2, -1 ,1)
    val dy = intArrayOf(-2, -2, -1, -1, 1, 1, 2, 2)

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val knight: Triple<Int, Int, Int> = readLine().split(" ").map { it.toInt() }.let { (a, b) -> Triple(a - 1, b - 1, 0) }

    val arr = Array(n) {IntArray(n)}
    val visited = Array(n) {BooleanArray(n)}

    val answer = IntArray(m)

    for(i in 0 until m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        arr[x - 1][y - 1] = i + 1
    }

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    queue.add(knight)
    while(queue.isNotEmpty()) {
        val now = queue.poll()
        if(answer.none { it == 0 } ) break

        for(k in dx.indices) {
            val nx = dx[k] + now.first
            val ny = dy[k] + now.second

            if(nx !in 0 until n || ny !in 0 until n) continue

            if(visited[nx][ny]) continue

            visited[nx][ny] = true

            if(arr[nx][ny] != 0 && answer[arr[nx][ny] - 1] == 0) {
                answer[arr[nx][ny] - 1] = now.third + 1
            }

            queue.add(Triple(nx, ny, now.third + 1))
        }
    }
    
    print(answer.joinToString(separator = " "))


}
