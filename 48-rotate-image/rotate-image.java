class Solution {
    public void rotate(int[][] matrix) {
        int m =matrix.length;
        int n = matrix[0].length;
        
        for(int i=0;i<m;i++){
            for(int j =i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =  temp;
                
            }

        }
        for(int a =0 ; a<m;a++){
            int low=0;
            int high = n-1;
            while(low<high){
               int temp = matrix[a][low];
               matrix[a][low] = matrix[a][high];
               matrix[a][high] = temp ;
               low++;
               high--;
            }
        }
    
        


        

        
    }
}