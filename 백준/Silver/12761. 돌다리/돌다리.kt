import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

data class Node(val pos: Int, val count: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (a, b, n, m) = readLine().split(" ").map{it.toInt()}

    val queue: Queue<Node> = LinkedList()
    val visited = BooleanArray(100001)
    queue.add(Node(n, 0))

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node.pos == m) {
            print(node.count)
            break
        }
        val newCount = node.count + 1

        val addToQueue: (Int) -> Unit = { newPos ->
            if (newPos in 0..100000 && !visited[newPos]) {
                queue.add(Node(newPos, newCount))
                visited[newPos] = true
            }
        }

        addToQueue(node.pos + 1)
        addToQueue(node.pos + a)
        addToQueue(node.pos + b)
        addToQueue(node.pos - 1)
        addToQueue(node.pos - a)
        addToQueue(node.pos - b)
        addToQueue(node.pos * a)
        addToQueue(node.pos * b)
    }
}