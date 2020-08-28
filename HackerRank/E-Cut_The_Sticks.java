import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[1001];
    for(int i=0;i<n;i++)
    {
        int x = sc.nextInt();
        arr[x]++;
    }
    System.out.println(n);
    for(int j=1;j<=1000;j++)
    {
        if(arr[j]!=0)
        {
            n=n-arr[j];
            if(n!=0)
                System.out.println(n);                
        }
    }   
    }
}
