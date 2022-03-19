import java.util.*;
import java.math.*;


public class Main {
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		int cnt = sc.nextInt();
		for(int i = 0; i < cnt; i++) {
			int tmp = sc.nextInt();
			
			if(tmp == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(q.poll());
				}
			}
			
			q.add(tmp);
		}
	}
}