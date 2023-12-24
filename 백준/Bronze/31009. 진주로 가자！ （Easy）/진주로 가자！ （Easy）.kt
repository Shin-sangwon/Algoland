import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val sb = StringBuilder()

    var target = -1
    var count = 0
    val list:MutableList<Int> = mutableListOf()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val name = st.nextToken()
        val price = st.nextToken().toInt()

        if(name == "jinju") {
            sb.append("$price\n")
            target = price
        }else {
            list.add(price)
        }

    }

    for(i in list.indices) {
        if(list[i] > target) count++
    }

    sb.append(count)

    print(sb)
}



