import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val n = br.readLine().toInt();

    val arr = Array(n) {CharArray (5)};
    val al : ArrayList<Int> = ArrayList();

    for(i in 0 until n) {
        arr[i] = br.readLine().toCharArray();
    }

    var max = 0;

    for(i in 0 until 5) {
        var tmp = 0;
        for(j in 0 until n) {
            if(arr[j][i] == 'Y') {
                tmp++;
            }
        }

        max = max(tmp, max);
    }

    for(i in 0 until 5) {
        var tmp = 0;
        for(j in 0 until n) {
            if(arr[j][i] == 'Y') {
                tmp++;
            }

        }

        if(tmp == max) {
            al.add(i + 1);
        }
    }

    print(al.joinToString(","));
}

