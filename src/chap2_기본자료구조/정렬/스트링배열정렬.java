package chap2_기본자료구조.정렬;

import java.util.Random;
import java.util.Scanner;

public class 스트링배열정렬 {


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

	static void sortData(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].compareTo(arr[j])>0) { //string array는 .compareTo이용 !!
					swap(arr, i, j); //swap() 호출 ; arr 바꿔주는 거 아님 !!!!!!
				}
			}
			System.out.print(arr[i]+" "); 
		}
	}

	public static void main(String[] args) {
		String[] data = {"감","사과","포도","딸기","수박","참외","배"};

		showData(data);
		sortData(data);
	}
}
