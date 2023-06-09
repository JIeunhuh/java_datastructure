package chap5_재귀알고리즘;

import java.util.Scanner;
import java.util.Stack;

//재귀 알고리즘의 비재귀적 표현(재귀 호출을 사용하지 않고 비재귀적으로 구현)
public class recurx2 {
	static void recur(int n) { // 앞쪽에서 호출하는 재귀함수를 제거(stack 이용)
		Stack<Integer> stack = new Stack<>();

		while (true) {
			if (n > 0) {
				try {
					stack.push(n);
					System.out.println("recur(" + (n - 1) + ")");
					n = n - 1;
					continue;
				} catch (StackOverflowError e) {
					System.out.println("스택이 가득 찼습니다!");
				}
			}
//			if (stack.isEmpty() != true)
			if (!stack.isEmpty()) {
				try {
					n = stack.pop();
					System.out.println(n);
					System.out.println("recur(" + (n - 2) + ")");
					n = n - 2;
					continue;
				} catch (StackOverflowError e) {
					e.printStackTrace();
				}
			}
			break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요 : ");
		int x = sc.nextInt();

		recur(x);
	}
}
