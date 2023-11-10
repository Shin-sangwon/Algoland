import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while(true) {
        val n = br.readLine().toBigInteger()

        if(n == BigInteger.ZERO) break

        if(n % BigInteger("42") == BigInteger.ZERO) {
            println("PREMIADO")
        }else {
            println("TENTE NOVAMENTE")
        }

    }
}


