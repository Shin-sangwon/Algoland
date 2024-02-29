import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val(n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1)
    val graph: Array<ArrayList<Int>> = Array (n + 1) { ArrayList() }

    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }.toIntArray()
        for(i in 1 until input.size) {
            val start = input[i]
            for(j in i + 1 until input.size) {
                val end = input[j]
                graph[start].add(end)
                arr[end]++
            }
        }
    }

    val sb = StringBuilder()
    val queue: Queue<Int> = LinkedList()

    for(i in 1 until n + 1) {
        if(arr[i] == 0) {
            queue.add(i)
            sb.append("$i\n")
        }
    }

    for(i in 1 until n + 1) {
        if(queue.isEmpty()){
            print(0)
            return@with
        }

        val x = queue.poll()
        for(number in graph[x].indices) {
            val y = graph[x][number]
            arr[y]--

            if(arr[y] == 0) {
                queue.add(y)
                sb.append("$y\n")
            }
        }
    }

    print(sb)

}