import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String s = (isPrime(n))? "Prime" : "Not prime";
            System.out.println( s );
        }
    }
    public static boolean isPrime(int n){
    if(n == 1){
        return false;
    }
    if(n == 2){
        return true;
    }
    for (int i = 2; i*i<=n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
}
