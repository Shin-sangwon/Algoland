import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.ceil


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine());

    val a = st.nextToken().toDouble();
    val b = st.nextToken().toDouble();
    val c = st.nextToken().toDouble();

    print((ceil((a / c)) * ceil((b / c))).toLong());
}

