import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val arr1 = readLine().toCharArray()
    val arr2 = readLine().toCharArray()
    val dp = Array (1001) { IntArray (1001) }
    val str = Array(1001) {IntArray (1001)}
    val sb = StringBuilder()

    for(i in 1..arr1.size) {
        for(j in 1..arr2.size) {
            if(arr1[i - 1] == arr2[j - 1]){
                dp[i][j] = dp[i - 1][j - 1] + 1
                str[i][j] = 1
            }else {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])
                str[i][j] = if(dp[i][j - 1] > dp[i - 1][j]) 2 else 3
            }
        }
    }

    println(dp[arr1.size][arr2.size])
    println(findString(str, arr1, arr1.size, arr2.size))
}

fun findString(arr: Array<IntArray>, arr1: CharArray, i: Int, j: Int): String {
    return if (i == 0 || j == 0) {
        ""
    } else if (arr[i][j] == 1) {
        findString(arr, arr1, i - 1, j - 1) + arr1[i - 1]
    } else if (arr[i][j] == 2) {
        findString(arr, arr1, i, j - 1)
    } else {
        findString(arr, arr1, i - 1, j)
    }
}