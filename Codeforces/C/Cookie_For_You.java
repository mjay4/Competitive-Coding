import java.util.*;

public class Cookie_For_You{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long t = sc.nextLong();
        while(t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();
            long m = sc.nextLong();
            if(m<=Math.min(a,b) && m+n <=a+b)
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
}