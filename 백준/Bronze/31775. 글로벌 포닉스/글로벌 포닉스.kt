import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val visited = BooleanArray(3)
    repeat(3) {
        when(readLine()!![0]) {
            'k' -> visited[0] = true
            'l' -> visited[1] = true
            'p' -> visited[2] = true
        }
    }

    print(if(visited.contains(false)) "PONIX" else "GLOBAL")
}