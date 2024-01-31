import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.Stack

lateinit var arr: Array<CharArray>
val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

data class Node(val x: Int, val y: Int, val data: Char)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    arr = Array (12) {CharArray(6)}
    for(i in arr.indices) {
        arr[i] = readLine().toCharArray()
    }
    var ans = 0
    while(bfs()) {
        ans++
    }

    print(ans)
}

// 뿌요 내리기
fun down() {

    val newArr = Array (12) {CharArray (6) {'.'} }

    for(i in 0..5) {
        val stack: Stack<Char> = Stack()
        for(j in 0..11) {
            if(arr[j][i] != '.') {
                stack.push(arr[j][i])
            }
        }

        var idx = 11
        while(stack.isNotEmpty()) {
            newArr[idx--][i] = stack.pop()
        }
    }

    arr = newArr
}

// 탐색해서 지우기
fun bfs() : Boolean {

    var flag = false
    val visited = Array (12) {BooleanArray (6)}

    for(i in arr.indices) {
        for(j in arr[i].indices) {
            if(arr[i][j] == '.' || visited[i][j]) continue
            val deleteList: ArrayList<Node> = ArrayList()
            val queue: Queue<Node> = LinkedList()

            deleteList.add(Node(i, j, arr[i][j]))
            queue.add(Node(i, j, arr[i][j]))
            visited[i][j] = true

            while(queue.isNotEmpty()) {
                val node = queue.poll()

                for(k in 0 until 4) {
                    val nx = node.x + dx[k]
                    val ny = node.y + dy[k]

                    if(nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue
                    if(visited[nx][ny]) continue
                    if(arr[nx][ny] != node.data) continue

                    queue.add(Node(nx, ny, node.data))
                    visited[nx][ny] = true
                    deleteList.add(Node(nx, ny, node.data))
                }
            }

            if(deleteList.size >= 4) {
                flag = true
                deleteList.forEach { arr[it.x][it.y] = '.'}
                down()
            }
        }
    }

    return flag
}