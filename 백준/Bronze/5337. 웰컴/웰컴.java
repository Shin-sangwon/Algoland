import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		bw.write(".  .   .");
		bw.newLine();
		bw.write("|  | _ | _. _ ._ _  _");
		bw.newLine();
		bw.write("|/\\|(/.|(_.(_)[ | )(/.");
		
		bw.flush();
		bw.close();
		
		
	}

}