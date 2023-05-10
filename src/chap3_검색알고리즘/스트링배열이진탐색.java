package chap3_검색알고리즘;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;

public class 스트링배열이진탐색 {

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "감", "배", "사과", "포도", "pear", "blueberry", "strawberry",
				"melon", "oriental melon" };

		showData(data);
		sortData(data);
		showData(data);

		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = "grape";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}
	//showData
	static void showData(String arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// sort 오름차순으로 행렬 정렬하기
	static void swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	//sortData
	static void sortData(String arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j); //swap() 불러오기
				}
			}
		}
	}
	//linearSearch(하나씩 비교해서 key값 찾기)
	static int linearSearch(String arr[], String key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	//binarySearch(이진탐색 이용)
	static int binarySearch(String arr[], String key) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid].compareTo(key) < 0) {
				low = mid + 1;
			} else
				high = mid - 1;

		}
		return -1;
	}
}
