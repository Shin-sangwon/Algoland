import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

   val str = readLine()

    if(str.length > 2 && str[0] == '"' && str[str.length - 1] == '"') {
        print(str.substring(1, str.length - 1))
    }else {
        print("CE")
    }
}
