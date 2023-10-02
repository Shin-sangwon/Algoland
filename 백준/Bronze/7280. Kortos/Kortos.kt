import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s = BooleanArray(13)
    val b = BooleanArray(13)
    val v = BooleanArray(13)
    val k = BooleanArray(13)

    for(i in 0 until 51) {
        val st = StringTokenizer(br.readLine())

        val shape = st.nextToken()
        val number = st.nextToken().toInt()

        when(shape) {
            "B" -> b[number-1] = true
            "S" -> s[number-1] = true
            "V" -> v[number-1] = true
            else -> k[number-1] = true
        }
    }

    for(i in 0 until 13) {
        val idx = i + 1
        if(!s[i]) {
            print("S $idx")
            break
        }
        if(!b[i]){
            print("B $idx")
            break
        }
        if(!v[i]){
            print("V $idx")
            break
        }
        if(!k[i]){
            print("K $idx")
            break
        }
    }
}