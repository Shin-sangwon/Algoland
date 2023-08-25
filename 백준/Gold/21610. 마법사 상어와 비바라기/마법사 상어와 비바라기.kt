package ryu.week1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Cloud(var x: Int, var y: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cloud) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}

val dx:IntArray = intArrayOf(0, 0, -1, -1, -1, 0, 1, 1, 1)
val dy:IntArray = intArrayOf(0, -1, -1, 0, 1, 1, 1, 0, -1)

val ddx:IntArray = intArrayOf(-1, -1, 1, 1)
val ddy:IntArray = intArrayOf(-1, 1, -1, 1)

var n = 0
var m = 0
var answer = 0

lateinit var cloudQueue: MutableList<Cloud>
lateinit var map: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (nValue, mValue) = br.readLine().split(" ").map { it.toInt() }
    n = nValue
    m = mValue
    map = Array(n) {IntArray(n)}

    init(br)

    repeat(m) {
        val (dir, count) = br.readLine().split(" ").map { it.toInt() }
        move(dir, count)
        makeRain()
        makeCloud()
    }

    calc()

    print("$answer")

}

fun init(br: BufferedReader) {

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for(j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    cloudQueue = mutableListOf()

    cloudQueue.add(Cloud(n-1, 0))
    cloudQueue.add(Cloud(n-1, 1))
    cloudQueue.add(Cloud(n-2, 0))
    cloudQueue.add(Cloud(n-2, 1))

}

fun move(dir: Int, count: Int) {

    for(cloud in cloudQueue) {

        for(k in 0 until count) {
            cloud.x += dx[dir]
            cloud.y += dy[dir]

            if(cloud.x < 0) cloud.x = n-1
            if(cloud.x >= n) cloud.x = 0

            if(cloud.y < 0) cloud.y = n-1
            if(cloud.y >= n) cloud.y = 0
        }

        map[cloud.x][cloud.y] += 1
    }
}

fun makeRain() {

    for(cloud in cloudQueue) {

        for(k in 0 until 4) {
            val nx = ddx[k] + cloud.x
            val ny = ddy[k] + cloud.y

            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue

            if(map[nx][ny] != 0) map[cloud.x][cloud.y]++
        }
    }
}

fun makeCloud() {

    val newCloud: MutableList<Cloud> = mutableListOf()

    for(i in 0 until n) {
        for(j in 0 until n) {
            if(map[i][j] >= 2) {
                val cloud = Cloud(i, j)
                if(!cloudQueue.contains(cloud)) {
                    map[i][j] -= 2
                    newCloud.add(cloud)
                }
            }
        }
    }

    cloudQueue = newCloud

}

fun calc() {

    for(i in 0 until n) {
        for(j in 0 until n) {
            answer += map[i][j]
        }
    }
}