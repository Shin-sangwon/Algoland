import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs

lateinit var left: PriorityQueue<Int>
lateinit var right: PriorityQueue<Int>
var ans = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (n, m) = readLine().split(" ").map { it.toInt() }
    left = PriorityQueue()
    right= PriorityQueue(reverseOrder())

    val arr = readLine().split(" ").map { it.toInt() }.forEach { if(it < 0) left.add(it) else right.add(it) }

    findMaxDistance(m)
    arrange(m)

    print(ans)
}

fun leftArrange(m: Int) {
    var cnt = 0
    var tmp = 0
    while(left.isNotEmpty()) {
        if(cnt == m) {
            ans += abs(tmp) * 2
            tmp = 0
            cnt = 0
            continue
        }

        if(cnt == 0) {
            cnt++
            tmp += left.poll()
            continue
        }
        left.poll()
        cnt++

    }

    ans += abs(tmp) * 2
}

fun rightArrange(m: Int) {
    var cnt = 0
    var tmp = 0
    while(right.isNotEmpty()) {
        if(cnt == m) {
            ans += abs(tmp) * 2
            tmp = 0
            cnt = 0
            continue
        }

        if(cnt == 0) {
            cnt++
            tmp += right.poll()
            continue
        }
        right.poll()
        cnt++

    }

    ans += abs(tmp) * 2
}

fun arrange(m: Int) {
    leftArrange(m)
    rightArrange(m)
}

fun findMaxDistance(m: Int) {

    val leftMax = abs(left.peek() ?: 0)
    val rightMax = abs(right.peek() ?: 0)

    var idx = 1
    var cnt = 0
    if(leftMax > rightMax) {
        cnt += left.poll()
        while(left.isNotEmpty() && idx != m) {
            left.poll()
            idx++
        }
    }else {
        cnt += right.poll()
        while(right.isNotEmpty() && idx != m) {
            right.poll()
            idx++
        }
    }

    ans += abs(cnt)
}