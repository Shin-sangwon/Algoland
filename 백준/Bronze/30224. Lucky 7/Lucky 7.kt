import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = n.toString().split("").toList()

    if(n % 7 != 0 && !list.contains("7")) {
        print(0)
    }else if(n % 7 == 0 && !list.contains("7")){
        print(1)
    }else if(n % 7 != 0 && list.contains("7")){
        print(2)
    }else{
        print(3)
    }


}







