package chap4_스택과큐;

public class 스택만들기 {
	private int[] stack; //스택용 배열
	private int capacity; //스택용량
	private int ptr; //스택 포인터

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	public class OverFlowIntStackException extends RuntimeException {
		public OverFlowIntStackException() {
		}
	}

	public 스택만들기(int maxlen) {
		// TODO Auto-generated constructor stub
		ptr=0;
		capacity = maxlen;
		try {
			stack = new int[capacity];
		}catch(OutOfMemoryError e) {
			capacity =0;
		}
	}
	
	//stack에 x를 푸시
	public int push(int x) {
		if(ptr >=capacity)
			throw new OverFlowIntStackException();
		return stack[ptr++]=x;
	}
	
	//스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException{
		if(ptr <= capacity)
			throw new EmptyIntStackException();
		return stack[--ptr];
	}
	//스택에서 데이터를 피크(꼭대기에 있는 데이터를 들여다 봄)
	public int peek() throws EmptyIntStackException{
		if(ptr <= 0)
			throw new EmptyIntStackException();
		return stack[ptr-1];
	}
	
	//스택을 비움
	public void clear() {
		ptr=0;
	}
	//스택에서 x를 찾아 인덱스(없으면 -1)을 반환 
	public int indexOf(int x) {
		for (int i=ptr-1; i>=0;i--)
			if(stack[i]==x)
				return i;
		return -1;
	}
	
	//스택이 비어있는가>
	public boolean isEmpty() {
		return ptr <=0;
	}
	
	//스택이 가득 찼는가
	public boolean isFull() {
		return ptr >= capacity;
	}
	
	//스택에 쌓여있는 데이터 갯수를 반환
	public int size() {
		return ptr;
	}
	
	//스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
	public void dump() {
		if(ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for(int i=0; i<ptr; i++)
				System.out.println(stack[i]+" ");
			System.out.println();
		}
	}
	
}
