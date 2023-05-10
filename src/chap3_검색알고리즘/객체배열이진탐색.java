package chap3_검색알고리즘;

import java.util.Arrays;

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	// 생성자 만들기
	PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	// compareTo override
	public int compareTo(PhyscData obj) {
		if (this.name.compareTo(obj.name) == 0)
			return Integer.compare(this.height, obj.height);
		else if (this.height == obj.height)
			return Double.compare(this.vision, obj.height);
		else if (this.vision == obj.vision)
			return 0;

		else
			return this.name.compareTo(obj.name);
	}

	public String toString() {
		return "name : " + name + ", height : " + height + ", vision : " + vision;
	}
}

public class 객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		showData(data);
		sortData(data);
		System.out.println("sort arr : ");
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key); // data[0]번부터 순서대로 key값이랑 비교해서 data[i]==key인 index값 찾기
		System.out.println("\nlinearSearch(): result = " + result);

		key = new PhyscData("길동", 167, 0.5);
		result = binarySearch(data, key); // 이진탐색
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

	// showData()
	static void showData(PhyscData[] arr) {
		System.out.println();
		for (PhyscData fruit : arr) {
			System.out.println(fruit);
		}
		System.out.println();
	}

	// 배열정렬 함수 만들기
	static void swap(PhyscData[] arr, int i, int j) {
		PhyscData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// sortData() : arr 정렬
	static void sortData(PhyscData arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					swap(arr, i, j); // swap() 호출
				}
			}
		}
	}

	// linearSearch()
	static int linearSearch(PhyscData arr[], PhyscData key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(key) == 0)
				return i;
		}
		return -1;
	}

	// binarySearch()
	static int binarySearch(PhyscData arr[], PhyscData key) {
		int low = 0; // 첫번째 idx
		int high = arr.length - 1; // 마지막 idx
		while (low <= high) {
			int mid = (low + high) / 2; // 중간값
			if (arr[mid].compareTo(key) == 0) {
				return mid; // arr[mid]==key일 떄, 중간값의 idx 반환
			} else if (arr[mid].compareTo(key) < 0)
				low = mid + 1; // arr[mid]<key일때 low값을 중간값 + 1로 바꿔줌(0~중간값까지 확인할 필요 없음)

			else
				high = mid - 1;
		}
		return -1;
	}
}
