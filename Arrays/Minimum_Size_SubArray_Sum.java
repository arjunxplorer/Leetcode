class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //initialize left and right index, starting at 0
        //initialize total to be zero to store the sum from index left to right
        //result -> to store the minimal length of the subarray that adds up to the target
        //loop until the length of the array
        //add the sum
        //run a while loop to decrease the sum from the element at left index if sum is >= target and increase the left index
        //this will happen until the for loop stops and at final we will get the minimal length of subarray that adds upto the sum of target
        //if not then we will return 0

        int left=0;
        int total=0;
        int result=Integer.MAX_VALUE;

        for(int right=0; right < nums.length; right++){
            total+=nums[right];
            while(total >= target){
                result = Math.min(right-left+1, result);
                total-=nums[left];
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
