package countingInversionsPackage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class InversionNumbers {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in); 
		
		System.out.println(" Enter the integers ");
		
		
        int numOfIntegers = in.nextInt();
        int [] listOfIntegers = new int[numOfIntegers];
        
        
        for (int i = 0; i < listOfIntegers.length; i++) {
        	listOfIntegers[i] = in.nextInt();
		}
		
		int numInversions = countNumInversions(listOfIntegers, 0, numOfIntegers );
		
		System.out.println("the number of inversions " + numInversions);
		
		
		//we need to use the ONlogN implementation for the counting algorithms
	}
	
	public static int countNumInversions(int[] listOfIntegers, int leftArray, int rightArray) {
		int numInversions = 0;
		
        if (leftArray < rightArray) { 
            int middle = (leftArray + rightArray) / 2; 
  
            numInversions += countNumInversions(listOfIntegers, leftArray, middle); 
  
            numInversions += countNumInversions(listOfIntegers, middle + 1, rightArray); 
  
            numInversions += mergeAndCount(listOfIntegers, leftArray, middle, rightArray); 
        } 
  
		
		return numInversions;
	}
	
	
    private static int mergeAndCount(int[] arr, int l, int m, int r) 
    { 
    	
    	//chnage the method name and the variable names to customize them to your own functionality
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 

}
