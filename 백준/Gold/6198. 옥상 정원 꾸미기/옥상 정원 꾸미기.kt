package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var ans = 0L
    val arr = IntArray(n)

    for(i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }

    val stack:Stack<Int> = Stack()

    for(i in 0 until n) {

        if(stack.isEmpty()) {
            stack.push(arr[i])
            continue
        }

        while(stack.isNotEmpty() && stack.peek() <= arr[i]) {
            stack.pop()
        }

        ans += stack.size

        stack.push(arr[i])
    }

    print(ans)

}