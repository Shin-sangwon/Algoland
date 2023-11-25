import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val positive = PriorityQueue<Int>{o1, o2 -> o2 - o1}
    val negative = PriorityQueue<Int>()
    var zero = 0
    val list:MutableList<Int> = mutableListOf()

    repeat(n) {
        val now = readLine().toInt()

        if(now == 0) {
            zero++
            return@repeat
        }

        if(now == 1) {
            list.add(now)
            return@repeat
        }

        if(now > 0) {
            positive.add(now)
            return@repeat
        }

        negative.add(now)
    }

    while(positive.size > 1) {
        val first = positive.poll()
        val second = positive.poll()

        list.add(first * second)
    }

    if(positive.isNotEmpty()) {
        list.add(positive.poll())
    }

    while(negative.size > 1) {
        val first = negative.poll()
        val second = negative.poll()

        list.add(first * second)
    }

    if(negative.isNotEmpty()) {
        if(zero == 0) {
            list.add(negative.poll())
        }
    }

    print(list.sum())
}





