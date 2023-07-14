import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();

    val st = StringTokenizer(br.readLine());

    var answer = 0;

    for(i in 1 .. n) {
        val tmp = st.nextToken().toInt();
        if(i != tmp) answer++;
    }


    print(answer);

}

