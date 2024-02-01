
/*
 * name: Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
 * last modified at 31 Jan,2024
 * Assignment name: Lab1
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab1 {
	public static <T> List<T> createListWithoutElements(List<T> originList, T member) {
		List<T> newList = new ArrayList<>();
		for (T object : originList) {
			if (!object.equals(member)) {
				newList.add(object);
			}
		}
		return newList;
	}

	public static <T> void prettyPrint(List<T> List, int type) {
		int count = 0;
		switch (type) {
		case 1:
			System.out.println("Printing Integer List:");
			break;
		case 2:
			System.out.println("Printing Double List:");
			break;
		case 3:
			System.out.println("Printing String List:");
			break;
		case 4:
			System.out.println("Printing Integer, Double, and String List:");
			break;
		}
		for (T Object : List) {
			if (!Object.equals(null)) {
				count++;
				System.out.printf("Element %d: %s\n", count, Object);
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		System.out.println("Original List:" + array1);
		prettyPrint(array1, 1);
		array1 = createListWithoutElements(array1, 2);
		System.out.println("New List Without 2: " + array1);
		System.out.println();

		List<Double> array2 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0));
		System.out.println("Original List:" + array2);
		prettyPrint(array2, 2);
		array2 = createListWithoutElements(array2, 1.0);
		System.out.println("New List Without 1.0: " + array2);
		System.out.println();

		List<String> array3 = new ArrayList<>(Arrays.asList("abc", "def", "ghi"));
		System.out.println("Original List:" + array3);
		prettyPrint(array3, 3);
		array3 = createListWithoutElements(array3, "def");
		System.out.println("New List Without def: " + array3);
		System.out.println();

		List<Object> array4 = new ArrayList<>(Arrays.asList("abc", 1, 4.0));
		System.out.println("Original List:" + array4);
		prettyPrint(array4, 4);
		array4 = createListWithoutElements(array4, 4.0);
		System.out.println("New List Without 4.0: " + array4);
		System.out.println();
	}
}
