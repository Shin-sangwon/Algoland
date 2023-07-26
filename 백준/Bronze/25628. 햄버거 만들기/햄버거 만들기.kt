import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val st = StringTokenizer(br.readLine());
    
    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt();
    
    print(min(n / 2, m));
}

