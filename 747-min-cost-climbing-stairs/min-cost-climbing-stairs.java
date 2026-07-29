class Solution {
    public int min(int[]cost, int idx , int[]dp){
        if(idx>=cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx] ; 

        return dp[idx] = cost[idx]+Math.min(min(cost,idx+1,dp) , min(cost,idx+2,dp));

    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length ; 
        int[]dp=new int[n] ; 
        Arrays.fill(dp,-1) ; 
        return  Math.min(min(cost,0,dp), min(cost,1,dp));
        
    }
}