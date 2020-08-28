import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMaxScore' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING jewels as parameter.
     */

    public static int getMaxScore(String jewels) {
    // Write your code here
     int ans = 0;
        StringBuilder str = new StringBuilder();

        for(int i=0;i<jewels.length();i++){
            int n = str.length();
            if(n != 0 && jewels.charAt(i) == str.charAt(n-1)){
                ans++;
                str.deleteCharAt(n-1);
            }else{
                str.append(jewels.charAt(i));
            }
        }
        
        return ans;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String jewels = bufferedReader.readLine();

                int ans = Result.getMaxScore(jewels);

                bufferedWriter.write(String.valueOf(ans));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
