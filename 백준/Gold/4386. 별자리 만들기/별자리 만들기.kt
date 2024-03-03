import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt


data class Star(val from: Int, val to: Int, val weight: Double)

var n = 0
lateinit var stars: Array<Pair<Double, Double>>
lateinit var roots: IntArray
lateinit var starList: ArrayList<Star>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    n = readLine().toInt()
    stars = Array (n) { Pair(0.0, 0.0) }
    roots = IntArray (n) {it}
    starList = ArrayList()
    for(i in 0 until n) {
        stars[i] = readLine().split(" ").map { it.toDouble() }.let { (a, b) -> Pair(a, b) }
    }

    for(i in 0 until n) {
        for(j in i + 1 until n) {
            val star1 = stars[i]
            val star2 = stars[j]
            val weight = sqrt(abs(star1.first - star2.first).pow(2) + abs(star1.second - star2.second).pow(2))
            starList.add(Star(i, j, weight))
        }
    }

    starList.sortBy { it.weight }
    var count = 0
    var ans = 0.0

    for(star in starList) {
        if(union(star.from, star.to)) {
            ans += star.weight
            if(++count == n) break
         }
    }

    print("%.2f".format(ans))
}

private fun find(x: Int) : Int {

    if(roots[x] == x) return x
    roots[x] = find(roots[x])
    return roots[x]
}

private fun union(x: Int, y: Int) : Boolean {

    val rootX = find(x)
    val rootY = find(y)

    if(rootX == rootY) return false

    roots[rootY] = rootX

    return true
}