import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Workbook {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int ans = 0;
        int cur = 1;
        for(int i = 0; i<n; i++){
            int min = 1;
            int val = arr[i];
            for(int j = 0; j<=(arr[i]-1)/k; j++){
                if(j!=(arr[i]-1)/k){
                    val = k;
                }else{
                    val = arr[i] - k*j;
                }
                if(check(min,min+val,cur)){
                    ans++;
                    //System.out.println(i +" "+ min+" " + (min+val) +" " +cur);
                }
                min+=k;
                cur++;
            }
        }

        return ans;
    }
    static boolean check(int start, int end, int cur){
        if(start<=cur && cur<end)
            return true;
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);
}
