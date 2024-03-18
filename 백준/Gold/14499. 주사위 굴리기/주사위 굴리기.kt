import java.io.BufferedReader
import java.io.InputStreamReader

class Dice(xx: Int, yy: Int) {
    private val number = Array (4) {IntArray (3)}
    var top = 0
    var bottom = 0
    var x = xx
    var y = yy

    fun roll(num: Int) {
        require(num in 1..4)
        when (num) {
            1 -> rollRight()
            2 -> rollLeft()
            3 -> rollUp()
            else -> rollDown()
        }
    }

    private fun rollRight() {
        val tmp = number[1][1]
        number[1][1] = number[1][0]
        number[1][0] = number[3][1]
        number[3][1] = number[1][2]
        number[1][2] = tmp
        setting()
    }

    private fun rollLeft() {
        val tmp = number[1][1]
        number[1][1] = number[1][2]
        number[1][2] = number[3][1]
        number[3][1] = number[1][0]
        number[1][0] = tmp
        setting()
    }

    private fun rollUp() {
        val tmp = number[0][1]
        number[0][1] = number[1][1]
        number[1][1] = number[2][1]
        number[2][1] = number[3][1]
        number[3][1] = tmp
        setting()
    }

    private fun rollDown() {
        val tmp = number[3][1]
        number[3][1] = number[2][1]
        number[2][1] = number[1][1]
        number[1][1] = number[0][1]
        number[0][1] = tmp
        setting()
    }

    private fun setting() {
        top = number[1][1]
        bottom = number[3][1]
    }

    fun setPoint(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    fun setBot(num: Int) {
        number[3][1] = num
        bottom = num
    }
}

val dx = intArrayOf(0, 0, 0, -1, 1)
val dy = intArrayOf(0, 1, -1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n, m, x, y ,q) = readLine().split(" ").map { it.toInt() }
    val arr = Array (n) { IntArray (m) }
    repeat(n) { it ->
        arr[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    val query = readLine().split(" ").map { it.toInt() }.toIntArray()

    val sb = StringBuilder()
    val dice = Dice(x, y)
    for(i in query.indices) {
        val k = query[i]
        val nx = dx[k] + dice.x
        val ny = dy[k] + dice.y

        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue

        dice.setPoint(nx, ny)
        dice.roll(k)
        sb.append("${dice.top}\n")

        if(arr[nx][ny] == 0) {
            arr[nx][ny] = dice.bottom
        }else {
            dice.setBot(arr[nx][ny])
            arr[nx][ny] = 0
        }

    }

    print(sb)

}