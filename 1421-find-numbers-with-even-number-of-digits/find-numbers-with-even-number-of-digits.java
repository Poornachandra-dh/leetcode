class Solution { 
    public int findNumbers(int[] nums) { 
        int ans = 0; 
        
        for (int i = 0; i < nums.length; i++) { 
            int count = 0; 
            int temp = nums[i]; // Avoid modifying the original array
            
            while (temp > 0) { 
                temp = temp / 10; 
                count++; 
            } 
            
            // Check after counting all digits
            if (count > 0 && count % 2 == 0) { 
                ans++; 
                } 
            } 
        return ans; 
    } 
}
