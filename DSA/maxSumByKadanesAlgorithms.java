/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class maxSumByKadanesAlgorithms
{
    public static void kadanesAlgorithm(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        
        for (int i=0 ;i<arr.length ;i++ ){
            currSum = currSum + arr[i];
            if (currSum<0){
                currSum = 0;
            } 
            maxSum = Math.max(currSum,maxSum);
        } 
        System.out.print(maxSum);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[] = {1,-3,2,-5,-1,5,6,-1,-4,4,3,-1};
		kadanesAlgorithm(arr);
	}
}
