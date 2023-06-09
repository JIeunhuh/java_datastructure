package chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class objectStack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	public class EmptyGenericStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EmptyGenericStackException() {
		}
	}

	public class OverflowGenericStackException extends RuntimeException {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public OverflowGenericStackException() {
		}
	}

	public objectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// stack에 x를 푸시
	public int push(Point x) throws OverflowGenericStackException {
		if (top >= capacity)
			throw new OverflowGenericStackException();
		{
			data.add(x);
			top++;
			return 1;
		}
	}

	// 스택에서 데이터를 팝
	public Point pop() throws EmptyGenericStackException {
		if (top <= 0)
			throw new EmptyGenericStackException();

		// Point p =data.get(top-1);
		Point p = data.remove(top - 1);
		top--;
		return p;

		// return data[--top];

	}

	// 스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다 봄)
	public Point peek() throws EmptyGenericStackException {
		if (data.equals(0)) // object형 객체 비교할 때 사용
			throw new EmptyGenericStackException();
		return data.get(top - 1);
		// return .data[top - 1];
	}

	// 스택에 쌓여있는 데이터 갯수를 반환
	public int size() {
		return top;
	}

	// 스택을 비움
	public void clear() {
		top = 0;
	}

	// 스택에서 x를 찾아 인덱스(없으면 -1)을 반환
	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--)
			if (data.get(i).equals(x))
				return i;
		return -1;
	}

	// 스택이 비어있는가
	public boolean isEmpty() {
		return top <= 0;
	}

	// 스택의 용량을 반환
	public int getCapacity() {
		return capacity;
	}
	
	// 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		
		if (isEmpty())
			// if(ptr <= 0)
			System.out.println("stack이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.println(data.get(i)+ " ");
			System.out.println();
		}
	}
	
//	public String toString() {
//		return 
//	}

}

class Point {
	private int ix;
	private int iy;

	public Point(int ix, int iy) {
		this.ix = ix;
		this.iy = iy;
	}

	@Override
	public boolean equals(Object p) {
		Point px = (Point) p;
		if (this.ix == ((Point) p).ix && this.iy == px.iy)
			return true;
		return false;
	}
	
	public String toString() {
		return this.ix+" "+this.iy;
	}
}

public class 스택객체만들기 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectStack s = new objectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.println("데이터: ");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				try {
					s.push(p);
				} catch (objectStack.OverflowGenericStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.print("pop한 데이터는 " + p + "입니다.");
				} catch (objectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (objectStack.EmptyGenericStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	stdIn.close();
	}
}