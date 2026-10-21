class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int  n = asteroids.length ; 
        
        for(int nums: asteroids){
            boolean alive = true ;
            while(!st.isEmpty() && st.peek()>0 && nums<0){
                if(st.peek()<-nums){
                    st.pop();
                }
                else if(st.peek()==-nums){
                    st.pop();
                    alive = false ; 
                    break ; 

                }
                else{
                    alive = false;
                    break ; 

                }

            }
            if(alive){
            st.push(nums);
        }
        }
        int[] ans = new int[st.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}