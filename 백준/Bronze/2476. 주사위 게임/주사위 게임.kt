import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toIntOrNull() ?: 0;
    var answer:Int = 0;

    for (i in 1..n) {
        val input = readLine();

        if(input != null) {
            val dice = input.split(" ");
            val first = dice[0].toIntOrNull() ?: 0;
            val second = dice[1].toIntOrNull() ?: 0;
            val third = dice[2].toIntOrNull() ?: 0;

            val prize = calc(first, second, third);
            answer = max(answer, prize);
        }
    }

    print(answer);
}

fun calc(first:Int, second:Int, third:Int): Int {
    val prize = when{
        first == second && second == third -> 10000 + first * 1000
        first != second && second != third && first != third -> maxOf(first, second, third) * 100
        else -> 1000 + find(first, second, third) * 100
    }

    return prize;
}

fun find(first:Int, second:Int, third:Int): Int {

    if(first == second) return first;
    if(second == third) return second;
    if(first == third) return first;

    return 0;
}