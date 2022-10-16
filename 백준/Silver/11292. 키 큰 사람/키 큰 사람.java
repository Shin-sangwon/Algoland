import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    
    static class Student{

        String name;
        float height;

        public Student(String name, float height) {
            this.name = name;
            this.height = height;
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        ArrayList<Student> al;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;
            
            al = new ArrayList<>();
            float max = Float.MIN_VALUE;

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                float height = Float.parseFloat(st.nextToken());

                if(height > max) max = height;

                al.add(new Student(name, height));
            }

            for(Student student : al) {
                if(student.height == max) sb.append(student.name + " ");
            }

            sb.append("\n");

        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}