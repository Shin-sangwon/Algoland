import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var roots:IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

   val (n, m) = readLine().split(" ").map { it.toInt() }
    roots = IntArray (n) { it }
    for(i in 0 until m){
        val (x, y) = readLine().split(" ").map { it.toInt() }
        if(hasCycle(x, y)) {
            print(i + 1)
            return@with
        }

        union(x, y)
    }

    print(0)
}

fun find(x: Int) : Int {
    if(roots[x] == x) return x
    roots[x] = find(roots[x])
    return roots[x]
}

fun union(x: Int, y: Int) : Boolean {
    val rootX = find(x)
    val rootY = find(y)

    if(rootX == rootY) return false

    roots[rootY] = rootX
    return true
}

fun hasCycle(x: Int, y: Int) : Boolean {
    val xRoot = find(x)
    val yRoot = find(y)
    return xRoot == yRoot
}