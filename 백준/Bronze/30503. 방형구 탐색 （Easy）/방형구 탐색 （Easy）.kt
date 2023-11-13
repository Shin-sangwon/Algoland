import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map {it.toInt()}.toIntArray()

    val m = br.readLine().toInt()

    repeat(m) {
        val st = StringTokenizer(br.readLine())

        val num = st.nextToken().toInt()
        val l = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        var cnt = 0
        if(num == 1) {
            val k = st.nextToken().toInt()
            for(i in l - 1 until r) {
                if(arr[i] == k) cnt++
            }
            sb.append("$cnt\n")
        }else {
            for(i in l - 1 until r) {
                arr[i] = 0
            }
        }
    }

    print(sb)
}


