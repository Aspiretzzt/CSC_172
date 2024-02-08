
/*
 * name: Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
 * Assignment name: Lab2
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab2 {
	private static <T> List<T> createWithoutElementsRec(List<T> list, T removedElement, int index,
			List<T> newArrayList) {
		if (list.size() != 0) {
			if (index < list.size()) {
				if (!list.get(index).equals(removedElement)) {
					newArrayList.add(list.get(index));
				}
				createWithoutElementsRec(list, removedElement, index + 1, newArrayList);
			}
		}
		return newArrayList;
	}

	public static <T> List<T> RemoveElements(List<T> list, T removedElement) {
		List<T> newArrayList = new ArrayList<>();
		newArrayList = createWithoutElementsRec(list, removedElement, 0, newArrayList);
		return newArrayList;
	}

	public static long seriesTerm(int n) {
		// Base cases: f(0) = 0, f(1) = 1
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			// Recursive case: f(n) = 2 * f(n-1) + 3 * f(n-2)
			return 2 * seriesTerm(n - 1) + 3 * seriesTerm(n - 2);
		}
	}

	public static long seriesTermTail(int n, int count, long last, long BeforeLast) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			if (count >= n)
				return last;
			return seriesTermTail(n, count + 1, 2 * last + 3 * BeforeLast, last);
		}
	}

	public static void testSeries(int n) {
		System.out.print("Testing for " + n + ": ");
		if (seriesTerm(n) == seriesTermTail(n, 1, 1, 0))
			System.out.println("true");
		else
			System.out.println("false");
	}

	public static void main(String[] args) {
		System.out.println("Task 1");
		List<Integer> firstList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			firstList.add(i);
		}
		firstList = RemoveElements(firstList, 2);
		System.out.println(firstList);

		List<Integer> secondList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			secondList.add(4);
		}
		secondList.add(2);
		secondList = RemoveElements(secondList, 4);
		System.out.println(secondList);

		List<String> thirdListList = List.of("a", "b", "c", "a");
		thirdListList = RemoveElements(thirdListList, "a");
		System.out.println(thirdListList);

		System.out.println("Task 2");
		for (int i = 0; i <= 10; i++) {
			testSeries(i);
		}

		System.out.println("Please input n: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i <= n; i++) {
			testSeries(i);
		}
	}
}
