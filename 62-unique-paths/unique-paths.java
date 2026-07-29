

/*class Solution {
    public int paths(int m , int n , int[][]dp ){
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n] ; 
        int rightways =  paths(m,n-1,dp);
        int downways = paths(m-1,n,dp) ; 
        return dp[m][n] = rightways+downways ; 

    }

    

    public int uniquePaths(int m, int n) {
        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1 ; 
            }
        }
        
        return paths(m,n,dp);

    }
} */

class Solution{
    public int uniquePaths(int m, int n){
        int [][]dp = new int[m][n] ; 
        for(int i=0 ; i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0)  dp[i][j]=1;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1] ; 
            }
        }
        return dp[m-1][n-1] ; 
    }

}

    