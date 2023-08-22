package kotlinground

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var n = 0;
var k = 0;
var answer = 0;
lateinit var graph: MutableList<MutableList<Int>>
lateinit var apples: IntArray;
lateinit var visited: BooleanArray;

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`));

    val (nValue, kValue) = br.readLine().split(" ").map {it.toInt()};
    n = nValue;
    k = kValue;

    graph = MutableList(n) { mutableListOf() };

    repeat(n-1) {
        val (parent, child) = br.readLine().split(" ").map {it.toInt()};
        graph[parent].add(child);
        graph[child].add(parent);
    }

    apples = IntArray(n);
    visited = BooleanArray(n);
    val st = StringTokenizer(br.readLine());

    for(i in 0 until n) {
        apples[i] = st.nextToken().toInt();
    }

    dfs(0, 0);

    print(answer);
}

fun dfs(depth: Int, node: Int) {

    if(depth > k) return;

    if(apples[node] == 1) answer++;

    visited[node] = true;

    for(x in graph[node]) {
        if(visited[x]) continue;
        dfs(depth + 1, x);
    }

    return;
}