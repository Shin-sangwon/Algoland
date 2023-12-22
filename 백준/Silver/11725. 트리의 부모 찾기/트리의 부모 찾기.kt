import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var tree: Array<MutableList<Int>>
lateinit var visited: BooleanArray
lateinit var arr: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    tree = Array (n + 1) { mutableListOf() }
    arr = IntArray(n + 1)
    visited = BooleanArray(n + 1)

    repeat(n - 1) {
        val(f, s) = readLine().split(" ").map{it.toInt()}
        tree[f].add(s)
        tree[s].add(f)
    }

    dfs(1)

    for(i in 2..n) {
        println(arr[i])
    }

}

fun dfs(start: Int) {

    visited[start] = true
    for(i in tree[start]) {
        if(!visited[i]) {
            arr[i] = start
            dfs(i)
        }
    }
}

