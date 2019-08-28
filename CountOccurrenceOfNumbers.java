//Blaise Bowman, COP3530 Project 4 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/* (Count the occurrences of numbers entered) Write a program that reads an unspecified
number of integers and finds the one that has the most occurrences. The input ends when the
input is 0. For example, if you entered 2 3 40 3 5 4 –3 3320, the number 3 occurred most
often. If not one but several numbers have the most occurrences, all of them should be
reported. For example, since 9 and 3 appear twice in the list 9 30 3 9 3 2 4, both occurrences
should be reported*/

public class CountOccurrenceOfNumbers {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Map<Integer, Integer> nums = new TreeMap<>();
		while (true) {
			System.out.print("Enter an Integer (Enter 0 to stop input): ");
			int num = scan.nextInt(); // accepts integer input from the user
			if (num == 0) { // ends the input when the user enters 0.
				break; // ends the while loop
			}
			if (!nums.containsKey(num)) { // if the number is not already in the
											// tree
				nums.put(num, 1);
			} else { // if the number is already in the tree
				int value = nums.get(num);
				value++; // increments value (the number of occurrences of a
							// num)
				nums.put(num, value);
			}
		}

		// Get all entries into a set
		Set<Map.Entry<Integer, Integer>> entrySet = nums.entrySet();
		// Get key and value from each entry

		System.out.println('\n' + "Below are the entered integers, preceded by their number of occurences: ");
		for (Map.Entry<Integer, Integer> entry : entrySet)
			System.out.println(entry.getValue() + "\t" + entry.getKey());

		System.out.print('\n');
		int maxFreq = mostFreqVal(nums);
		List<Integer> maxFreqArray = freqList(nums, maxFreq);
		if (maxFreqArray.size() == 1) {
			System.out.println("The number with the most occurrences is: ");
			System.out.printf("%s", maxFreqArray.get(0));
			System.out.println(", which occurs " + maxFreq + " time.");
		}

		else {
			System.out.print("The numbers with the most occurrences are: ");
			for (int i = 0; i < maxFreqArray.size(); i++) {
				if (i == maxFreqArray.size() - 1) {
					System.out.printf("%s", maxFreqArray.get(i));
				} else {
					System.out.printf("%s", maxFreqArray.get(i) + " and ");
				}
			}
			System.out.println(", which occur " + maxFreq + " times.");
		}
	}

	public static int mostFreqVal(Map<Integer, Integer> a) {
		int mostFreq = 0;
		int mostFreqCount = -1;
		for (int i = 0; i < a.size(); i++) {
			Integer count = a.get(i);
			a.put(i, count = (count == null ? 1 : count + 1));
			// maintain the most frequent in a single pass.
			if (count > mostFreqCount) {
				mostFreq = i;
				mostFreqCount = count;
			}
		}
		return mostFreq;
	}

	public static List<Integer> freqList(Map<Integer, Integer> a, int maxFreq) {
		Set<Map.Entry<Integer, Integer>> entrySet = a.entrySet();
		List<Integer> mostFreqArray = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() == maxFreq) {
				mostFreqArray.add(entry.getKey());
				// System.out.println(entry.getKey());
			} else {
				// do nothing
			}
		}
		return mostFreqArray;
	}
}
