import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val map:HashMap<String, String> = HashMap()

    map["Algorithm"] = "204"
    map["DataAnalysis"] = "207"
    map["ArtificialIntelligence"] = "302"
    map["CyberSecurity"] = "B101"
    map["Network"] = "303"
    map["Startup"] = "501"
    map["TestStrategy"] = "105"

    val n = br.readLine().toInt()

    repeat(n) {
        println(map[br.readLine()])
    }
}
