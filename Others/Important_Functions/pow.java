long mod = (long) 1_000_000_007;
public static int pow(int a, int b){
    long res = 1;
    // a pow b.
    while(b>0){
        if( (b&1) !=0)
            res = (res * a )%mod;
        
        a = (a % mod * a % mod) % mod ;
        b = b >> 1;
    }
    return (int) res;
}