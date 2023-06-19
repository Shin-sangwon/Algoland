import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine());

    val idx1 = st.nextToken().toLong();
    val idx2 = st.nextToken().toLong();

    print(lcm(idx1, idx2));

}

fun gcd(a: Long, b: Long) : Long{
    if(b == 0L) return a;
    return gcd(b, a % b);
}

fun lcm(a: Long, b: Long) : Long {
    return (a * b) / gcd(a, b);
}
