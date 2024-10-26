class Solution {
    public void sortColors(int[] nums) {
        //Dutch flag Algorithm
        //only works when we have three different integers
        //low = index to keep track of Zero's
        //high = index to keep track of Two's
        //one will be sorted when low and high are sorted
        //run the loop until we cross the high index
        //mid = traversing the element in an array
        //if mid==0 replace the element at index low with the element at index mid and increase both index
        //if mid == 1 just increment the mid
        //if mid==2 replace the element at mid index with the element at the high index then decrease high index(because it is sorted now at that index)
        int n= nums.length-1;
        int low=0;
        int high=n;
        int mid =0;
        while(mid <= high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                mid++;
                low++;
            }else if(nums[mid]==1) mid++;
            else{
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
