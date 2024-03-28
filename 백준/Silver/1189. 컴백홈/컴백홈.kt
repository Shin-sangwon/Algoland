import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arr: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dx = intArrayOf(0, 1, 0, -1)
val dy = intArrayOf(1, 0, -1, 0)
var n = 0
var m = 0
var target = 0
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (r, c, k) = readLine().split(" ").map { it.toInt() }
    target = k
    n = r
    m = c
    arr = Array (r){ CharArray (c) }
    visited = Array(r) {BooleanArray (c)}
    visited[n - 1][0] = true
    for(i in 0 until r) {
        arr[i] = readLine().toCharArray()
    }

    backTracking(n - 1, 0, 1)
    print(answer)
}

fun backTracking(x: Int, y: Int, k: Int) {

    if(x == 0 && y == m - 1) {
        if(k == target) answer++
        return
    }

    for(i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

        if(visited[nx][ny]) continue

        if(arr[nx][ny] == 'T') continue

        visited[nx][ny] = true
        backTracking(nx, ny, k + 1)
        visited[nx][ny] = false
    }

}