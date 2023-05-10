package chap2_기본자료구조.Random;

import java.util.Random;

public class 이차원배열 {
	// 난수 생성해서 2차원 배열 만들기
	static void getData(int arr[][]) {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = rand.nextInt(10);
			}
		}
	}

	// 난수 생성해서 2차원 배열 만들기
	static void showData(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

	// 행렬 덧셈
	static void addMatrix(int arr[][], int arr1[][], int sum[][]) {
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				sum[i][j] = (arr[i][j] + arr1[i][j]);
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// 행렬 곱셈
	static void multipleMatrix(int arr[][], int arr1[][], int sum[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				for (int k = 0; k < arr1.length; k++) {
					sum[i][j] += (arr[i][k] * arr1[k][j]);
				}
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] A1 = new int[2][3];
		int[][] A2 = new int[2][3];
		int[][] sumarr = new int[2][4];

		getData(A);
		getData(B);
		// getData(A1);
		// getData(A2);
		
		showData(A);
		showData(B);
		// showData(A1);
		// showData(A2);
		
		// 덧셈 함수 호출
		// addMatrix(A1, A2, sumarr);
		
		// 곱셈 함수 호출
		multipleMatrix(A, B, sumarr);
	}
}
