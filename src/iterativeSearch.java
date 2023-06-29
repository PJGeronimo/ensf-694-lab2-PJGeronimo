import java.util.Scanner;
import java.util.Arrays;

public class iterativeSearch {

	public static int linearSearch(int [] array, int key) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
		} return -1;
	}
	
	public static int interpolationSearch(int [] array, int key) {
		int low = 0;
		int high = array.length - 1;
		double pos;
		int mid;
		Arrays.sort(array);
		
		while (low <= high) {
			pos = ((double)key - array[low]) / ((double)array[high] - array[low]);
			mid = low + (int)((high - low) * pos);
			if(key < array[mid]) {
				high = mid - 1;
			}
			else if (array[mid] < key){
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int linSearchImprove(int [] array, int key) {
		int j = array.length - 1;
		for(int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
			if (array[j] == key) {
				return j;
			} 
			j--;
		} return -1;
	}
	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int arraySize = reader.nextInt();
		
		int [] values = new int [arraySize];
		
		System.out.println("Enter the elements in the array: ");
		for (int i = 0; i < arraySize; i++) {
			values[i] = reader.nextInt();
		}
		
		System.out.println("Enter the search key: ");
		int searchKey = reader.nextInt();
		reader.close();
		
		double linearStartTime = System.nanoTime();
		int linearResult = linearSearch(values, searchKey);
		if (linearResult != -1) {	
			System.out.println("LINEAR:\nSearch key found at index " + linearResult);
			} else System.out.println("Search key not found.");
		double linearEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((linearEndTime- linearStartTime) / 1000000) + " milliseconds.\n");
		
		double interStartTime = System.nanoTime();
		int interpolationResult = interpolationSearch(values, searchKey);
		if (interpolationResult != -1) {	
			System.out.println("INTERPOLATION:\nSearch key found at index " + linearResult);
			} else System.out.println("Search key not found.");
		double interEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((interEndTime- interStartTime) / 1000000) + " milliseconds.\n");
		
		double linImpStartTime = System.nanoTime();
		int linImpResult = linSearchImprove(values, searchKey);
		if (linImpResult != -1) {	
			System.out.println("LINEAR IMPROVED:\nSearch key found at index " + linImpResult);
			} else System.out.println("Search key not found.");
		double linImpEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((linImpEndTime- linImpStartTime) / 1000000) + " milliseconds.\n");
	}
	
		
}


