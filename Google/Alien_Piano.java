import java.util.*;

public class Alien_Piano {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int count = 0;
            int dec = 0;
            int inc = 0;

            int n = sc.nextInt();
            int ar[] = new int[n];
            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
            }

            for (int j = 1; j < n; j++) {
                if (ar[j] > ar[j - 1]) {
                    inc++;
                    dec = 0;
                } else if (ar[j] < ar[j - 1]) {
                    dec++;
                    inc = 0;
                }
                if (Math.max(inc, dec) >= 4) {
                    dec = 0;
                    inc = 0;
                    count++;
                }
            }

            System.out.println("Case #" + i + ": " + count);
        }
    }
}
