import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = 15

    for(i in 0 until 15) {
        val str = br.readLine().split(" ")
        for(j in 0 until 15) {

            if(str[j] == "w" || str[j] == "b" || str[j] == "g") {

                if(str[j] == "w") {
                    print("chunbae")
                }else if(str[j] == "b") {
                    print("nabi")
                }else {
                    print("yeongcheol")
                }
                return
            }
        }
    }

}
