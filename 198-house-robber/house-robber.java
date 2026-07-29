class Solution {
    public int max(int[] nums,int idx,int[]dp) {
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int steal = nums[idx]+ max(nums,idx+2,dp);
        int skip = max(nums,idx+1,dp);
        dp[idx] =  Math.max(steal,skip) ;
        return dp[idx] ;
        
        
    }
    public int rob(int[] nums) {
        // idx - > 0 to n-1
        int n = nums.length ; 
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        return max(nums,0,dp);

        
    }
}