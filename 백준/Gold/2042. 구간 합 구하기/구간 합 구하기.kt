import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.ceil
import kotlin.math.ln

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    var st = StringTokenizer(br.readLine());
    val sb = StringBuilder();

    val n = st.nextToken().toInt();
    val m = st.nextToken().toInt(); // 수 변경
    val k = st.nextToken().toInt(); // 구간 합

    val arr = LongArray(n);

    for(i in 0 until n) {
        arr[i] = br.readLine().toLong();
    }

    val h: Int = ceil(ln(n.toDouble()) / ln(2.0)).toInt();
    val tree_size: Int = (1 shl (h + 1));
    val tree: LongArray = LongArray(tree_size);

    init(arr, tree, 1, 0, n - 1);

    var idx = m + k;

    while(idx-->0) {
        st = StringTokenizer(br.readLine());

        val a = st.nextToken().toInt();
        val b = st.nextToken().toInt();
        val c = st.nextToken().toLong();

        if(a == 1) {
            update(arr, tree, 1, 0, n-1, b - 1, c);
        }else {
            val ans = query(tree, 1, 0, n - 1, b - 1, c.toInt() - 1);
            sb.append("$ans\n");
        }

    }

    print(sb);
}

fun init(arr: LongArray, tree: LongArray, node: Int, start: Int, end: Int) {

    if(start == end) {
        tree[node] = arr[start];
    }else {
        init(arr, tree, node * 2, start, (start + end) / 2);
        init(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

}

fun query(tree: LongArray, node: Int, start: Int, end: Int, left: Int, right: Int): Long {

    if(left > end || right < start) {
        return 0;
    }

    if(left <= start && end <= right) {
        return tree[node];
    }

    val lSum: Long = query(tree, node * 2, start, (start + end) / 2, left, right);
    val rSum: Long = query(tree, node * 2 + 1, (start + end) / 2 + 1, end, left, right);

    return lSum + rSum;
}

fun update(arr: LongArray, tree: LongArray, node: Int, start: Int, end: Int, index: Int, value: Long) {
    if(index < start || index > end) {
        return;
    }

    if(start == end) {
        arr[index] = value;
        tree[node] = value;
        return;
    }

    update(arr, tree, node * 2, start, (start + end) / 2, index, value);
    update(arr, tree, node * 2 + 1, (start + end) / 2 + 1, end, index, value);
    tree[node] = tree[node * 2] + tree[node * 2 + 1];
}