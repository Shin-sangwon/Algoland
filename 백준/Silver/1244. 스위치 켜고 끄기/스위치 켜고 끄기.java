import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	static Boolean[] switches;
	
	static class Student{
		
		int gender;
		int number;
		public Student(int gender, int number) {
			this.gender = gender;
			this.number = number;
		}
		
	}
	
	private static void calc(Student student) {
		
		if(student.gender == 1) {
			
			for(int i = 0; i < switches.length; i++) {
				if(((i+1) % student.number) == 0) switches[i] = !switches[i];
			}
			return;
					
		}
		
		checker(student.number);
		
	}
	
	private static void checker(int n) {
		
		int idx = 1;
		switches[n-1] = !switches[n-1];
		while(true) {
			
			if(n+idx-1 >= switches.length || n-idx-1 < 0) break;
			
			if(switches[n+idx-1] == switches[n-idx-1]) {
				switches[n+idx-1] = !switches[n+idx-1];
				switches[n-idx-1] = !switches[n-idx-1];
				idx++;
				continue;
			}
			
			break;
		}
		
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		br.readLine();
		
		switches = Arrays.stream(br.readLine().split(" "))
				.map(x -> x.equals("1"))
				.toArray(Boolean[]::new);
		
		ArrayList<Student> students = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		
		while(n-->0) {
			
			st = new StringTokenizer(br.readLine());
			int gen = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			students.add(new Student(gen, num));
			
		}
		
		for(Student student : students) {
			calc(student);
		}
		
		for(int i = 0; i < switches.length; i++) {
			
			if(i % 20 == 0 && i != 0) {
				sb.append("\n");
			}
			
			if(switches[i]) {
				sb.append("1").append(" ");
				continue;
			}
			
			sb.append("0").append(" ");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
