package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var arr: IntArray
var n: Int = 0;
var m: Int = 0;


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));
    val st = StringTokenizer(br.readLine());
    val sb = StringBuilder();

    n = st.nextToken().toInt();
    m = st.nextToken().toInt();

    arr = IntArray(n);

    for(i in 0 until n) {
        arr[i] = br.readLine().toInt();
    }

    arr.sort();

    val map:HashMap<Int, Int> = HashMap();

    for(i in 0 until n) {
        if(map[arr[i]] == null) {
            map[arr[i]] = i;
        }
    }

    repeat(m) {
        val target = br.readLine().toInt();

        if(map[target] == null ){
            sb.append("-1\n");
        }else {
            val index = map[target];
            sb.append("$index\n");
        }
    }

    print(sb);

}