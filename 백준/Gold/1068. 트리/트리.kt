package ryu.week1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val br = BufferedReader(InputStreamReader(System.`in`))
var n = 0
var root = 0
var deleteNode = 0
var answer = 0
lateinit var arr: Array<MutableList<Int>>
lateinit var visited: BooleanArray

fun main() {

    init()
    search(root)
    print(answer)
}

fun init() {

    n = br.readLine().toInt()
    arr = Array<MutableList<Int>>(n) { mutableListOf() }
    visited = BooleanArray(n)

    val st = StringTokenizer(br.readLine())

    for(i in 0 until n) {
        val now = st.nextToken().toInt()
        if(now == -1) {
            root = i
            continue
        }

        arr[now].add(i)
    }

    deleteNode = br.readLine().toInt()
    arr[deleteNode].clear()
}

fun search(x: Int) {

    if(n == 2) {
        answer = 1
        return
    }

    arr[x].forEach {
        if(visited[it] || deleteNode == it) return@forEach
        visited[it] = true
        if(arr[it].size == 0 || arr[it].size == 1 && arr[it][0] == deleteNode) answer++
        search(it)
    }

}

