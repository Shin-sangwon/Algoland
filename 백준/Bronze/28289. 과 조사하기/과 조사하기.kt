import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();

    val answer = IntArray(4);
    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine());

        val a = st.nextToken().toInt();
        val b = st.nextToken().toInt();
        val c = st.nextToken().toInt();

        if(a == 1) {
            answer[3]++;
            continue;
        }

        when {
            b == 1 || b == 2 -> answer[0]++;
            b == 3 -> answer[1]++;
            else -> answer[2]++;
        }
    }

    for(i in answer) {
        println(i);
    }

}

