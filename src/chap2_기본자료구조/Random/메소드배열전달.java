package chap2_기본자료구조.Random;

import java.util.Random;
import java.util.Scanner;

public class 메소드배열전달 {
	static void getData(int arr[]) {
		// 난수 생성해서 배열에 입력
		Random num = new Random(); // 난수 생성
		for (int i = 0; i < arr.length; i++) {
			arr[i] = num.nextInt(10); // 변수명.nextInt(난수 범위?)
		}
	}

	static void showData(int arr[]) {
		// 난수 생성해서 배열에 입력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

	static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max <= arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	// sort 오름차순으로 행렬 정렬하기
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void sortData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] >= arr[j]) {
					swap(arr, i, j); //swap() 호출 ; arr 바꿔주는 거 아님 !!!!!!
				}
			}
			System.out.print(arr[i]+" "); 
		}
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		getData(data);
		showData(data);
		int mvalue = findMax(data);
		System.out.println("max = " + mvalue);
		sortData(data);
	}
}
