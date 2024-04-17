import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val str = readLine()

    var answer = 0
    var ironCount = 0

    for(i in str.indices) {

        // case1 : 쇠막대기 추가
        if(str[i] == '(') {
            ironCount++
            continue
        }

        // case2 : 쇠막대기 빼기
        ironCount--
        // case2-1 : 레이저를 쏘는거라면
        if(str[i - 1] == '(') {
            answer += ironCount
        } else { // case2-2 : ))는 쇠막대기의 끝이므로 조각 추가
            answer++
        }
    }

    print(answer)
}