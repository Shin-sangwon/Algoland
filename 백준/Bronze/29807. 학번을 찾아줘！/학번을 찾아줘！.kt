import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    // 국 수 영 탐 제2외국어
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(5) {0}
    val st = StringTokenizer(br.readLine())
    
    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    var answer: Long = 0

    answer += if(arr[0] > arr[2]) {
        (arr[0] - arr[2]) * 508
    }else {
        (arr[2] - arr[0]) * 108
    }

    answer += if(arr[1] > arr[3]) {
        (arr[1] - arr[3]) * 212
    }else {
        (arr[3] - arr[1]) * 305
    }

    if(n == 5) {
        answer += arr[4] * 707
    }

    print(answer * 4763)

}







