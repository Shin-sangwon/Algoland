import java.util.*;


public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	static void hanoi(int start, int mid, int end, int num) {
		if(num == 1) {
			sb.append(start + " " + end + '\n');
			return;
		}
		
		hanoi(start, end, mid, num - 1);
		sb.append(start + " " + end + '\n');
		hanoi(mid, start, end, num-1);
		
	}
	

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sb.append((int)(Math.pow(2, num) - 1)).append('\n');
		hanoi(1, 2, 3, num);
		System.out.println(sb);
		
		
		
		
	}
}
