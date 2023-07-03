import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();

    val idx = "CAMBRIDGE";

    val arr = idx.toCharArray();

    val words = br.readLine();

    for(word in words) {
        if(arr.contains(word)) continue;

        sb.append(word);
    }

    print(sb);
}

