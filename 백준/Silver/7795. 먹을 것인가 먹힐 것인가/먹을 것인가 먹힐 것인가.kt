import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val tc = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(tc) {
        var answer = 0
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val arr1 = IntArray(n)
        val arr2 = IntArray(m)
        var st = StringTokenizer(br.readLine())
        for(i in 0 until n) {
            arr1[i] = st.nextToken().toInt()
        }

        st = StringTokenizer(br.readLine())
        for(i in 0 until m) {
            arr2[i] = st.nextToken().toInt()
        }

        arr1.sort()
        arr2.sort()
        // a가 b보다 큰 수
        for(a in arr1) {
            

            var startIdx = 0
            var endIdx = m - 1

            while(startIdx <= endIdx) {
                val mid = startIdx + (endIdx - startIdx) / 2

                if(arr2[mid] < a) {
                    startIdx = mid + 1
                }else {
                    endIdx = mid - 1
                }
            }
                if(endIdx != -1) {
                    answer += startIdx
                }
        }

        sb.append("$answer\n")


    }

    print(sb)
}