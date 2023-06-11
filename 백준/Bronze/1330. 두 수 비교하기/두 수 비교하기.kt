fun main() {
        val input = readLine();

        if(input != null) {
                val numbers = input.split(" ");

                if(numbers.size == 2) {
                        val left = numbers[0].toInt();
                        val right = numbers[1].toInt();

                        if(left != null && right != null) {
                                val answer = when {
                                        left > right -> ">"
                                        left < right -> "<"
                                        else -> "=="
                                }

                                print(answer);
                        }
                }
        }


}
