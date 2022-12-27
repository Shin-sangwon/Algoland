import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static int binary(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(target == arr[mid]) return mid;
            else if(target > arr[mid])  start = mid + 1;
            else end = mid - 1;

        }
        return Integer.MIN_VALUE;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arr1[] = new int[Integer.parseInt(br.readLine())];
        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1, " ");
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(arr1);

        int cnt = Integer.parseInt(br.readLine());
        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2, " ");
        for(int i = 0; i < cnt; i++){
            int ans = binary(arr1, Integer.parseInt(st2.nextToken()), 0, arr1.length-1);
            if(ans == Integer.MIN_VALUE) System.out.println(0);
            else System.out.println(1);
        }



        }
    }