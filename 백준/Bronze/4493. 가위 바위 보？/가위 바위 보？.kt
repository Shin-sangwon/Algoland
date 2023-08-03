import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val sb = StringBuilder();
    val tc = br.readLine().toInt();

    for(i in 0 until tc) {
        val n = br.readLine().toInt();

        var p1 = 0;
        var p2 = 0;

        for(j in 0 until n) {

            val st = StringTokenizer(br.readLine());

            val a = st.nextToken();
            val b = st.nextToken();

            val res = calc(a, b);

            if(res == 1) {
                p1++;
            }else if(res == 2) {
                p2++;
            }

        }

        if(p1 > p2) {
            sb.append("Player 1\n");
        }else if(p1 < p2) {
            sb.append("Player 2\n");
        }else {
            sb.append("TIE\n");
        }
    }

    println(sb);

}

fun calc(a: String, b: String) : Int {

    if(a == b) {
        return 0;
    }

    if(a == "R") {

        if(b == "P") {
            return 2;
        }else {
            return 1;
        }
    }

    if(a == "P") {

        if(b == "R") {
            return 1;
        }else {
            return 2;
        }
    }

    if(a == "S") {

        if(b == "R") {
            return 2;
        }else {
            return 1;
        }
    }

    return 0;
}

