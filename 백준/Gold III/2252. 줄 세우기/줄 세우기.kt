import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1)
    val graph: Array<ArrayList<Int>> = Array (n + 1) { ArrayList() }

    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        graph[start].add(end)
        arr[end]++
    }

    val sb = StringBuilder()
    val queue: Queue<Int> = LinkedList()

    for(i in 1 until arr.size) {
        if(arr[i] == 0) {
            queue.add(i)
            sb.append("$i ")
        }
    }

    while(queue.isNotEmpty()) {
        val now = queue.poll()
        for(i in graph[now].indices) {
            val delete = graph[now][i]
            arr[delete]--

            if(arr[delete] == 0) {
                queue.add(delete)
                sb.append("$delete ")
            }
        }

    }

    print(sb.trim())
}