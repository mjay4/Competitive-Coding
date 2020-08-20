import java.util.*;

public class OmkarAndWaterSlide{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int t =sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long ar[] = new long[n];
            for(int i =0;i<n;i++){
                ar[i] = sc.nextLong();
            }
            long prev = 0;long ans =0;
            for(int i =0;i<n;i++){
                if(ar[i] < prev){
                    ans+=prev-ar[i];
                }
                prev = ar[i];
            }
            System.out.println(ans);
        }
    }
    
}