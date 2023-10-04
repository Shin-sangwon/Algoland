import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val st= StringTokenizer(br.readLine());

    var right = 0
    var left = 0

    for(i in 0 until n) {
        val tmp = st.nextToken().toInt()

        if(tmp == 1) {
            right++
        }else if(tmp == -1) {
            left++
        }
    }

    if(right == left) {
        print("Stay")
    }else if(right > left) {
        print("Right")
    }else {
        print("Left")
    }
}