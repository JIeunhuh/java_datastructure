package chap5_재귀알고리즘;

import java.util.Scanner;

public class Factorial {
	// 양의 정수 n의 p!값 반환
	static int factorial(int n) {
//		if (n > 0)
//			return n * factorial(n - 1); //recursive function(재귀함수 ; 자기자신을 포함시키거나 사용하는 함수)
//		else return 1;
		return (n > 0) ? n * factorial(n - 1) : 1;// 삼항연산자 사용
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요 : ");
		int x = sc.nextInt();

		System.out.println(x + "의 팩토리얼 값은 " + factorial(x) + "입니다.");
	}
}