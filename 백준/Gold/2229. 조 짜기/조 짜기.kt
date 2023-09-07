package ryu.week1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max
import kotlin.math.min

val br = BufferedReader(InputStreamReader(System.`in`))

fun main() {

    val n = br.readLine().toInt()
    val arr = IntArray(n+1)
    val dp = IntArray(n+1)
    val st = StringTokenizer(br.readLine())

    for(i in 1 .. n) {
        arr[i] = st.nextToken().toInt()
    }

    for(i in 1 .. n) {

        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE
        dp[i] = dp[i - 1]

        for(j in i downTo 1) {
            max = max(arr[j], max)
            min = min(arr[j], min)

            dp[i] = max(dp[i], dp[j - 1] + (max - min))


        }
    }

    print(dp[n])

}




