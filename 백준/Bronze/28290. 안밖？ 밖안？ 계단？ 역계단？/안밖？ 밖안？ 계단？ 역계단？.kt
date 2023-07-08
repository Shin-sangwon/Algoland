import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));

    val str = br.readLine();

    when {
        str.equals("fdsajkl;") || str.equals("jkl;fdsa") -> print("in-out");
        str.equals("asdf;lkj") || str.equals(";lkjasdf") -> print("out-in");
        str.equals("asdfjkl;") -> print("stairs");
        str.equals(";lkjfdsa")-> print("reverse");
        else -> print("molu");
    }


}

