import java.util.*;
import java.io.*;

public class Buying_Shovels{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0){
            int n,k;
            n = sc.nextInt();
            k = sc.nextInt();

            if(n<=k)
                System.out.println(1);
            else{
                int ans=n;
                for(int i=2;i<=Math.sqrt(n);i++){
                    if(n%i==0){
                        if(n/i<=k)
                            ans=Math.min(ans,i);
                        if(i<=k)
                            ans=Math.min(ans,n/i); 
                    }
                }
                System.out.println(ans);
            }
        }
    }
}