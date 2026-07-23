/*class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length ; 
        int[]output = new int[n*2] ;
        int k=0;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++ ; 
                }
            }
            output[k] = nums[i] ; 
            k++ ; 
            output[k] = count ; 
            k++ ;
        }
        int max = output[1] ; 
        int index=1 ;  
        for(int i=3;i<n*2;i+=2){
            if(output[i]>max){
                max= output[i] ; 
                index = i ; 
            }
        }
        return output[index-1] ; 
        
    }
}
*/

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}