import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static class Student{
        int problem;
        int year;
        String lastName;

        public Student(int problem, int year, String lastName) {
            this.problem = problem;
            this.year = year;
            this.lastName = lastName;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Student[] students = new Student[3];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            String lastName = st.nextToken();

            students[i] = new Student(problem, year, lastName);
        }

        String firstAnswer = Arrays.stream(students)
            .mapToInt(student -> student.year % 100)
            .sorted()
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(""));

        String secondAnswer = Arrays.stream(students)
            .sorted((o1, o2) -> o2.problem - o1.problem)
            .map(student -> student.lastName.charAt(0))
            .map(String::valueOf)
            .collect(Collectors.joining(""));

        System.out.println(firstAnswer);
        System.out.println(secondAnswer);

    }
}
