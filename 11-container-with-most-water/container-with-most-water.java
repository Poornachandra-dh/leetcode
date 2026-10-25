class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int n = height.length;
        int right=n-1;
        int maxw=0;
        while(left<right){
            int width= right-left;
            int h = Math.min(height[left], height[right]);
            int area = width*h;
            maxw = Math.max(maxw,area);
            if(height[left]<height[right]){
                left++;}
                else{
                    right--;
                }

            
        }
        return maxw;
    }
}