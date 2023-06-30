package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));

    val numbers = br.readLine().split(" ").mapNotNull { it.toIntOrNull() }.toMutableList();

    numbers.sort();

    val order = br.readLine();

    for(alpha in order) {
        when(alpha) {
            'A' -> print("${numbers[0]} ");
            'B' -> print("${numbers[1]} ");
            else -> print("${numbers[2]} ");
        }
    }

}



