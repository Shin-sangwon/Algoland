package kotlinPlayground

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();
    val votes = br.readLine();

    var count = 0;

    for(vote in votes) {

        when(vote) {
            'A' -> count++;
            else -> count--;
        }
    }

    when {
        count > 0 -> print("A");
        count < 0 -> print("B");
        else -> print("Tie");
    }



}

