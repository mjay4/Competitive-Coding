import java.util.*;

public class Square{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0){
            int ar[] = new int[2];
            int br[] = new int[2];
            ar[0] = sc.nextInt();
            ar[1] = sc.nextInt();
            br[0] = sc.nextInt();
            br[1] = sc.nextInt();
            
            Arrays.sort(ar);
            Arrays.sort(br);
            ar[0]+= br[0];
            if(ar[0]==ar[1] && ar[0]==br[1])
                System.out.println("YES");
            else{
                System.out.println("NO");
            }
        }
    }
}