/*
 * Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
 * Assignment name: Lab4
*/
import java.util.Random;
public class Lab4 {

	private static int[] generateSortedArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}
		return array;
	}

	private static int[] generateUnsortedArray(int size) {
		Random rand = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = rand.nextInt(1000000);
		}
		return array;
	}
	
	public static int BinarySearch(int arr[], int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == target)
				return mid;
			else if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static int linearSearch(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}

	public static void Tests() {
		int[][] sortedArray = { { 3, 45, 78, 123, 150 }, 
				{ 4, 18, 36, 72, 91, 104, 158, 199 },
				{ 2, 14, 28, 56, 72, 89, 100, 145, 178, 199 },
				{ 1, 22, 35, 48, 59, 64, 77, 88, 99, 110, 121, 132, 143, 154, 165 },
				{ 5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190 } };
		for (int i = 0; i < sortedArray.length; i++) {
			int[] Array = sortedArray[i];
			switch (i) {
			case 0:
				System.out.println("Binary Search on [3, 45, 78, 123, 150]: Element 78 found at index "
						+ BinarySearch(Array, 78, 0, Array.length - 1));
				break;
			case 1:
				System.out.println("Binary Search on [4, 18, 36, 72, 91, 104, 158, 199]: Element 104 found at index "
						+ BinarySearch(Array, 104, 0, Array.length - 1));
				break;
			case 2:
				System.out.println("Binary Search on [2, 14, 28, 56, 72, 89, 100, 145, 178, 199]: Element 76 found at index "
						+ BinarySearch(Array, 76, 0, Array.length - 1));
				break;
			case 3:
				System.out.println("Binary Search on [1, 22, 35, 48, 59, 64, 77, 88, 99, 110, 121, 132, 143, 154, 165]: Element 138 found at index "
						+ BinarySearch(Array, 1388, 0, Array.length - 1));
				break;
			case 4:
				System.out.println("Binary Search on [5, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, "
						+ "120, 130, 140, 150, 160, 170, 180, 190]: Element 201 found at index "
						+ BinarySearch(Array, 201, 0, Array.length - 1));
			}
		}

		int[][] unsortedArray = { { 150, 3, 78, 45, 123 }, 
				{ 158, 4, 91, 36, 18, 104, 72, 199 },
				{ 100, 199, 14, 28, 2, 145, 56, 89, 72, 178 },
				{ 121, 1, 99, 35, 154, 22, 48, 165, 59, 110, 132, 64, 77, 143, 88 },
				{ 130, 5, 100, 20, 50, 140, 10, 170, 190, 60, 40, 110, 150, 30, 160, 180, 70, 120, 80, 90 } };
		for (int i = 0; i < unsortedArray.length; i++) {
			int[] Array = unsortedArray[i];
			switch (i) {
			case 0:
				System.out.println(
						"Linear Search on [150, 3, 78, 45, 123]: Element 45 found at index " + linearSearch(Array, 45));
				break;
			case 1:
				System.out.println(
						"Linear Search on [158, 4, 91, 36, 18, 104, 72, 199]: Element 49 found at index " + linearSearch(Array, 49));
				break;
			case 2:
				System.out.println(
						"Linear Search on [100, 199, 14, 28, 2, 145, 56, 89, 72, 178]: Element 145 found at index " + linearSearch(Array, 145));
				break;
			case 3:
				System.out.println(
						"Linear Search on [121, 1, 99, 35, 154, 22, 48, 165, 59, 110, 132, 64, 77, 143, 88]: "
						+ "Element 169 found at index " + linearSearch(Array, 169));
				break;
			case 4:
				System.out.println(
						"Linear Search on [130, 5, 100, 20, 50, 140, 10, 170, "
						+ "190, 60, 40, 110, 150, 30, 160, 180, 70, 120, 80, 90]:"
						+ " Element 10 found at index " + linearSearch(Array, 10));
			}
		}
	}

	public static void main(String[] args) {
		Tests();
		System.out.println();
        Random rand = new Random();
        int[] ArraySizes = {10, 100, 500, 1000, 5000, 10000, 50000, 100000};
        
        System.out.println("Binary Search:");
        for (int size : ArraySizes) {
            int[] sortedArray = generateSortedArray(size);
            int target = sortedArray[rand.nextInt(size)]; 
            long startTime = System.nanoTime();
            BinarySearch(sortedArray, target, 0, size - 1);
            long endTime = System.nanoTime();
            System.out.println("Input size: " + size + ", Execution time: " + (endTime - startTime) + " nanoseconds");
        }

        System.out.println("Linear Search:");
        for (int size : ArraySizes) {
            int[] unsortedArray = generateUnsortedArray(size);
            int target = unsortedArray[rand.nextInt(size)];
            long startTime = System.nanoTime();
            linearSearch(unsortedArray, target);
            long endTime = System.nanoTime();
            System.out.println("Input size: " + size + ", Execution time: " + (endTime - startTime) + " nanoseconds");
        }
    }
}
