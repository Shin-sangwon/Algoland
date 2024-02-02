import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

lateinit var stack: Stack<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val tc = readLine().toInt()
    val sb = StringBuilder()
    stack = Stack()
    repeat(tc) {

        val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

        if(arr.size == 2) {
            stack.push(arr[1])
        }else {
            when {
                arr[0] == 2 -> sb.append("${pop()}\n")
                arr[0] == 3 -> sb.append("${size()}\n")
                arr[0] == 4 -> sb.append("${isEmpty()}\n")
                arr[0] == 5 -> sb.append("${peek()}\n")
            }
        }
    }

    print(sb)
}

fun pop() : Int {
    return if (stack.isEmpty()) -1 else stack.pop()
}

fun size() : Int {
    return stack.size
}

fun isEmpty() : Int {
    return if (stack.isEmpty()) 1 else 0
}

fun peek() : Int {
    return if (stack.isNotEmpty()) stack.peek() else -1
}