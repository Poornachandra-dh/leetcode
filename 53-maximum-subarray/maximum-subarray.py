class Solution(object):
    def maxSubArray(self, nums):
        sum=0
        maxi=nums[0]
        for i in range(len(nums)):
            sum+=nums[i]
            maxi = max(maxi,sum)
            if sum<0:
                sum=0
        return maxi
        