package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val tc = br.readLine().toInt()

    repeat(tc) {

        val n = br.readLine().toInt()
        val arr = IntArray(n)

        val st = StringTokenizer(br.readLine())

        var answer: Long = 0
        val queue:PriorityQueue<Long> = PriorityQueue()

        while(st.hasMoreTokens()) {
            queue.add(st.nextToken().toLong())
        }

        answer = 0


        while(queue.isNotEmpty()) {

            if(queue.size == 1) {
                break
            }

            val e1 = queue.poll()
            val e2 = queue.poll()

            val combineFile = e1 + e2
            answer += combineFile
            queue.add(combineFile)
        }

        sb.append("$answer\n")

    }

    print(sb)
}