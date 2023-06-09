package chap5_재귀알고리즘;

import java.util.Scanner;

public class Recur {
	// 재귀 함수
	static void recur(int n) {
		if (n > 0) { //stack에 쌓이기 때문에 가장 나중에 들어간 n값부터 다시 나옴 !
			System.out.println("recur(" + (n - 1) + ")");
			recur(n - 1);
			System.out.println(n);
			System.out.println("recur(" + (n - 2) + ")");
			recur(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int x = sc.nextInt();

		recur(x);
	}
}
