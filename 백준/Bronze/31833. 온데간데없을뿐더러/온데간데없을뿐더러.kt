import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()

    val arr1 = readLine().split(" ").toTypedArray()
    val arr2 = readLine().split(" ").toTypedArray()

    var a = ""
    var b = ""

    for(i in arr1.indices) {
        a += arr1[i].toLong()
        b += arr2[i].toLong()
    }

    val aCount = a.toLong()
    val bCount = b.toLong()

    if(aCount > bCount) print(bCount) else print(aCount)

}