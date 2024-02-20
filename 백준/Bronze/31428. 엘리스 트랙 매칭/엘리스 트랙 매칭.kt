import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val arr = readLine().split(" ")
    val map: HashMap<String, Int> = HashMap()
    for(c in arr) {
        map[c] = map.getOrDefault(c ,0) + 1
    }

    val track = readLine()
    print(if(!map.containsKey(track)) 0 else map[track])
}