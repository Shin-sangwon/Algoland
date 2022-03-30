import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cnt = br.readLine();
		int ans = 0;
		for(int i = 0; i < cnt.length(); i++) {
			ans++;
			if(i < cnt.length()-1) {
				if(cnt.charAt(i) == 'c') {
					if(cnt.charAt(i+1) == '=') {
						ans--;
					}else if(cnt.charAt(i+1) == '-') {
						ans--;
					}
				}if(cnt.charAt(i) == 'd') {
					if(cnt.charAt(i+1) == '-') {
						ans--;
					}
				}if(cnt.charAt(i) == 'l') {
					if(cnt.charAt(i+1) == 'j') {
						ans--;
					}
				}if(cnt.charAt(i) == 'n') {
					if(cnt.charAt(i+1) == 'j') {
						ans--;
					}
				}if(cnt.charAt(i) == 's') {
					if(cnt.charAt(i+1) == '=') {
						ans--;
					}
				}if(cnt.charAt(i) == 'z') {
					if(cnt.charAt(i+1) == '=') {
						ans--;
					}
				}				
			}
			if(i < cnt.length()-2) {
				if(cnt.charAt(i) == 'd') {
					if(cnt.charAt(i+1) == 'z') {
						if(cnt.charAt(i+2) == '=') {
							ans -= 1;
						}
					}
				}
			}
			
		}		
			System.out.println(ans);			
	}
}