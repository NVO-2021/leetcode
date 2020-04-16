package org.example.othes;

/**
 * @Description:
 * @CreateDate: Created in 2020/4/16 13:19
 * @Author: gaofeng.zhang
 */
public class No287FindDuplicateNum {

    static class Solution {
        public int findDuplicate(int[] nums) {

            if(nums==null || nums.length<1){
                return -1;
            }

            //排序

            //比较趟数
            for (int i = 0; i < nums.length; i++) {

                int minPosition = i;
                //无序数组比较趟数
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j]<nums[minPosition]){
                        minPosition = j;
                    }
                }





                //在排序的过程中找到这个数
                if(i>0 && nums[minPosition] == nums[i-1]){
                    return nums[minPosition];
                }else{
                    //do swap
                    if(i!= minPosition){
                        int temp = nums[i];
                        nums[i] = nums[minPosition];
                        nums[minPosition] = temp;
                    }
                }
            }

            return -1;

        }




    }


    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3, 5,2};
//        int duplicate = new Solution().findDuplicate(nums);
//        System.out.println(duplicate);
        int p = nums[0];
        for (;;){
            p = nums[nums[p]];
            System.out.println(p);
        }



    }
}
