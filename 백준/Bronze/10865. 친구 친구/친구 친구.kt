import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var st = StringTokenizer(br.readLine());

    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt();

    val arr: IntArray = IntArray(n);

    for(i in 0 until m) {
       st = StringTokenizer(br.readLine());

       val a = st.nextToken().toInt();
       val b = st.nextToken().toInt();

       arr[a-1]++;
       arr[b-1]++;
    }

    arr.forEach { x -> println(x) };

}

