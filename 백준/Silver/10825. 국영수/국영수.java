import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Student{
		
		String name;
		int aScore;
		int bScore;
		int cScore;
		
		public Student(String name, int aScore, int bScore, int cScore) {
			this.name = name;
			this.aScore = aScore;
			this.bScore = bScore;
			this.cScore = cScore;
		}

	}
	

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> al = new ArrayList<>();
		
		while(n-->0) {
			
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			al.add(new Student(name, a, b, c));
		}
		
		Collections.sort(al, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
		        int result = o2.aScore - o1.aScore;
		        if (result == 0) {
		            result = o1.bScore - o2.bScore;
		            if (result == 0) {
		                result = o2.cScore - o1.cScore;
		                if (result == 0) {
		                    result = o1.name.compareTo(o2.name);
		                }
		            }
		        }
		        return result;
		    }
		});
		
		for(Student x : al) {
			sb.append(x.name).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
