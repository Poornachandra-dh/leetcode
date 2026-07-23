class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length ; 
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/3 && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }
        }
        return ans;
        
    }
}