package ryu.week1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs


val br = BufferedReader(InputStreamReader(System.`in`))
var tc = 0
var n = 0
var r = 0
lateinit var root:IntArray

fun main() {

    tc = br.readLine().toInt()
    val sb = StringBuilder()

    for(i in 1..tc) {
        setting()
        val social = br.readLine().toInt()

        sb.append("Scenario $i:\n")

        repeat(social) {
            val (from, to) = br.readLine().split(" ").map { it.toInt() }

            if(find(from) == find(to)) {
                sb.append("1\n")
            }else {
                sb.append("0\n")
            }
        }

        sb.append("\n")
    }

    print(sb)
}

fun setting() {

    n = br.readLine().toInt()
    r = br.readLine().toInt()

    root = IntArray(n)
    for(i in 0 until n) {
        i.also {  root[i] = it }
    }

    repeat(r) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        union(from, to)
    }
}

fun find(x: Int): Int {

    if(root[x] == x) return x
    root[x] = find(root[x])
    return root[x]

}

fun union(x: Int, y: Int) : Boolean {

    val rootX = find(x)
    val rootY = find(y)

    if(rootX == rootY) return false

    root[rootY] = rootX

    return true
}




