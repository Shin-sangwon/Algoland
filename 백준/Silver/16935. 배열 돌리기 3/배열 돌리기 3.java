import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

	static int n,m,r;
	
	private static int[][] rotate1(int[][] arr) {
		
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] newArr = new int[n][m];
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m; j++) {
				newArr[i][j] = arr[n-i-1][j];
				newArr[n-i-1][j] = arr[i][j];
			}
		}
		
		return newArr;
	}
	
	private static int[][] rotate2(int[][] arr) {
		
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] newArr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				newArr[i][j] = arr[i][m-j-1];
				newArr[i][m-j-1] = arr[i][j];
			}
		}
		
		return newArr;
	}
	
	private static int[][] rotate3(int[][] arr) {
		
		int n = arr.length;
		int m = arr[0].length;
		// 돌린 크기만큼으로 생성해준다.
		int[][] newArr = new int[m][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newArr[j][n - 1 - i] = arr[i][j];
			}
		}

		// 새로 돌린 배열로 반환해준다.
		return newArr;
	}
	
	private static int[][] rotate4(int[][] arr) {
		
		int[][] rotate90 = rotate3(arr);
		int[][] rotate180 = rotate3(rotate90);
		
		return rotate3(rotate180);
	}
	
	private static int[][] rotate5(int[][] arr) {
		
		int n = arr.length;
		int m = arr[0].length;
		
		int[][] newArr = new int[n][m];
		
		//1 -> 2
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < m/2; j++) {
				newArr[i][j+(m/2)] = arr[i][j];
			}
		}
		
		// 2 -> 3
		
		for(int i = 0; i < n/2; i++) {
			for(int j = m/2; j < m; j++) {
				newArr[i + (n/2)][j] = arr[i][j];
			}
		}
		
		// 3 -> 4
		
		for(int i = n/2; i < n; i++) {
			for(int j = m/2; j < m; j++) {
				newArr[i][j - m/2] = arr[i][j];
			}
		}
		
		// 4 -> 1
		
		for(int i = n/2; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				newArr[i - n/2][j] = arr[i][j];
			}
		}
		
		return newArr;
	}
	
	private static int[][] rotate6(int[][] arr) {
		
		int[][] rotate90 = rotate5(arr);
		int[][] rotate180 = rotate5(rotate90);
		
		return rotate5(rotate180);
	}
	
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] rotate = Stream.of(br.readLine().split(" "))
				   	.mapToInt(Integer::parseInt)
					.toArray();
		
		int[][] sout = rotate6(arr);
		
		int[][] answer = new int[n][m];
		for (int i = 0; i < rotate.length; i++) {

			switch (rotate[i]) {
			case 1:
				answer = rotate1(arr);
				arr = answer;
				break;
			case 2:
				answer = rotate2(arr);
				arr = answer;
				break;
			case 3:
				answer = rotate3(arr);
				arr = answer;
				break;
			case 4:
				answer = rotate4(arr);
				arr = answer;
				break;
			case 5:
				answer = rotate5(arr);
				arr = answer;
				break;
			case 6:
				answer = rotate6(arr);
				arr = answer;
				break;
			}
		}
		
		for(int[] x : answer) {
			for(int y : x) {
				sb.append(y + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
