package com.algorithms.pivotindex;

// A Pivot Index (or Equilibrium Index) is a position in an array where the sum of all elements to the left equals 
// the sum of all elements to the right. Let me explain with the code and examples:
// Example: [1, 2, 3, 4, 0, 6]
//          ↑       ↑       ↑
// Index:   0       3       5

// At index 3 (value 4):
// - Left sum  = 1 + 2 + 3 = 6
// - Right sum = 0 + 6 = 6
// Therefore, index 3 is the pivot index

public class PivotIndex {

    public int findPivot(int[] array)
    {
        int leftSum=0, rightSum=0;

        for(int i=0; i < array.length; i++){
            rightSum = rightSum + array[i];
        }

        for(int i=0;i<array.length;i++){
            rightSum = rightSum - array[i];

            if(leftSum == rightSum)
                return i;
            leftSum = leftSum + array[i];
        }
        return -1;
    }

    public int findPivot1(int[] array){
        if(array.length == 0){
            return -1;
        }

        int leftSum = array[0];
        int rightSum = 0;

        int left = 0, right = array.length ;

        while( left <= right  ) {

            if(leftSum > rightSum) {
                rightSum += array[--right];
            } else if(leftSum < rightSum) {
                leftSum += array[++left];
            } else {
                if(left+1 == right-1){
                    return left+1;
                }

                if( array[right-1] == 0){
                    right--;
                } else if(array[left+1] == 0){
                    left++;
                }else {
                    rightSum += array[right--];
                    leftSum += array[left++];
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