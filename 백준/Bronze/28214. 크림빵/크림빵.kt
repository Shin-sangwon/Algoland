import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var st = StringTokenizer(br.readLine());

    val n = st.nextToken().toInt();
    val k = st.nextToken().toInt();
    val p = st.nextToken().toInt();

    var index = 0;
    var target = 0;
    var answer = 0;
    st = StringTokenizer(br.readLine());

    for(i in 0 until n * k) {
        val tmp = st.nextToken().toInt();
        if(tmp == 1) {
            target++;
        }
        index++;

        if(index == k) {
            if(target >= p) {
                answer++;
            }
            target = 0;
            index = 0;
        }
    }

    print(answer);
}

