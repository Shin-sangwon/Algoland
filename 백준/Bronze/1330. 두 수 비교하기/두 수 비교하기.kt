import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
        val st = StringTokenizer(readLine());
        val left = Integer.parseInt(st.nextToken());
        val right = Integer.parseInt(st.nextToken());

        print(calc(left, right));
}

fun calc(left: Int, right: Int): String {

        val answer = when{
                left > right -> ">"
                left < right -> "<"
                else -> "=="
        }

        return answer;
}
