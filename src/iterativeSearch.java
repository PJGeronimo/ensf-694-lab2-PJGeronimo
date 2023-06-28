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
		int pos; //= (key - array[low]) / (array[high] - array[low]);
		int mid; //= low + ((high - low) * pos);
		Arrays.sort(array);
		
		while (low <= high) {
			pos = (key - array[low]) / (array[high] - array[low]);
			mid = low + ((high - low) * pos);
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
		System.out.println("Linear: Search key found at index " + linearResult);
		} else System.out.println("Search key not found.");
		double linearEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((linearEndTime- linearStartTime)/1000000) + " milliseconds.");
		
		double interStartTime = System.nanoTime();
		int interpolationResult = interpolationSearch(values, searchKey);
		if (interpolationResult != -1) {	
			System.out.println("Interpolation: Search key found at index " + linearResult);
			} else System.out.println("Search key not found.");
		double interEndTime = System.nanoTime();
		System.out.println("Execution time: " + ((interEndTime- interStartTime)/1000000) + " milliseconds.");
	}
	
		
}


