import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val arr1 = IntArray(10);
    val arr2 = IntArray(10);

    for(i in 0 until 10) {
        arr1[i] = br.readLine().toInt();
    }

    for(i in 0 until 10) {
        arr2[i] = br.readLine().toInt();
    }

    arr1.sortDescending();
    arr2.sortDescending();

    val answer1 = arr1[0] + arr1[1] + arr1[2];
    val answer2 = arr2[0] + arr2[1] + arr2[2];

    print("$answer1\n$answer2");
}

