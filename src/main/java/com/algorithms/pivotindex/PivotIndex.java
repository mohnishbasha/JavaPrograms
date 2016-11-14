package com.algorithms.pivotindex;



public class PivotIndex {

    public int findPivot(int a[])
    {
        int leftSum=0, rightSum=0;

        for(int i=0; i < a.length; i++){
            rightSum+=a[i];
        }

        for(int i=0;i<a.length;i++){
            rightSum-=a[i];

            if(leftSum == rightSum)
                return i;
            leftSum+=a[i];
        }
        return -1;
    }

    public int findPivot1(int[] nums){
        if(nums.length == 0){
            return -1;
        }

        int sumLeft = nums[0];
        int sumRight = 0;
        int left = 0, right = nums.length ;

        while( left <= right  ) {

            if(sumLeft > sumRight) {
                sumRight += nums[--right];
            } else if(sumLeft < sumRight) {
                sumLeft += nums[++left];
            } else {
                if(left+1 == right-1){
                    return left+1;
                }

                if( nums[right-1] == 0){
                    right--;
                } else if(nums[left+1] == 0){
                    left++;
                }else {
                    sumRight += nums[right--];
                    sumLeft += nums[left++];
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr [] ={1,2,3,4,0,6};
        PivotIndex p = new PivotIndex();
        System.out.println("Pivot Index 1: " + p.findPivot(arr));
        System.out.println("Pivot Index 2: " + p.findPivot1(arr));

    }


}