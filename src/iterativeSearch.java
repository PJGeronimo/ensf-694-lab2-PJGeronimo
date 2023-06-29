import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Paolo Geronimo
 * ENSF 694 Lab 2, June 28, 2023
 *
 */
public class iterativeSearch {

	/* 
	 * class linearSearch is the regular linear search algorithm.
	 * arguments are an array integer to be searched, and a key to be searching for.
	 * return value is the index of the key value if found, or -1 if not found.
	 */
	public static int linearSearch(int [] array, int key) {
		// for loop iterates for each value in the array in the order they appear
		// until either key is found or end of array is reached
		for(int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; // key found, return index
			}
		} return -1; // if for loop completes without finding key in array
	}
	/*
	 * class interpolationSearch is the regular interpolation search algorithm.
	 * arguments are an array integer to be searched, and a key to be searching for.
	 * return value is the index of the key value if found, or -1 if not found.
	 */
	public static int interpolationSearch(int [] array, int key) {
		// defining variables to be used in formula
		int low = 0;
		int high = array.length - 1;
		double pos;
		int mid;
		
		Arrays.sort(array); // interpolation search only works on a sorted array
		
		while (low <= high) { // while there are still values to be searched between
			// applying formulas for the algorithm
			pos = ((double)key - array[low]) / ((double)array[high] - array[low]);
			mid = low + (int)((high - low) * pos);
			
			if(key < array[mid]) {
				high = mid - 1; // change high point if key is in the left "sub array"
			}
			else if (array[mid] < key){
				low = mid + 1; // change low point if key is in the right "sub array"
			}
			else {
				return mid; // key found, return index
			}
		}
		return -1; // key not found
	}
	
	/* 
	 * class linSearchImpro is the improved linear search algorithm.
	 * the major change is introducing the j variable, used to iterate through the array
	 * starting from the end, while i iterates from the beginning.
	 * arguments are an array integer to be searched, and a key to be searching for.
	 * return value is the index of the key value if found, or -1 if not found.
	 */
	public static int linSearchImprove(int [] array, int key) {
		int j = array.length - 1; // variable j initialized to last index of array
		
		// now the for loop checks 2 values simultaneously using i and j
		for(int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i; // key found, return index
			}
			if (array[j] == key) { // check if index j matches key
				return j; // key found, return index
			} 
			j--; // decrement j to check next value
		} return -1; // key not found
	}
	
	
	public static void main(String[] args) {
		// scanner used to read user inputs
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		
		// first user input is the desired size of the array
		int arraySize = reader.nextInt();
		int [] values = new int [arraySize];
		
		System.out.println("Enter the elements in the array: ");
		// for loop allows the user to enter integers only until the array is filled
		for (int i = 0; i < arraySize; i++) {
			values[i] = reader.nextInt();
		}
		
		// prompt user for search key
		System.out.println("Enter the search key: ");
		int searchKey = reader.nextInt();
		reader.close();
		
		// results for linear algorithm
		double linearStartTime = System.nanoTime(); // record starting time
		int linearResult = linearSearch(values, searchKey); // call method
		if (linearResult != -1) { // if return value is not -1 ie key is found	
			System.out.println("LINEAR:\nSearch key found at index " + linearResult);
			} else System.out.println("Search key not found.");
		double linearEndTime = System.nanoTime(); // record end time
		// execution time is end time - start time
		// divide by 1000000 to convert from nanoseconds to milliseconds
		System.out.println("Execution time: " + ((linearEndTime- linearStartTime) / 1000000) + " milliseconds.\n");
		
		// results for interpolation algorithm
		// code follows the same structure as above
		double interStartTime = System.nanoTime();
		int interpolationResult = interpolationSearch(values, searchKey);
		if (interpolationResult != -1) {	
			System.out.println("INTERPOLATION:\nSearch key found at index " + linearResult);
			} else System.out.println("Search key not found.");
		double interEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((interEndTime- interStartTime) / 1000000) + " milliseconds.\n");
		
		// results for improved linear algorithm
		// code follows the same structure as above
		double linImpStartTime = System.nanoTime();
		int linImpResult = linSearchImprove(values, searchKey);
		if (linImpResult != -1) {	
			System.out.println("LINEAR IMPROVED:\nSearch key found at index " + linImpResult);
			} else System.out.println("Search key not found.");
		double linImpEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((linImpEndTime- linImpStartTime) / 1000000) + " milliseconds.\n");
	}
	
		
}


