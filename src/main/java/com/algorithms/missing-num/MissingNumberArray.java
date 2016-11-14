/*

 */

public class MissingNumberArray {


    public void missingNum(int arr[]) {

        // will be the sum of the numbers in the array.
        int sum = 0;
        int idx = -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
            {
                idx = i;
            }
            else
            {
                sum += arr[i];
            }
        }

        // the total sum of numbers between 1 and arr.length.
        int total = (arr.length + 1) * arr.length / 2;

        System.out.println("missing number is: " + (total - sum) + " at index " + idx);

    }


}