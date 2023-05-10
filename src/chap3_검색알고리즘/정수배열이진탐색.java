package chap3_검색알고리즘;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;

public class 정수배열이진탐색 {

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println("data : ");
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);

		key = 32;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}

	// inputData
	static void inputData(int arr[]) {
		Random ran = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = ran.nextInt(50);
	}

	// showData
	static void showData(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// sort 오름차순으로 행렬 정렬하기
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// sortData
	static void sortData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] >= arr[j]) {
					swap(arr, i, j);
				}
			}
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// linearSearch
	static int linearSearch(int data[], int key) {
		for(int i = 0; i<data.length; i++) {
			if(data[i]==key) {
				return i;
			}
		}
		return -1;
	}

	// binarySearch
	static int binarySearch(int data[], int key) {
		int low = 0;
		int high = data.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high)/2;
			if (data[mid] == key)
				return mid;
			else if (data[mid] < key)
				low = mid + 1;
			else if (data[mid] > key)
				high = mid - 1;
		}
		return -1;
	}

}
