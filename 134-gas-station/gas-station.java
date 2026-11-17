class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start =0;
        int curr_cost = 0 ; 
        int total = 0;
        int n = gas.length;
        for(int i=0;i<n;i++){
            curr_cost += gas[i]-cost[i];
            total += gas[i] - cost[i] ; 
            if(curr_cost<0){
                curr_cost=0;
                start = i+1;
            }
        }
        if(total<0){
            return -1;
        }
        return start;
    }
}