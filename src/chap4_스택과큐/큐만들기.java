package chap4_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 큐만들기 {
	private List<Integer> que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

	public class EmptyGenericQueueException extends RuntimeException {
		public EmptyGenericQueueException() {
		}
	}

	public class OverflowGenericException extends RuntimeException {
		public OverflowGenericException() {
		}
	}

	public 큐만들기(int maxlen) {
		num = rear = front = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<Integer>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	// queue에 x를 인큐
	public int enque(Integer x) throws OverflowGenericException {
		if (num >= capacity)
			throw new OverflowGenericException();
		que.add(x);
		rear++;
		num++;
		if (rear == capacity) {
			rear = 0;
		}
		return x;
	}

	// 디큐(데이터 빼기)
	public Integer deque() throws EmptyGenericQueueException {
		if (num <= 0)
			throw new EmptyGenericQueueException();
		Integer x = que.remove(front);
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}

	public Integer peek() throws EmptyGenericQueueException {
		if ( num <=0 )
			throw new EmptyGenericQueueException();
		return que.get(rear-1);
		//return que.get(rear);
	}

	// queue에 쌓인 데이터 갯수 반환
	public int size() {
		return num;
	}

	// queue 비움
	public int clear() {
		return rear = 0;
	}

	// queue에서 x를 찾아 인덱스(없으면 -1) 반환
	public int indexOf(Integer x) {
		for (int i = rear; i <= 0; i--) {
			if (que.get(i).equals(x))
				return i;
		}
		return -1;
	}

	// queue 비어있는가
	public boolean imEmpty() {
		return rear <= 0;
	}

	public int getCapacity() {
		return capacity;
	}

	// queue안의 모든 데이터를 front -> rear 순으로 출력
	public void dump() {
		if (imEmpty())
			System.out.println("queue가 비어있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que.get((i+front)%capacity) + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		큐만들기 s = new 큐만들기(4); // 최대 64개를 인큐할 수 있는 큐

		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch (큐만들기.OverflowGenericException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (큐만들기.EmptyGenericQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (큐만들기.EmptyGenericQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
