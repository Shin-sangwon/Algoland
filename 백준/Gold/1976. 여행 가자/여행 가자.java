import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
	
	static int n,m, arr[];
	
	private static int find(int x) {
		
		if(arr[x] == x) return x;
		
		return arr[x] = find(arr[x]);
	}
	
	private static void union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(xRoot == yRoot) return;
		
		arr[yRoot] = xRoot;
		
	}
	
	private static boolean calc(int[] arr) {
		
		int target = find(arr[0]);
		
		for(int x : arr) {
			if(find(x) != target) return false;
		}
		
		return true;
		
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		
		for(int i = 1; i <= n; i++) arr[i] = i;
		
		for(int i = 1; i <= n; i++) {
			
			int[] cities = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int j = 0; j < cities.length; j++) {
				
				if(cities[j] == 1) union(i , j + 1);
			}
		}
		
		int[] tripCities = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean answer = calc(tripCities);
		
		System.out.println(answer? "YES" : "NO");
		
	}

}
