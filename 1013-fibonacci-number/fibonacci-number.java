class Solution {
    static int dp[];
    public int dp(int n){
        if(n<=1) return n ;
        if(dp[n]!=-1) return dp[n] ; 
        int ans  =  dp(n-1)+dp(n-2);
        dp[n] = ans ; 
        return ans ; 


    }
    public int fib(int n) {
        dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i] = -1;
        }
       return  dp(n);
    }
}