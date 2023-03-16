import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int approved = 0;
        int rejected = 0;
        int invalid = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()) {
        	
        	int tmp = Integer.parseInt(st.nextToken());
        	
        	if(tmp == -1)  {
        		rejected++;
        		continue;
        	}
        	
        	if(tmp == 1) {
        		approved++;
        		continue;
        	}
        	
        	invalid++;
        }
        
        int target = (n % 2 == 0? n / 2 : n / 2 + 1);
        
        if(invalid >= target) {
        	System.out.println("INVALID");
        	return;
        }
        
        if(approved == rejected || approved < rejected) {
        	System.out.println("REJECTED");
        	return;
        }
        
        System.out.println("APPROVED");
        
    }
}