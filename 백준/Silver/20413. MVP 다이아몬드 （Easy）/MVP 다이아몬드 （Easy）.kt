import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

lateinit var priceHelper: HashMap<Char, Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val n = readLine().toInt()
    val arr = intArrayOf(0) + readLine().split(" ").map { it.toInt() }.toIntArray()
    val query = readLine()
    initHelper()

    var payment = 0
    var answer = 0
    val queue: Queue<Int> = LinkedList()

    for(str in query) {
        val now = priceHelper[str]!!
        if(now == 4) {
            val nowPay = arr[now]
            payment += arr[now]
            answer += arr[now]
            queue.add(arr[now])
            if(queue.size >= 2) payment -= queue.poll()
        }else {
            val nowPay = (arr[now + 1] - 1) - payment
            payment += nowPay
            answer += nowPay
            queue.add(nowPay)
            if(queue.size >= 2) payment -= queue.poll()
        }
    }
    print(answer)
}

fun initHelper() {
    priceHelper = HashMap()
    priceHelper['B'] = 0
    priceHelper['S'] = 1
    priceHelper['G'] = 2
    priceHelper['P'] = 3
    priceHelper['D'] = 4
}



