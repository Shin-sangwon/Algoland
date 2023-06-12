import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Robot(var x: Int, var y: Int, var d: Int)

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)
var n = 0
var m = 0
var answer = 0
lateinit var map: Array<IntArray>
lateinit var visited: Array<BooleanArray>
lateinit var robot: Robot

fun search(): Boolean {
    for (k in 0 until 4) {
        val nx = robot.x + dx[k]
        val ny = robot.y + dy[k]

        if (!isPossible(nx, ny)) continue

        if (map[nx][ny] == 0) return true
    }
    return false
}

fun isPossible(nx: Int, ny: Int): Boolean {
    return (nx >= 0 && ny >= 0 && nx < n && ny < m) && (map[nx][ny] != 1)
}

fun isCleanable(nx: Int, ny: Int): Boolean {
    return (nx >= 0 && ny >= 0 && nx < n && ny < m) && (map[nx][ny] == 0)
}

fun rotate(): Boolean {
    robot.d -= 1
    if (robot.d == -1) robot.d = 3

    val nx = robot.x + dx[robot.d]
    val ny = robot.y + dy[robot.d]

    if (isCleanable(nx, ny)) {
        robot.x = nx
        robot.y = ny
        return false
    }
    return true
}

fun clean() {
    answer = 0
    while (true) {
        if (map[robot.x][robot.y] == 0) {
            answer += 1
            map[robot.x][robot.y] = -1
        }

        if (!search()) {
            val nx = robot.x + dx[(robot.d + 2) % 4]
            val ny = robot.y + dy[(robot.d + 2) % 4]
            if (isPossible(nx, ny)) {
                robot.x = nx
                robot.y = ny
                continue
            }
            return
        }

        if (search()) {
            while (rotate());
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    map = Array(n) { IntArray(m) }
    visited = Array(n) { BooleanArray(m) }
    val st2 = StringTokenizer(br.readLine())

    robot = Robot(st2.nextToken().toInt(), st2.nextToken().toInt(), st2.nextToken().toInt())

    for (i in 0 until n) {
        val st3 = StringTokenizer(br.readLine())
        for (j in 0 until m) {
            map[i][j] = st3.nextToken().toInt()
        }
    }

    clean()
    println(answer)
}