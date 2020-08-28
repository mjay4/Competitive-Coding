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
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER_ARRAY op
     */

    

}

public class Solution {
    public static List<Long> fun(int n, List<Integer> op) {
        Set<Integer> set = new HashSet<>();
        List<Long> ans = new ArrayList<>();
        int ar[] = new int[n];
        int len = n;
        long sum = 0;
        for(int i = 1;i<=n;i++){
            ar[i-1] = i;
            sum+=i;
            set.add(i);
        }
        for(int val : op){
            if(set.contains(val)){
                int temp = ar[0];
                ar[0] = ar[n-1];
                ar[n-1] = temp;
            }else{
                set.add(val);
                sum = sum + val-ar[n-1];
                if(set.contains(ar[n-1]))
                    set.remove(ar[n-1]);
                ar[n-1] = val;
            }
            ans.add(sum);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> ar = new ArrayList<>();
        for(int i =0;i<m;i++)
            ar.add(sc.nextInt());
        List<Long> ans = fun(n, ar);
        for(long a: ans){
            System.out.println(a);
        }
    }
}
