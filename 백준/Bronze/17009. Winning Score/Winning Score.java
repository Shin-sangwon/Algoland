import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int teamA = 0;
        int teamB = 0;

        teamA += Integer.parseInt(br.readLine()) * 3;
        teamA += Integer.parseInt(br.readLine()) * 2;
        teamA += Integer.parseInt(br.readLine());

        teamB += Integer.parseInt(br.readLine()) * 3;
        teamB += Integer.parseInt(br.readLine()) * 2;
        teamB += Integer.parseInt(br.readLine());

        bw.write(teamA == teamB? "T" : teamA > teamB? "A" : "B");
        bw.flush();
        bw.close();
        br.close();


    }

}