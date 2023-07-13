import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val str: String = br.readLine();

    val arr: Array<Char> = arrayOf('w', 'o', 'l', 'f');

    var idx: Int = 0;
    var words: IntArray = IntArray(4);
    var answer = 1;

    if(str[0] != 'w') {
        print("0");
        return;
    }

    for (word in str.indices) {
        // 같은 단어일 때
        if (str[word] == arr[idx]) {
            words[idx]++;
            continue;
        }

        // 다른 단어일 때
        if (str[word] != arr[idx]) {

            if (str[word - 1] == 'f' && str[word] != 'f' && str[word] != 'w') {
                answer = 0;
                break;
            }


            if (str[word] == 'w') {

                if (idx == 3) {
                    if (!calc(words)) {
                        answer = 0;
                        break;
                    } else {
                        words = IntArray(4);
                        idx = 0;
                        words[idx]++;
                    }
                }
            } else {
                if (str[word] != arr[idx + 1]) {
                    answer = 0;
                    break;
                } else {
                    idx++;
                    words[idx]++;
                    continue;
                }
            }
        }

    }

    if (!calc(words) || str.length < 4) {
        answer = 0;
    }

    print(answer);
}

fun calc(arr: IntArray): Boolean {

    for (i in 1 until 4) {
        if (arr[i] != arr[0]) return false;
    }

    return true;
}